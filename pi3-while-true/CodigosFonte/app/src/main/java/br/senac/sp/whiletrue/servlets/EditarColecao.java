/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.Colecao;
import br.senac.sp.whiletrue.model.ListasFixas;
import br.senac.sp.whiletrue.servico.ColecaoService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 'While true
 */
@WebServlet("/editar-colecao")
public class EditarColecao extends HttpServlet {

    ColecaoService colecaoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("q"));
            colecaoService = new ColecaoService();
            request.setAttribute("listaPeriodo", ListasFixas.getPeriodo());
            request.setAttribute("listaAno", ListasFixas.getAno());
            request.setAttribute("colecaotoedit", colecaoService.get(id));
            request.setAttribute("tituloColecao", "Manutenção de Coleção");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/colecao/cadastrar.jsp");
            dispatcher.forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            colecaoService = new ColecaoService();

            int id = Integer.parseInt(request.getParameter("q"));
            String nome = request.getParameter("colecao");
            String periodo = request.getParameter("periodo");
            int ano = Integer.parseInt(request.getParameter("ano"));

            Colecao novaColecao = new Colecao(id, nome, periodo, ano, true, null);
            colecaoService.salvar(novaColecao);
            response.sendRedirect(request.getContextPath() + "/colecoes");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
