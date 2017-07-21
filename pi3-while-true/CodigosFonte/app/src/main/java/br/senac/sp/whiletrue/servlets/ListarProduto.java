/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.Produto;
import br.senac.sp.whiletrue.servico.ProdutoService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet("/produtos")
public class ListarProduto extends HttpServlet {

    ProdutoService servico = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        servico = new ProdutoService();
        ArrayList<Produto> produtos = servico.listar();

        request.setAttribute("listaProdutos", produtos);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/produto/listagem.jsp");

        dispatcher.forward(request, response);
    }

}
