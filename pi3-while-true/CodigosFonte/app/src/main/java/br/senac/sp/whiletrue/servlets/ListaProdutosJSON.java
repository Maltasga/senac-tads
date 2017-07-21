package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.Produto;
import br.senac.sp.whiletrue.model.Usuario;
import br.senac.sp.whiletrue.servico.EstoqueService;
import br.senac.sp.whiletrue.servico.ProdutoService;
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
@WebServlet(urlPatterns = {"/getProdutos"})
public class ListaProdutosJSON extends HttpServlet {

    Gson gson = null;
    ProdutoService produtoService = null;
    EstoqueService estoqueService = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setHeader("cache-control", "no-cache");

        HttpSession sessao = request.getSession();
        Usuario usuarioLogado = (Usuario) sessao.getAttribute("usuarioLogado");
        if (usuarioLogado != null) {
            gson = new Gson();
            produtoService = new ProdutoService();
            estoqueService = new EstoqueService();
            ArrayList<Produto> produtos = produtoService.listarPorFilial(usuarioLogado.getIdFilial());
            for (Produto p : produtos) {
                p.setEstoque(estoqueService.listarPorProduto(p.getId(), usuarioLogado.getIdFilial()));
            }
            out.println(gson.toJson(produtos));
        }

        out.flush();
    }
}
