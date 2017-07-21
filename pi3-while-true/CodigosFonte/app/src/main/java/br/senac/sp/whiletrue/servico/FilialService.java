package br.senac.sp.whiletrue.servico;

import br.senac.sp.whiletrue.dao.FilialDao;
import br.senac.sp.whiletrue.model.Filial;
import br.senac.sp.whiletrue.model.Util;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author While True
 */
public class FilialService {

    private FilialDao dao;

    public FilialService() {
        dao = new FilialDao();
    }

    public Filial get(int id) {
        Filial filial = null;
        try {
            for (Filial f : dao.listar()) {
                if (f.getId() == id) {
                    filial = f;
                    break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return filial;
    }

    public ArrayList<Filial> listar() {
        try {
            ArrayList<Filial> filiais = new ArrayList<>();
            for (Filial f : dao.listar()) {
                if (f.isAtivo()) {
                    filiais.add(f);
                }
            }
            return filiais;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Filial> listar(Filial filialFiltro) {
        try {
            ArrayList<Filial> listResultado = dao.listar();

            return listResultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int salvar(Filial f) throws Exception {
        try {
            if (f.getId() == 0) {
                dao.inserir(f);
                return dao.getLastID();
            } else {
                dao.atualizar(f);
                return f.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao atualizar filial.");
        }
    }

    public void excluir(int id) throws Exception {
        try {
            dao.excluir(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao tentar excluir o cadastro de filial");
        }
    }
    
    public int getLastId() throws Exception{
        try {
            return dao.getLastID();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao obter último id de filial");
        }
    }

    public ArrayList<String> validar(Filial f) {
        ArrayList<String> listaItensInvalidos = new ArrayList<>();

        if (f.getId() < 0) {
            listaItensInvalidos.add("Valor inválido para o campo Id");
        }
        
        if (Util.isNullOrEmpty(f.getNome())) {
            listaItensInvalidos.add("Razão Social não informada");
        }
        
        if(!Util.isInMaxlength(f.getNome(), 255)){
            listaItensInvalidos.add("Razão Social deve ter no máximo 100 caracteres");
        }

        if (Util.isNullOrEmpty(f.getCnpj())) {
            listaItensInvalidos.add("CNPJ não informado");
        }

        if (!Util.isInMinLength(f.getCnpj().replaceAll("[^a-zA-Z0-9]", ""), 14)
                || !Util.isInMaxlength(f.getCnpj().replaceAll("[^a-zA-Z0-9]", ""), 14)
                || Util.stringToNumber(f.getCnpj())) {
            listaItensInvalidos.add("Número de CNPJ inválido");
        }

        return listaItensInvalidos;
    }
}
