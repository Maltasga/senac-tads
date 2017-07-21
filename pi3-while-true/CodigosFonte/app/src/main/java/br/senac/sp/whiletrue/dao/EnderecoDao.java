package br.senac.sp.whiletrue.dao;

import br.senac.sp.whiletrue.dao.util.ConnectionUtils;
import br.senac.sp.whiletrue.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author While True
 */
public class EnderecoDao {
    
    Connection conexao;
    
    public void inserir(Endereco e) throws SQLException, Exception {
        String query = "INSERT INTO Endereco VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, e.getId());
            statement.setString(2, e.getOrigem());
            statement.setString(3, e.getLogradouro());
            statement.setString(4, e.getCep());
            statement.setString(5, e.getComplemento());
            statement.setString(6, e.getBairro());
            statement.setString(7, e.getCidade());
            statement.setString(8, e.getUf());
            
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
    
    public void atualizar(Endereco e) throws SQLException, Exception {
        String query = "UPDATE Endereco SET Logradouro = ?, Cep = ?, Complemento = ?, "
                + "Bairro = ?, Cidade = ?, Uf = ? WHERE Id = ? AND Origem = ?";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, e.getLogradouro());
            statement.setString(2, e.getCep());
            statement.setString(3, e.getComplemento());
            statement.setString(4, e.getBairro());
            statement.setString(5, e.getCidade());
            statement.setString(6, e.getUf());
            statement.setInt(7, e.getId());
            statement.setString(8, e.getOrigem());
            
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
    
    public void excluir(int id, String origem) throws SQLException, Exception {
        String query = "DELETE FROM Endereco WHERE Id = ? AND Origem = ?";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, origem);
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
    
    public Endereco obter(int id, String origem) throws SQLException, Exception {
        Endereco endereco = null;
        String query = "SELECT * FROM Endereco WHERE Id = ? AND Origem = ?";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, origem);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                endereco = new Endereco(
                        result.getInt("Id"),
                        result.getString("Origem"),
                        result.getString("Logradouro"),
                        result.getString("Cep"),
                        result.getString("Complemento"),
                        result.getString("Bairro"),
                        result.getString("Cidade"),
                        result.getString("Uf"));
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return endereco;
    }
}
