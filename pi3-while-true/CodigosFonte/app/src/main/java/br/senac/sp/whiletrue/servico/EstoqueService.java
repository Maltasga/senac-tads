package br.senac.sp.whiletrue.servico;

import br.senac.sp.whiletrue.dao.EstoqueDao;
import br.senac.sp.whiletrue.model.Estoque;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author While True
 */
public class EstoqueService {

    private EstoqueDao dao;

    public EstoqueService() {
        dao = new EstoqueDao();
    }

    public Estoque get(Estoque e) {
        Estoque estoque = null;
        try {
            for (Estoque est : dao.listarPorProduto(e.getIdProduto(), e.getIdFilial())) {
                if (est.equals(e)) {
                    estoque = est;
                    break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estoque;
    }

    public void inserir(Estoque e) {
        try {
            ArrayList<Estoque> lista = dao.listarPorProduto(e.getIdProduto(), e.getIdFilial());
            if (lista.size() == 0) {
                dao.inserir(e);
            } else {
                Estoque est = buscar(e);
                if (est != null) {
                    int quant = e.getQuantidade() + est.getQuantidade();
                    e.setQuantidade(quant);
                    dao.atualizar(e);
                } else {
                    dao.inserir(e);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Estoque> listarPorFilial(int idFilial) {
        try {
            ArrayList<Estoque> listaRetorno = new ArrayList<>();
            for (Estoque est : dao.listarPorFilial(idFilial)) {
                listaRetorno.add(est);
            }
            return listaRetorno;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Estoque> listarPorProduto(int idProduto, int idFilial) {
        try {
            ArrayList<Estoque> listaRetorno = dao.listarPorProduto(idProduto, idFilial);
            if (listaRetorno.size() > 0) {
                return listaRetorno;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void baixaVenda(int idFilial, int idProduto, String tamanho, int quantidade) {
        try {
            int qtdeAtual = this.quantidadePorTamanho(idProduto, idFilial, tamanho) - quantidade;
            Estoque estoque = new Estoque(0, idProduto, idFilial, tamanho, qtdeAtual);
            dao.atualizar(estoque);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int quantidadePorTamanho(int idProduto, int idFilial, String tamanho) {
        int qtde = 0;
        try {
            ArrayList<Estoque> lista = dao.listarPorProduto(idProduto, idFilial);
            for (Estoque e : lista) {
                if (e.getTamanho().toLowerCase().equals(tamanho.toLowerCase())) {
                    qtde = e.getQuantidade();
                    break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return qtde;
    }

    public Estoque buscar(Estoque e) throws SQLException {
        ArrayList<Estoque> estoque = listarPorProduto(e.getIdProduto(), e.getIdFilial());
        for (Estoque estoque1 : estoque) {
            if (estoque1.getTamanho().equals(e.getTamanho())) {
                return estoque1;
            }
        }
        return null;
    }
}
