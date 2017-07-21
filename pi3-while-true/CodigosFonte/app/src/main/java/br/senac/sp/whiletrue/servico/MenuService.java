package br.senac.sp.whiletrue.servico;

import br.senac.sp.whiletrue.dao.MenuDao;
import br.senac.sp.whiletrue.model.Menu;
import java.util.ArrayList;

/**
 *
 * @author While True
 */
public class MenuService {

    MenuDao dao = null;

    public MenuService() {
        dao = new MenuDao();
    }

    public ArrayList<Menu> listarTodos() {
        try {
            return dao.listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Menu> listarPorPerfil(int idPerfil) {
        try {
            return dao.listar(idPerfil);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
