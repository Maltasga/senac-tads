package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.Cliente;
import br.senac.sp.whiletrue.servico.ClienteService;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author While True
 */
@WebServlet(urlPatterns = {"/venda"})
public class PreVenda extends HttpServlet {

    private final String MSG_FALHA = "msgErro";
    ClienteService clienteService = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/pdv/prevenda.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");

        if (request.getSession().getAttribute(MSG_FALHA) != null) {
            request.getSession().setAttribute(MSG_FALHA, null);
        }

        if (cpf != null) {
            clienteService = new ClienteService();
            Cliente cliente = clienteService.get(cpf);
            if (cliente != null) {
                Date hoje = GregorianCalendar.getInstance().getTime();
                request.setAttribute("hoje", hoje);
                request.setAttribute("cliente", cliente);
                request.getRequestDispatcher("WEB-INF/pdv/caixa.jsp")
                        .forward(request, response);
            } else {
                request.getSession().setAttribute(MSG_FALHA, "Cliente não encontrado");
                response.sendRedirect(request.getContextPath() + "/venda");
            }
        }
    }
}
