/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.Endereco;
import br.senac.sp.whiletrue.model.ListasFixas;
import br.senac.sp.whiletrue.servico.EnderecoService;
import br.senac.sp.whiletrue.servico.FilialService;
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
@WebServlet("/editar-filial")
public class EditarFilial extends HttpServlet {

    FilialService service;
    EnderecoService enderecoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("q"));
            service = new FilialService();
            enderecoService = new EnderecoService();

            request.setAttribute("filial", service.get(id));
            request.setAttribute("endereco", enderecoService.get(id, "FILIAL"));
            request.setAttribute("listaUF", ListasFixas.getUf());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/filial/editar.jsp");
            dispatcher.forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            enderecoService = new EnderecoService();
            int id = Integer.parseInt(request.getParameter("id"));
            String logradouro = request.getParameter("logradouro");
            String cep = request.getParameter("cep");
            String complemento = request.getParameter("complemento");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String uf = request.getParameter("uf");
            Endereco endereco = new Endereco(id, "FILIAL", logradouro, cep, complemento, bairro, cidade, uf);
            ArrayList<String> erros = enderecoService.validar(endereco);
            if (erros.isEmpty()) {
                enderecoService.salvar(endereco);
                response.sendRedirect(request.getContextPath() + "/filiais");
            } else {
                service = new FilialService();
                enderecoService = new EnderecoService();
                request.setAttribute("erros", erros);
                request.setAttribute("filial", service.get(id));
                request.setAttribute("endereco", enderecoService.get(id, "FILIAL"));
                request.setAttribute("listaUF", ListasFixas.getUf());
                int id2 = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("logradouro", endereco.getLogradouro());
                request.setAttribute("cep", endereco.getCep());
                request.setAttribute("complemento", endereco.getComplemento());
                request.setAttribute("bairro", endereco.getBairro());
                request.setAttribute("cidade", endereco.getCidade());
                request.setAttribute("uf", uf);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/filial/editar.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
