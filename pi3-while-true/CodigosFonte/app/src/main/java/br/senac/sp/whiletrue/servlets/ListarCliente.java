package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.Cliente;
import br.senac.sp.whiletrue.servico.ClienteService;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet("/clientes")
public class ListarCliente extends HttpServlet {

    ClienteService servico = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        servico = new ClienteService();
        ArrayList<Cliente> cliente = servico.listar();

        request.setAttribute("listaClientes", cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cliente/listagem.jsp");

        dispatcher.forward(request, response);
    }
}