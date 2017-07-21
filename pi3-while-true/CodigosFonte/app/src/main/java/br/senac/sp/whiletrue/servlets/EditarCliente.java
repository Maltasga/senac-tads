
package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.Cliente;
import br.senac.sp.whiletrue.model.Endereco;
import br.senac.sp.whiletrue.model.ListasFixas;
import br.senac.sp.whiletrue.model.Util;
import br.senac.sp.whiletrue.servico.ClienteService;
import br.senac.sp.whiletrue.servico.EnderecoService;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author While True
 */
@WebServlet("/editar-cliente")
public class EditarCliente extends HttpServlet {

    ClienteService clienteService;
    EnderecoService enderecoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("q"));
            clienteService = new ClienteService();

            request.setAttribute("listaUf", ListasFixas.getUf());
            request.setAttribute("listaSexo", ListasFixas.getSexo());
            request.setAttribute("clientetoedit", clienteService.get(id));
            request.setAttribute("tituloCliente", "Manutenção de Cliente");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cliente/cadastrar.jsp");
            dispatcher.forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            clienteService = new ClienteService();
            enderecoService = new EnderecoService();

            int id = Integer.parseInt(request.getParameter("q"));
            String nome = request.getParameter("cliente");
            String cpf = request.getParameter("cpf");
            String sexo = request.getParameter("sexo");
            Date dataNascimento = Util.stringToDate(request.getParameter("nascimento"));
            
            String cep = request.getParameter("cep");
            String logradouro = request.getParameter("endereco");
            String complemento = request.getParameter("complemento");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String uf = request.getParameter("uf");

            Cliente novoCliente = new Cliente(id, nome, cpf, sexo, dataNascimento, true, null);

            int clienteID = clienteService.salvar(novoCliente);
            Endereco endereco = new Endereco(clienteID, "CLIENTE", logradouro, cep, complemento, bairro, cidade, uf);
            enderecoService.salvar(endereco);

            response.sendRedirect(request.getContextPath() + "/clientes");


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
