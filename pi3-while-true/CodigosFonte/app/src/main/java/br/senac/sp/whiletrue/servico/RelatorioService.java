/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.whiletrue.servico;

import br.senac.sp.whiletrue.dao.RelatorioDao;
import br.senac.sp.whiletrue.model.Relatorio;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Karol
 */
public class RelatorioService {

    private RelatorioDao dao;

    public RelatorioService() {
        dao = new RelatorioDao();
    }

    public ArrayList<Relatorio> listar(int idFilial) {
        try {
            ArrayList<Relatorio> listaResultado = dao.listarFilial(idFilial);

            return listaResultado;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Relatorio> listarTudo(String periodo) {
        try {
            ArrayList<Relatorio> listaResultado = null;

            switch (periodo) {
                case "Tudo":
                    listaResultado = dao.listarTudo();
                    break;
                case "Mensal":
                    listaResultado = dao.listarTudoMensal();
                    break;
                case "Semestral":
                    listaResultado = dao.listarTudoSemestral();
                    break;
                case "Anual":
                    listaResultado = dao.listarTudoAnual();
                    break;
                default:
                    break;
            }

            return listaResultado;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Relatorio> listarFilial(int filial, String periodo) {
        try {
            ArrayList<Relatorio> listaResultado = null;

            switch (periodo) {
                case "Tudo":
                    listaResultado = dao.listarFilial(filial);
                    break;
                case "Mensal":
                    listaResultado = dao.listarFilialMensal(filial);
                    break;
                case "Semestral":
                    listaResultado = dao.listarFilialSemestral(filial);
                    break;
                case "Anual":
                    listaResultado = dao.listarFilialAnual(filial);
                    break;
                default:
                    break;
            }

            return listaResultado;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
