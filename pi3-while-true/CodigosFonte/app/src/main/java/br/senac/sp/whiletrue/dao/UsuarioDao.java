package br.senac.sp.whiletrue.dao;

import br.senac.sp.whiletrue.dao.util.ConnectionUtils;
import br.senac.sp.whiletrue.model.Usuario;
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
public class UsuarioDao {

    Connection conexao = null;

    public void inserir(Usuario u) throws SQLException, Exception {
        String query = "INSERT INTO Usuario (IdPerfil, IdFilial, Nome, Email, Login, Senha, Ativo, DataCadastro)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, u.getIdPerfil());
            statement.setInt(2, u.getIdFilial());
            statement.setString(3, u.getNome());
            statement.setString(4, u.getEmail());
            statement.setString(5, u.getLogin());
            statement.setString(6, u.getSenha());
            statement.setBoolean(7, true);
            statement.setDate(8, Util.toSQLDate(u.getDataCadastro()));
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

    public void atualizar(Usuario u) throws SQLException, Exception {
        String query = "UPDATE Usuario SET Nome = ?, Email = ?, Senha = ?"
                + " WHERE Id = ?";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, u.getNome());
            statement.setString(2, u.getEmail());
            statement.setString(3, u.getSenha());
            statement.setInt(4, u.getId());
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
        String query = "UPDATE Usuario SET Ativo = false WHERE Id = ?";
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

    public ArrayList<Usuario> listar() throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        String query = "select "
                + "u.Id, "
                + "u.Nome, "
                + "u.Email, "
                + "u.Login, "
                + "u.Senha, "
                + "u.Ativo, "
                + "u.DataCadastro, "
                + "u.IdPerfil, "
                + "u.IdFilial "
                + "from Usuario u";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            Usuario u;
            while (result.next()) {
                u = new Usuario(result.getInt("Id"),
                        result.getInt("IdPerfil"),
                        result.getInt(("IdFilial")),
                        result.getString("Nome"),
                        result.getString("Email"),
                        result.getString("Login"),
                        result.getBoolean("Ativo"),
                        new java.util.Date(result.getDate("DataCadastro").getTime()));
                u.setSenha(result.getString("Senha"));
                usuarios.add(u);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }

        return usuarios;
    }
}
