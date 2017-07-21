package br.senac.sp.controller;

import br.senac.sp.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Malta
 */
public class Autenticar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("usuario");
        Usuario usuario = new Usuario(user, "online");
        request.getSession().setAttribute("usuario", usuario);
        request.getRequestDispatcher("WEB-INF/chat.jsp")
                .forward(request, response);
    }
}
