package br.senac.ado.podcast.projeto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabriel malta
 */
public class ListaServlet extends HttpServlet {

    ProdutoDAO dao = new ProdutoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("produtos", dao.getProdutos());

        request.getRequestDispatcher("/WEB-INF/produtos.jsp")
                .forward(request, response);
    }
}
