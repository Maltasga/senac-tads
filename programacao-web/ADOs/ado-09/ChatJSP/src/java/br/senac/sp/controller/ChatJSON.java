package br.senac.sp.controller;

import br.senac.sp.model.Mensagem;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Malta
 */
public class ChatJSON extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ArrayList<Mensagem> conversa = (ArrayList) request.getServletContext().getAttribute("conversa");
        if (conversa != null) {
            Gson gson = new Gson();
            response.setContentType("application/json");
            response.setHeader("cache-control", "no-cache");
            out.println(gson.toJson(conversa));
            out.flush();
        } else {
            out.println("");
        }
        out.flush();
    }
}
