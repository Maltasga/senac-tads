/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.servico.ColecaoService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 'While true
 */
@WebServlet("/excluircolecao")
public class ExcluirColecao extends HttpServlet {
    
    ColecaoService service;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            service = new ColecaoService();
            int id = Integer.parseInt(request.getParameter("q"));
            service.excluir(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
