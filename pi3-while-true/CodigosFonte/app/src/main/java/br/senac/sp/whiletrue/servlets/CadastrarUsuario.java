package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.Usuario;
import br.senac.sp.whiletrue.servico.FilialService;
import br.senac.sp.whiletrue.servico.PerfilService;
import br.senac.sp.whiletrue.servico.UsuarioService;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet("/cadastrar-usuario")
public class CadastrarUsuario extends HttpServlet {

    UsuarioService userService;
    PerfilService perfilService;
    FilialService filialService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            perfilService = new PerfilService();
            filialService = new FilialService();
            request.setAttribute("listaPerfil", perfilService.listar());
            request.setAttribute("listaFilial", filialService.listar());

            request.getRequestDispatcher("/WEB-INF/usuario/cadastrar.jsp")
                    .forward(request, response);
        } catch (IOException | ServletException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            userService = new UsuarioService();
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            int idPerfil = Integer.parseInt(request.getParameter("perfil"));
            int idFilial = Integer.parseInt(request.getParameter("filial"));
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            boolean ativo = Boolean.parseBoolean(request.getParameter("ativo"));
            Date dataCadastro = GregorianCalendar.getInstance().getTime();
            Usuario novoUser = new Usuario(0, idPerfil, idFilial, nome, email, login, ativo, dataCadastro);
            novoUser.setSenha(senha);

            ArrayList<String> erros = userService.validar(novoUser);
            if (erros.isEmpty() == true) {
                novoUser.setHashSenha(novoUser.getSenha());
                userService.salvar(novoUser);
                response.sendRedirect(request.getContextPath() + "/usuarios");
            } else {
                perfilService = new PerfilService();
                filialService = new FilialService();
                request.setAttribute("listaPerfil", perfilService.listar());
                request.setAttribute("listaFilial", filialService.listar());
                request.setAttribute("errosValidacao", erros);
                request.setAttribute("userRet", novoUser);
                request.getRequestDispatcher("/WEB-INF/usuario/cadastrar.jsp")
                        .forward(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("msgFalha", ex.getMessage());
            request.getRequestDispatcher("/WEB-INF/falhaInesperada.jsp")
                    .forward(request, response);
        }
    }
}
