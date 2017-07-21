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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Karol
 */
@WebServlet("/editar-produto")
public class EditarProduto extends HttpServlet {

    ProdutoService service;
    ColecaoService colecaoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            service = new ProdutoService();
            colecaoService = new ColecaoService();

            int id = Integer.parseInt(request.getParameter("q"));

            request.setAttribute("produtotoedit", service.get(id));
            request.setAttribute("listaColecoes", colecaoService.listar());
            request.setAttribute("tituloProduto", "Manutenção de Produto");
            request.setAttribute("produtoid", service.get(id));
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/produto/editar.jsp");
            dispatcher.forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            service = new ProdutoService();

            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("produto");
            String descricao = request.getParameter("descricao");
            double valProd = Double.parseDouble(request.getParameter("valorProducao"));
            double valVenda = Double.parseDouble(request.getParameter("valorVenda"));

            Produto produto = new Produto(id, null, nome, descricao, 0, null, null, valProd, valVenda, true, null);

            service.salvar(produto);

            response.sendRedirect(request.getContextPath() + "/produtos");
        } catch (Exception ex) {
            Logger.getLogger(EditarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
