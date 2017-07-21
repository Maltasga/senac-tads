package br.senac.sp.whiletrue.dao;

import br.senac.sp.whiletrue.dao.util.ConnectionUtils;
import br.senac.sp.whiletrue.model.Perfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author While True
 */
public class PerfilDao {

    Connection conexao = null;

    public void inserir(Perfil p) throws SQLException, Exception {
        String query = "INSERT INTO Perfil (Id, Nome) VALUES (?, ?)";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, p.getId());
            statement.setString(2, p.getNome());
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

    public void editar(Perfil p) throws SQLException, Exception {
        String query = "UPDATE Perfil SET Nome = ? WHERE Id = ?";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, p.getNome());
            statement.setInt(2, p.getId());

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
        String query = "DELETE FROM Perfil WHERE Id = ?";
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

    public ArrayList<Perfil> listar() throws SQLException, Exception {
        ArrayList<Perfil> perfis = new ArrayList<>();
        String query = "SELECT Id, Nome FROM Perfil";

        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);

            result = statement.executeQuery();

            while (result.next()) {
                perfis.add(new Perfil(
                        result.getInt("Id"),
                        result.getString("Nome")
                ));
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }

            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return perfis;
    }
}
