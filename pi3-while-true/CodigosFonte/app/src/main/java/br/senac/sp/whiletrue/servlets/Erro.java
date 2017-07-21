package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.servico.MenuService;
import br.senac.sp.whiletrue.servico.UsuarioService;
import java.io.IOException;
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
@WebServlet("/erro")
public class Erro extends HttpServlet {

    UsuarioService usuarioService;
    MenuService menuService = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/erroLogin.jsp");
            dispatcher.forward(request, response);
        } catch (IOException | ServletException ex) {
            ex.printStackTrace();
        }
    }
}
