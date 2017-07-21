package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.servico.UsuarioService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author While True
 */
@WebServlet("/excluirusuario")
public class ExcluirUsuario extends HttpServlet {
    
    UsuarioService service;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            service = new UsuarioService();
            int id = Integer.parseInt(request.getParameter("q"));
            service.excluir(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
