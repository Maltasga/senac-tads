/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.Colecao;
import br.senac.sp.whiletrue.servico.ColecaoService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 'Gabi
 */
@WebServlet("/colecoes")
public class ListarColecao extends HttpServlet {

    ColecaoService servico = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        servico = new ColecaoService();
        ArrayList<Colecao> colecao = servico.listar();
        

        request.setAttribute("listaColecao", colecao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/colecao/listagem.jsp");

        dispatcher.forward(request, response);
    }
}