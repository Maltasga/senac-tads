package br.senac.sp.whiletrue.dao;

import br.senac.sp.whiletrue.dao.util.ConnectionUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import br.senac.sp.whiletrue.model.Filial;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author While True
 */
public class FilialDao {

    Connection conexao = null;

    public void inserir(Filial f) throws SQLException, Exception {
        String query = "INSERT INTO Filial (Nome, Cnpj, Matriz, Ativo, DataCadastro) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, f.getNome());
            statement.setString(2, f.getCnpj());
            statement.setBoolean(3, f.isMatriz());
            statement.setBoolean(4, true);
            statement.setDate(5, new java.sql.Date(f.getDataCadastro().getTime()));
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

    public void atualizar(Filial f) throws SQLException, Exception {
        String query = "UPDATE Filial SET Nome = ?, Cnpj = ?, Matriz = ? WHERE Id = ?";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, f.getNome());
            statement.setString(2, f.getCnpj());
            statement.setBoolean(3, f.isMatriz());
            statement.setInt(4, f.getId());

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
        String query = "UPDATE Filial SET Ativo = false WHERE Id = ?";
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

    public ArrayList<Filial> listar() throws SQLException {
        ArrayList<Filial> filiais = new ArrayList<>();

        String query = "SELECT f.Id, f.Nome, f.Cnpj, f.Matriz, f.Ativo, f.DataCadastro FROM Filial f";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            Filial f;
            while (result.next()) {
                f = new Filial(
                        result.getInt("Id"),
                        result.getString("Nome"),
                        result.getString("Cnpj"),
                        result.getBoolean("Matriz"),
                        result.getBoolean("Ativo"),
                        new Date(result.getDate("DataCadastro").getTime()));
                filiais.add(f);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return filiais;
    }

    public int getLastID() throws SQLException {
        int id = 0;
        String query = "SELECT MAX(Id) AS Id FROM Filial";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                id = result.getInt("Id");
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return id;
    }
}
