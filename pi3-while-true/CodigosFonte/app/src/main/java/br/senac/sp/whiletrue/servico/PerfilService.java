package br.senac.sp.whiletrue.servico;

import br.senac.sp.whiletrue.dao.PerfilDao;
import br.senac.sp.whiletrue.model.Perfil;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author While True
 */
public class PerfilService {

    private PerfilDao dao;

    public PerfilService() {
        dao = new PerfilDao();
    }

    public Perfil get(int id) {
        Perfil perfil = null;
        try {
            for (Perfil p : dao.listar()) {
                if (p.getId() == id) {
                    perfil = p;
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return perfil;
    }

    public ArrayList<Perfil> listar(Perfil perfilFiltro) {
        ArrayList<Perfil> lista = new ArrayList<>();
        try {
            if (!"".equals(perfilFiltro.getNome())) {
                for (Perfil p : dao.listar()) {
                    if (p.getNome().toLowerCase().contains(perfilFiltro.getNome().toLowerCase())) {
                        lista.add(p);
                    }
                }
            } else {
                lista = dao.listar();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public ArrayList<Perfil> listar() {
        try {
            return dao.listar();
        } catch (Exception ex) {
            ex.printStackTrace();

            return null;
        }
    }

}
