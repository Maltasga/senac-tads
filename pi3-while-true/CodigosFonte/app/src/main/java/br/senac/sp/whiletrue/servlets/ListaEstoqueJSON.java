package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.Estoque;
import br.senac.sp.whiletrue.model.Usuario;
import br.senac.sp.whiletrue.model.Util;
import br.senac.sp.whiletrue.servico.EstoqueService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = "/getEstoque")
public class ListaEstoqueJSON extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setHeader("cache-control", "no-cache");
        
        HttpSession sessao = request.getSession();
        Usuario usuarioLogado = (Usuario) sessao.getAttribute("usuarioLogado");
        String parameter = request.getParameter("q");
        
        if (usuarioLogado != null && !Util.isNullOrEmpty(parameter)) {
            EstoqueService service = new EstoqueService();
            int idProduto = Integer.parseInt(parameter);
            
            Gson gson = new Gson();
            ArrayList<Estoque> estoque = service.listarPorProduto(idProduto, usuarioLogado.getIdFilial());
            out.print(gson.toJson(estoque));
        }
        out.flush();
    }
}
