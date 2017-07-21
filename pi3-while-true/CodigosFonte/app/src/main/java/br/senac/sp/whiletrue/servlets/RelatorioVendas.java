/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.Filial;
import br.senac.sp.whiletrue.model.ListasFixas;
import br.senac.sp.whiletrue.model.Relatorio;
import br.senac.sp.whiletrue.model.Usuario;
import br.senac.sp.whiletrue.servico.FilialService;
import br.senac.sp.whiletrue.servico.RelatorioService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Karol
 */
@WebServlet("/rel-vendas-geral")
public class RelatorioVendas extends HttpServlet {

    FilialService filialService = null;
    RelatorioService service = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession sessao = httpRequest.getSession();
        filialService = new FilialService();
        Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
        Filial filialAtiva = filialService.get(usuario.getIdFilial());

        request.setAttribute("listaFiliais", filialService.listar());
        request.setAttribute("periodo", ListasFixas.getPeriodoRelatorio());
        request.setAttribute("filialAtiva", filialAtiva);
        request.getRequestDispatcher("/WEB-INF/relatorios/relatorios.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        filialService = new FilialService();
        RelatorioService relatorio = new RelatorioService();

        int paramFilial = Integer.parseInt(request.getParameter("filial"));
        String paramPeriodo = request.getParameter("periodo");

        ArrayList<br.senac.sp.whiletrue.model.Relatorio> vendas = new ArrayList<>();

        if (paramFilial == 0) {
            vendas = relatorio.listarTudo(paramPeriodo);
        } else {
            vendas = relatorio.listarFilial(paramFilial, paramPeriodo);
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession sessao = httpRequest.getSession();
        filialService = new FilialService();
        Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
        Filial filialAtiva = filialService.get(usuario.getIdFilial());
        request.setAttribute("periodo", ListasFixas.getPeriodoRelatorio());
        request.setAttribute("filialAtiva", filialAtiva);
        request.setAttribute("listaFiliais", filialService.listar());
        request.setAttribute("listaVendas", vendas);
        double totalVendas = 0;
        for (Relatorio rel : vendas) {
            totalVendas += rel.getValorTotal();
        }
        request.setAttribute("totalVendas", totalVendas);
        request.setAttribute("periodoSelecionado", paramPeriodo);
        if (paramFilial != 0) {
            request.setAttribute("nomeFilial", filialService.get(paramFilial).getNome());
        } else {
            request.setAttribute("nomeFilial", "Todas");
        }

        request.getRequestDispatcher("/WEB-INF/relatorios/relatorios.jsp")
                .forward(request, response);
    }
}
