package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.Usuario;
import br.senac.sp.whiletrue.servico.UsuarioService;
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
@WebServlet("/usuarios")
public class ListarUsuario extends HttpServlet {

    UsuarioService servico = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        servico = new UsuarioService();
        ArrayList<Usuario> usuarios = servico.listar();

        request.setAttribute("listaUsuarios", usuarios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuario/listagem.jsp");

        dispatcher.forward(request, response);
    }
}