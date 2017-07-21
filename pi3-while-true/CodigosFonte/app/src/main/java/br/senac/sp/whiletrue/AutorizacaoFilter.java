/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.whiletrue;

import br.senac.sp.whiletrue.model.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Karol
 */
@WebFilter(filterName = "AutorizacaoFilter",
        urlPatterns = {"/cadastrar-cliente", "/cadastrar-filial", "/cadastrar-usuario", "/cadastrar-colecao", "/cadastrar-produto",
            "/editar-cliente", "/editar-filial", "/editar-usuario", "/editar-colecao", "/editar-produto",
            "/excluircliente", "/excluirfilial", "/excluirusuario", "/excluircolecao", "/excluirproduto",
            "/finalizar-venda", "/home", "/clientes", "/filiais", "/usuarios", "/venda", "/colecoes", "/produtos",
            "/rel-vendas-geral", "/estoque"})
public class AutorizacaoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession sessao = httpRequest.getSession();
        Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

        if (usuario == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }
        try {
            if (verificarAcesso(usuario, httpRequest, httpResponse)) {
                // Acesso a página está liberado.
                chain.doFilter(request, response);
            } else {
                // Usuário não tem permissão de acesso a página.
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/home");
            }

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static boolean verificarAcesso(Usuario usuario, HttpServletRequest request, HttpServletResponse response) {
        String paginaAcessada = request.getRequestURI();
        String pagina = paginaAcessada.replace(request.getContextPath(), "");

        int idPerfil = usuario.getIdPerfil();
        
        if(idPerfil == 500){
            return true;
        }

        if (pagina.endsWith("home")) {
            return true;
        }

        if (pagina.endsWith("usuarios")) {
            if (idPerfil == 100 || idPerfil == 101) {
                return true;
            }
            return false;
        }

        if (pagina.endsWith("cadastrar-cliente")) {
            if (idPerfil == 300 || idPerfil == 400) {
                return true;
            }
            return false;
        }

        if (pagina.endsWith("cadastrar-filial")) {
            if (idPerfil == 100 || idPerfil == 300) {
                return true;
            }
            return false;
        }

        if (pagina.endsWith("cadastrar-usuario")) {
            if (idPerfil == 100 || idPerfil == 101) {
                return true;
            }
            return false;
        }

        if (pagina.contains("editar-filial")) {
            if (idPerfil == 100 || idPerfil == 300) {
                return true;
            }
            return false;
        }

        if (pagina.contains("editar-usuario")) {
            if (idPerfil == 100 || idPerfil == 101) {
                return true;
            }
            return false;
        }

        if (pagina.endsWith("excluirfilial")) {
            if (idPerfil == 100 || idPerfil == 300) {
                return true;
            }
            return false;
        }

        if (pagina.endsWith("excluirusuario")) {
            if (idPerfil == 100 || idPerfil == 101) {
                return true;
            }
            return false;
        }

        if (pagina.endsWith("clientes")) {
            if (idPerfil == 300 || idPerfil == 400) {
                return true;
            }
            return false;
        }

        if (pagina.endsWith("filiais")) {
            if (idPerfil == 100 || idPerfil == 300) {
                return true;
            }
            return false;
        }

        if (pagina.endsWith("usuarios")) {
            if (idPerfil == 100 || idPerfil == 101) {
                return true;
            }
            return false;
        }

        if (pagina.endsWith("venda")) {
            if (idPerfil == 400) {
                return true;
            }
            return false;
        }

        if (pagina.endsWith("pdv-venda")) {
            if (idPerfil == 400) {
                return true;
            }
            return false;
        }

        if (pagina.contains("editar-cliente")) {
            if (idPerfil == 400) {
                return true;
            }
            return false;
        }

        if (pagina.contains("excluircliente")) {
            if (idPerfil == 400) {
                return true;
            }
            return false;
        }

        if (pagina.endsWith("produtos")) {
            if (idPerfil == 300) {
                return true;
            }
            return false;
        }

        if (pagina.endsWith("cadastrar-produto")) {
            if (idPerfil == 300) {
                return true;
            }
            return false;
        }

        if (pagina.contains("editar-produto")) {
            if (idPerfil == 300) {
                return true;
            }
            return false;
        }

        if (pagina.endsWith("colecoes")) {
            if (idPerfil == 300) {
                return true;
            }
            return false;
        }

        if (pagina.contains("editar-colecao")) {
            if (idPerfil == 300) {
                return true;
            }
            return false;
        }

        if (pagina.contains("excluircolecao")) {
            if (idPerfil == 300) {
                return true;
            }

            return false;
        }
        
        if (pagina.endsWith("rel-vendas-geral")) {
            if (idPerfil == 200){
                return true;
            }
            return false;
        }
        
        if (pagina.contains("estoque")){
                if(idPerfil == 300) {
                return true;
                }
                return false;
        }

        return false;
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
