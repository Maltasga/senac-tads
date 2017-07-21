package br.senac.sp.whiletrue.dao;

import br.senac.sp.whiletrue.dao.util.ConnectionUtils;
import br.senac.sp.whiletrue.model.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author While True
 */
public class MenuDao {

    Connection conexao = null;

    public ArrayList<Menu> listar() throws SQLException {
        ArrayList<Menu> menus = new ArrayList<>();
        String query = "SELECT * FROM Menu";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                menus.add(new Menu(
                        result.getInt("Id"),
                        result.getString("Nome"),
                        result.getString("Caminho")));
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return menus;
    }

    public ArrayList<Menu> listar(int idPerfil) throws SQLException {
        ArrayList<Menu> menus = new ArrayList<>();
        String query = "SELECT m.Id, m.Nome, m.Caminho FROM Menu m "
                + "JOIN MenuPerfil mp on mp.IdMenu = m.Id "
                + "WHERE mp.IdPerfil = ?";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, idPerfil);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                menus.add(new Menu(
                        result.getInt("Id"),
                        result.getString("Nome"),
                        result.getString("Caminho")));
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return menus;
    }
}
