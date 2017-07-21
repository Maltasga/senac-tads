package br.senac.sp.whiletrue.servico;

import br.senac.sp.whiletrue.dao.ColecaoDao;
import br.senac.sp.whiletrue.model.Colecao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author While True
 */
public class ColecaoService {

    ColecaoDao dao;

    public ColecaoService() {
        dao = new ColecaoDao();
    }

    public void salvar(Colecao c) throws Exception {
        try {
            if (c.getId() == 0) {
                dao.inserir(c);
            } else {
                dao.atualizar(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao atualizar coleção.");
        }
    }

     public ArrayList<Colecao> listar() {
        try {
            ArrayList<Colecao> colecao = new ArrayList<>();
            for (Colecao c : dao.listar()) {
                if (c.isAtivo()) {
                    colecao.add(c);
                }
            }
            return colecao;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void excluir(int id) throws Exception {
        try {
            dao.excluir(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao tentar excluir o cadastro de Coleção");
        }
    }
    
      public Colecao get(int id) {
        Colecao colecao = null;
        try {
            for (Colecao c : dao.listar()) {
                if (c.getId() == id) {
                    colecao = c;
                    break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return colecao;
    }
}
