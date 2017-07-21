/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.ListasFixas;
import br.senac.sp.whiletrue.model.Produto;
import br.senac.sp.whiletrue.servico.ColecaoService;
import br.senac.sp.whiletrue.servico.ProdutoService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Karol
 */
@WebServlet("/cadastrar-produto")
public class CadastrarProduto extends HttpServlet {

    ProdutoService produtoService;
    ColecaoService colecaoService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            colecaoService = new ColecaoService();
            request.setAttribute("listaColecoes", colecaoService.listar());
            request.setAttribute("listaTipos", ListasFixas.getTipoProduto());
            request.setAttribute("listaCores", ListasFixas.getCorProduto());
            request.setAttribute("tituloProduto", "Cadastro de Produto");
            request.getRequestDispatcher("WEB-INF/produto/cadastrar.jsp")
                    .forward(request, response);
        } catch (IOException | ServletException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            produtoService = new ProdutoService();

            String codigo = request.getParameter("codigo");
            String nome = request.getParameter("produto");
            String descricao = request.getParameter("descricao");
            int idcolecao = Integer.parseInt(request.getParameter("colecao"));
            String tipo = request.getParameter("tipo");
            String cor = request.getParameter("cor");
            double valProd = Double.parseDouble(request.getParameter("valorProducao").replaceAll(",", "."));
            double valVenda = Double.parseDouble(request.getParameter("valorVenda").replaceAll(",", "."));
            Date dataCadastro = GregorianCalendar.getInstance().getTime();

            Produto novoProduto = new Produto(0, codigo, nome, descricao, idcolecao, tipo, cor, valProd, valVenda, true, dataCadastro);
            produtoService.salvar(novoProduto);

            response.sendRedirect(request.getContextPath() + "/produtos");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
