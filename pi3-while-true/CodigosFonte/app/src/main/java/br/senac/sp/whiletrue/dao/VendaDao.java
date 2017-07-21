package br.senac.sp.whiletrue.dao;

import br.senac.sp.whiletrue.dao.util.ConnectionUtils;
import br.senac.sp.whiletrue.model.ItemVenda;
import br.senac.sp.whiletrue.model.Util;
import br.senac.sp.whiletrue.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author While True
 */
public class VendaDao {

    Connection conexao = null;

    private long getUltimoIdVenda() {
        try {
            ResultSet result = conexao
                    .prepareStatement("SELECT MAX(Id) FROM Venda")
                    .executeQuery();
            while (result.next()) {
                return result.getLong(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public void inserir(Venda v) throws SQLException, Exception {
        String queryVenda = "INSERT INTO Venda (IdCliente, IdUsuario, Valor, DataVenda) "
                + "VALUES (?, ?, ?, ?)";
        String queryItem = "INSERT INTO VendaItem (IdVenda, IdProduto, Tamanho, Quantidade) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(queryVenda);
            statement.setInt(1, v.getIdCliente());
            statement.setInt(2, v.getIdUsuario());
            statement.setDouble(3, v.getValor());
            statement.setDate(4, Util.toSQLDate(v.getDataVenda()));
            statement.execute();
            statement.close();

            long vendaId = getUltimoIdVenda();
            for (ItemVenda item : v.getItens()) {
                item.setIdVenda(vendaId);
                statement = conexao.prepareStatement(queryItem);
                statement.setLong(1, vendaId);
                statement.setInt(2, item.getIdProduto());
                statement.setString(3, item.getTamanho());
                statement.setInt(4, item.getQuantidade());
                statement.execute();
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

}
