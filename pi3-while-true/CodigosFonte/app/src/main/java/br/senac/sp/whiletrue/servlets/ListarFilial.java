/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.Filial;
import br.senac.sp.whiletrue.servico.FilialService;
import br.senac.sp.whiletrue.model.Endereco;
import br.senac.sp.whiletrue.servico.EnderecoService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet("/filiais")
public class ListarFilial extends HttpServlet {
    
    FilialService servicoFilial = null;
    //EnderecoService servicoEndereco = null;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        servicoFilial = new FilialService();
//        servicoEndereco = new EnderecoService();
        ArrayList<Filial> filiais = servicoFilial.listar();
//       ArrayList<Endereco> enderecos = new ArrayList<>();
//        for (Filial f : filiais) {
//            try {
//                enderecos.add(servicoEndereco.get(f.getId()));
//            } catch (Exception ex) {
//                Logger.getLogger(ListarFilial.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

        request.setAttribute("listaFiliais", filiais);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/filial/listagem.jsp");

        dispatcher.forward(request, response);
    }
    
}
