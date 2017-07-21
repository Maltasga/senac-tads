package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.Menu;
import br.senac.sp.whiletrue.model.Usuario;
import br.senac.sp.whiletrue.servico.MenuService;
import br.senac.sp.whiletrue.servico.UsuarioService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author While True
 */
@WebServlet(urlPatterns = {"/index.html", "/login"})
public class Login extends HttpServlet {

    private final String sessionMSG = "msgFalhaLogin";

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Verifica se usuário já se logou, se positivo redireciona para tela principal
        HttpSession sessao = request.getSession(false);
        if (sessao != null && sessao.getAttribute("usuarioLogado") != null) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/login/login.jsp")
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute(sessionMSG) != null) {
            request.getSession().setAttribute(sessionMSG, null);
        }

        UsuarioService usuarioService = new UsuarioService();
        String login = request.getParameter("usuario");
        String senhaDigitada = request.getParameter("senha");

        Usuario user = usuarioService.get(login);
        if (user != null) {
            if (Usuario.validarSenha(senhaDigitada, user.getSenha())) {
                HttpSession sessao = request.getSession(false);
                if (sessao != null) {
                    sessao.invalidate();
                }
                sessao = request.getSession(true);
                sessao.setAttribute("usuarioLogado", user);

                MenuService menuService = new MenuService();
                ArrayList<Menu> menus = menuService.listarPorPerfil(user.getIdPerfil());
                sessao.setAttribute("menus", menus);

                response.sendRedirect(request.getContextPath() + "/home");

            } else {
                request.getSession().setAttribute(sessionMSG, "Usuário e/ou senha inválidos.");
                response.sendRedirect(request.getContextPath() + "/login");
            }
        } else {
            request.getSession().setAttribute(sessionMSG, "Usuário não encontrado.");
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
