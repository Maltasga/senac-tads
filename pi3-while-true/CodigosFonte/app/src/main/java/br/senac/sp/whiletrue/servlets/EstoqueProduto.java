/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.Estoque;
import br.senac.sp.whiletrue.model.Filial;
import br.senac.sp.whiletrue.model.ListasFixas;
import br.senac.sp.whiletrue.model.Produto;
import br.senac.sp.whiletrue.servico.EstoqueService;
import br.senac.sp.whiletrue.servico.FilialService;
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
@WebServlet("/estoque")
public class EstoqueProduto extends HttpServlet {

    EstoqueService service;
    ProdutoService serviceProduto;
    FilialService serviceFilial;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("q"));

        serviceProduto = new ProdutoService();
        serviceFilial = new FilialService();

        Produto p = serviceProduto.get(id);
        ArrayList<Filial> filiais = serviceFilial.listar();
        ArrayList<String> tamanhos = ListasFixas.getTamanhos();

        request.setAttribute("id", id);
        request.setAttribute("listaFilial", filiais);
        request.setAttribute("produto", p);
        request.setAttribute("tamanhos", tamanhos);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/produto/estoque.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        service = new EstoqueService();
        int id = Integer.parseInt(request.getParameter("id"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String tamanho = request.getParameter("tamanho");
        int idFilial = Integer.parseInt(request.getParameter("filial"));
        
        Estoque e = new Estoque(0, id, idFilial, tamanho, quantidade);
        
        service.inserir(e);
        
       // int id = Integer.parseInt(request.getParameter("id"));
        
        serviceProduto = new ProdutoService();
        serviceFilial = new FilialService();

        Produto p = serviceProduto.get(id);
        ArrayList<Filial> filiais = serviceFilial.listar();
        ArrayList<String> tamanhos = ListasFixas.getTamanhos();

        request.setAttribute("id", id);
        request.setAttribute("listaFilial", filiais);
        request.setAttribute("filialEstoque", idFilial);
        request.setAttribute("produto", p);
        request.setAttribute("tamanhos", tamanhos);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/produto/estoque.jsp");
                dispatcher.forward(request, response);

    }

}
