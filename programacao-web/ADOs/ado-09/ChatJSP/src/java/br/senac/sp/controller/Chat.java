package br.senac.sp.controller;

import br.senac.sp.model.Mensagem;
import br.senac.sp.model.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Malta
 */
public class Chat extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/chat.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Mensagem> conversa = (ArrayList) request.getServletContext().getAttribute("conversa");
        if (conversa == null) {
            conversa = new ArrayList<>();
            request.getServletContext().setAttribute("conversa", conversa);
        }
        String mensagem = request.getParameter("mensagem");
        if (mensagem != null && mensagem.length() > 1) {
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            Mensagem msg = new Mensagem(mensagem, usuario);
            conversa.add(msg);
        }
        request.getRequestDispatcher("WEB-INF/chat.jsp")
                .forward(request, response);

    }
}
