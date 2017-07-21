package br.senac.sp.whiletrue.servico;

import br.senac.sp.whiletrue.dao.ProdutoDao;
import br.senac.sp.whiletrue.model.Produto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author While True
 */
public class ProdutoService {

    ProdutoDao dao = new ProdutoDao();

    public ProdutoService() {
        this.dao = new ProdutoDao();
    }

    public Produto get(String codigo) {
        Produto p = null;
        try {
            for (Produto item : dao.listar()) {
                if (item.getCodigo().equals(codigo)) {
                    p = item;
                    break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    public Produto get(int id) {
        Produto p = null;
        try {
            for (Produto item : dao.listar()) {
                if (item.getId() == id) {
                    p = item;
                    break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    public ArrayList<Produto> listar() {
        try {
            ArrayList<Produto> produtos = new ArrayList<>();
            for (Produto item : dao.listar()) {
                if (item.isAtivo()) {
                    produtos.add(item);
                }
            }
            return produtos;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Produto> listarPorFilial(int idFilial) {
        try {
            ArrayList<Produto> produtos = new ArrayList<>();
            for (Produto item : dao.listarPorFilial(idFilial)) {
                if (item.isAtivo()) {
                    produtos.add(item);
                }
            }
            return produtos;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Produto> listarPorNome(String nome) {
        try {
            ArrayList<Produto> produtos = new ArrayList<>();
            for (Produto item : dao.listar()) {
                if (item.getNome().contains(nome)) {
                    produtos.add(item);
                }
            }
            return produtos;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void salvar(Produto p) throws Exception {
        try {
            if (p.getId() == 0) {
                dao.inserir(p);
            } else {
                dao.atualizar(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Falha ao atualizar o produto");
        }
    }

    public void excluir(int id) throws Exception {
        try {
            dao.excluir(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao tentar excluir o cadastro do produto");
        }
    }
}
