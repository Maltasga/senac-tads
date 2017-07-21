package br.senac.sp.whiletrue.dao;

import br.senac.sp.whiletrue.dao.util.ConnectionUtils;
import br.senac.sp.whiletrue.model.Colecao;
import br.senac.sp.whiletrue.model.Produto;
import br.senac.sp.whiletrue.model.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author While True
 */
public class ProdutoDao {

    Connection conexao = null;

    public void inserir(Produto p) throws SQLException, Exception {
        String query = "INSERT INTO Produto "
                + "(Codigo, Nome, Descricao, IdColecao, Tipo, Cor, ValorProducao, ValorVenda, Ativo, DataCadastro) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, p.getCodigo());
            statement.setString(2, p.getNome());
            statement.setString(3, p.getDescricao());
            statement.setInt(4, p.getIdColecao());
            statement.setString(5, p.getTipo());
            statement.setString(6, p.getCor());
            statement.setDouble(7, p.getValorProducao());
            statement.setDouble(8, p.getValorVenda());
            statement.setBoolean(9, p.isAtivo());
            statement.setDate(10, Util.toSQLDate(p.getDataCadastro()));

            statement.execute();
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public void atualizar(Produto p) throws SQLException, Exception {
        String query = "UPDATE Produto SET Nome = ?, Descricao = ?, ValorProducao = ?, ValorVenda = ? "
                + "WHERE Id = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, p.getNome());
            statement.setString(2, p.getDescricao());
            statement.setDouble(3, p.getValorProducao());
            statement.setDouble(4, p.getValorVenda());
            statement.setInt(5, p.getId());
            statement.execute();
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public void excluir(int id) throws SQLException, Exception {
        String query = "UPDATE Produto SET Ativo = FALSE WHERE Id = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public ArrayList<Produto> listar() throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<>();

        String query = "SELECT "
                + "p.Id, "
                + "p.Codigo, "
                + "p.Nome, "
                + "p.Descricao, "
                + "p.IdColecao, "
                + "c.Nome AS NomeColecao, "
                + "p.Tipo, p.Cor, "
                + "p.ValorProducao, "
                + "p.ValorVenda, p.Ativo, "
                + "p.DataCadastro "
                + "FROM Produto p "
                + "JOIN Colecao c ON p.IdColecao = c.ID";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            Produto p = null;
            while (result.next()) {
                p = new Produto(
                        result.getInt("Id"),
                        result.getString("Codigo"),
                        result.getString("Nome"),
                        result.getString("Descricao"),
                        result.getInt("IdColecao"),
                        result.getString("Tipo"),
                        result.getString("Cor"),
                        result.getDouble("ValorProducao"),
                        result.getDouble("ValorVenda"),
                        result.getBoolean("Ativo"),
                        Util.toUtilDate(result.getDate("DataCadastro")));
                p.setColecao(new Colecao(result.getInt("IdColecao"), result.getString("NomeColecao")));
                produtos.add(p);

            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return produtos;
    }
    
    public ArrayList<Produto> listarPorFilial(int idFilial) throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<>();

        String query = "SELECT DISTINCT "
                + "p.Id, "
                + "p.Codigo, "
                + "p.Nome, "
                + "p.Descricao, "
                + "p.IdColecao, "
                + "c.Nome AS NomeColecao, "
                + "p.Tipo, "
                + "p.Cor, "
                + "p.ValorProducao, "
                + "p.ValorVenda, "
                + "p.Ativo, "
                + "p.DataCadastro "
                + "FROM Produto P "
                + "JOIN Colecao C ON P.IdColecao = C.Id "
                + "JOIN Estoque E ON P.Id = E.IdProduto "
                + "WHERE E.IdFilial = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, idFilial);
            ResultSet result = statement.executeQuery();
            Produto p = null;
            while (result.next()) {
                p = new Produto(
                        result.getInt("Id"),
                        result.getString("Codigo"),
                        result.getString("Nome"),
                        result.getString("Descricao"),
                        result.getInt("IdColecao"),
                        result.getString("Tipo"),
                        result.getString("Cor"),
                        result.getDouble("ValorProducao"),
                        result.getDouble("ValorVenda"),
                        result.getBoolean("Ativo"),
                        Util.toUtilDate(result.getDate("DataCadastro")));
                p.setColecao(new Colecao(result.getInt("IdColecao"), result.getString("NomeColecao")));
                produtos.add(p);

            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return produtos;        
    }
}
