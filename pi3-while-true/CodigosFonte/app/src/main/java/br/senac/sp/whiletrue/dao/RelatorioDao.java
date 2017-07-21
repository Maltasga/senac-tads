/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.whiletrue.dao;

import br.senac.sp.whiletrue.dao.util.ConnectionUtils;
import br.senac.sp.whiletrue.model.Relatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Karol
 */
public class RelatorioDao {

    Connection conexao = null;

    public ArrayList<Relatorio> listarTudo() throws SQLException {
        ArrayList<Relatorio> vendas = new ArrayList<>();

        String query = "SELECT F.NOME as Filial, V.DATAVENDA as DataVenda, U.NOME as Vendedor, V.VALOR as Valor FROM LOJA.VENDA as V\n"
                + "INNER JOIN LOJA.USUARIO as U\n"
                + "ON U.ID = V.IDUSUARIO\n"
                + "INNER JOIN LOJA.FILIAL as F\n"
                + "ON F.ID = U.IDFILIAL\n"
                + "ORDER BY V.DATAVENDA";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            Relatorio r;
            while (result.next()) {
                r = new Relatorio(
                        result.getString("Filial"),
                        result.getDate("DataVenda"),
                        result.getString("Vendedor"),
                        result.getDouble("Valor"));
                vendas.add(r);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return vendas;
    }

    public ArrayList<Relatorio> listarTudoMensal() throws SQLException {
        ArrayList<Relatorio> vendasMensal = new ArrayList<>();

        String query = "SELECT F.NOME as Filial, V.DATAVENDA as DataVenda, U.NOME as Vendedor, V.VALOR as Valor FROM LOJA.VENDA as V\n"
                + "INNER JOIN LOJA.USUARIO as U\n"
                + "ON U.ID = V.IDUSUARIO\n"
                + "INNER JOIN LOJA.FILIAL as F\n"
                + "ON F.ID = U.IDFILIAL\n"
                + "WHERE {fn TIMESTAMPDIFF(SQL_TSI_DAY, DATAVENDA, CURRENT_DATE)} <= 30\n"
                + "ORDER BY V.DATAVENDA";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            Relatorio r;
            while (result.next()) {
                r = new Relatorio(
                        result.getString("Filial"),
                        result.getDate("DataVenda"),
                        result.getString("Vendedor"),
                        result.getDouble("Valor"));
                vendasMensal.add(r);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return vendasMensal;
    }

    public ArrayList<Relatorio> listarTudoSemestral() throws SQLException {
        ArrayList<Relatorio> vendasSemestral = new ArrayList<>();

        String query = "SELECT F.NOME as Filial, V.DATAVENDA as DataVenda, U.NOME as Vendedor, V.VALOR as Valor FROM LOJA.VENDA as V\n"
                + "INNER JOIN LOJA.USUARIO as U\n"
                + "ON U.ID = V.IDUSUARIO\n"
                + "INNER JOIN LOJA.FILIAL as F\n"
                + "ON F.ID = U.IDFILIAL\n"
                + "WHERE {fn TIMESTAMPDIFF(SQL_TSI_DAY, DATAVENDA, CURRENT_DATE)} <= 182\n"
                + "ORDER BY V.DATAVENDA";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            Relatorio r;
            while (result.next()) {
                r = new Relatorio(
                        result.getString("Filial"),
                        result.getDate("DataVenda"),
                        result.getString("Vendedor"),
                        result.getDouble("Valor"));
                vendasSemestral.add(r);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return vendasSemestral;
    }

    public ArrayList<Relatorio> listarTudoAnual() throws SQLException {
        ArrayList<Relatorio> vendasAnual = new ArrayList<>();

        String query = "SELECT F.NOME as Filial, V.DATAVENDA as DataVenda, U.NOME as Vendedor, V.VALOR as Valor FROM LOJA.VENDA as V\n"
                + "INNER JOIN LOJA.USUARIO as U\n"
                + "ON U.ID = V.IDUSUARIO\n"
                + "INNER JOIN LOJA.FILIAL as F\n"
                + "ON F.ID = U.IDFILIAL\n"
                + "WHERE {fn TIMESTAMPDIFF(SQL_TSI_DAY, DATAVENDA, CURRENT_DATE)} <= 365\n"
                + "ORDER BY V.DATAVENDA";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            Relatorio r;
            while (result.next()) {
                r = new Relatorio(
                        result.getString("Filial"),
                        result.getDate("DataVenda"),
                        result.getString("Vendedor"),
                        result.getDouble("Valor"));
                vendasAnual.add(r);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return vendasAnual;
    }

    public ArrayList<Relatorio> listarFilial(int idFilial) throws SQLException {
        ArrayList<Relatorio> vendasFilial = new ArrayList<>();

        String query = "SELECT F.NOME as Filial, V.DATAVENDA as DataVenda, U.NOME as Vendedor, V.VALOR as Valor FROM LOJA.VENDA as V\n"
                + "INNER JOIN LOJA.USUARIO as U\n"
                + "ON U.ID = V.IDUSUARIO\n"
                + "INNER JOIN LOJA.FILIAL as F\n"
                + "ON F.ID = U.IDFILIAL\n"
                + "WHERE F.ID = ?\n"
                + "ORDER BY V.DATAVENDA";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, idFilial);
            ResultSet result = statement.executeQuery();
            Relatorio r;
            while (result.next()) {
                r = new Relatorio(
                        result.getString("Filial"),
                        result.getDate("DataVenda"),
                        result.getString("Vendedor"),
                        result.getDouble("Valor"));
                vendasFilial.add(r);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return vendasFilial;
    }

    public ArrayList<Relatorio> listarFilialMensal(int idFilial) throws SQLException {
        ArrayList<Relatorio> vendasFilialMensal = new ArrayList<>();

        String query = "SELECT F.NOME as Filial, V.DATAVENDA as DataVenda, U.NOME as Vendedor, V.VALOR as Valor FROM LOJA.VENDA as V\n"
                + "INNER JOIN LOJA.USUARIO as U\n"
                + "ON U.ID = V.IDUSUARIO\n"
                + "INNER JOIN LOJA.FILIAL as F\n"
                + "ON F.ID = U.IDFILIAL\n"
                + "WHERE F.ID = ?\n"
                + "AND {fn TIMESTAMPDIFF(SQL_TSI_DAY, DATAVENDA, CURRENT_DATE)} <= 30\n"
                + "ORDER BY V.DATAVENDA";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, idFilial);
            ResultSet result = statement.executeQuery();
            Relatorio r;
            while (result.next()) {
                r = new Relatorio(
                        result.getString("Filial"),
                        result.getDate("DataVenda"),
                        result.getString("Vendedor"),
                        result.getDouble("Valor"));
                vendasFilialMensal.add(r);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return vendasFilialMensal;
    }

    public ArrayList<Relatorio> listarFilialSemestral(int idFilial) throws SQLException {
        ArrayList<Relatorio> vendasFilialSemestral = new ArrayList<>();

        String query = "SELECT F.NOME as Filial, V.DATAVENDA as DataVenda, U.NOME as Vendedor, V.VALOR as Valor FROM LOJA.VENDA as V\n"
                + "INNER JOIN LOJA.USUARIO as U\n"
                + "ON U.ID = V.IDUSUARIO\n"
                + "INNER JOIN LOJA.FILIAL as F\n"
                + "ON F.ID = U.IDFILIAL\n"
                + "WHERE F.ID = ?\n"
                + "AND {fn TIMESTAMPDIFF(SQL_TSI_DAY, DATAVENDA, CURRENT_DATE)} <= 182\n"
                + "ORDER BY V.DATAVENDA";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, idFilial);
            ResultSet result = statement.executeQuery();
            Relatorio r;
            while (result.next()) {
                r = new Relatorio(
                        result.getString("Filial"),
                        result.getDate("DataVenda"),
                        result.getString("Vendedor"),
                        result.getDouble("Valor"));
                vendasFilialSemestral.add(r);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return vendasFilialSemestral;
    }

    public ArrayList<Relatorio> listarFilialAnual(int idFilial) throws SQLException {
        ArrayList<Relatorio> vendasFilialAnual = new ArrayList<>();

        String query = "SELECT F.NOME as Filial, V.DATAVENDA as DataVenda, U.NOME as Vendedor, V.VALOR as Valor FROM LOJA.VENDA as V\n"
                + "INNER JOIN LOJA.USUARIO as U\n"
                + "ON U.ID = V.IDUSUARIO\n"
                + "INNER JOIN LOJA.FILIAL as F\n"
                + "ON F.ID = U.IDFILIAL\n"
                + "WHERE F.ID = ?\n"
                + "AND {fn TIMESTAMPDIFF(SQL_TSI_DAY, DATAVENDA, CURRENT_DATE)} <= 365\n"
                + "ORDER BY V.DATAVENDA";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, idFilial);
            ResultSet result = statement.executeQuery();
            Relatorio r;
            while (result.next()) {
                r = new Relatorio(
                        result.getString("Filial"),
                        result.getDate("DataVenda"),
                        result.getString("Vendedor"),
                        result.getDouble("Valor"));
                vendasFilialAnual.add(r);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return vendasFilialAnual;
    }
}
