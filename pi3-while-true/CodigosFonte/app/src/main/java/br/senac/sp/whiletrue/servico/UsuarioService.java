package br.senac.sp.whiletrue.servico;

import br.senac.sp.whiletrue.dao.UsuarioDao;
import br.senac.sp.whiletrue.model.Usuario;
import br.senac.sp.whiletrue.model.Util;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author While True
 */
public class UsuarioService {

    private UsuarioDao dao;

    public UsuarioService() {
        dao = new UsuarioDao();
    }

    public Usuario get(int id) {
        Usuario usuario = null;
        try {
            for (Usuario u : dao.listar()) {
                if (u.getId() == id) {
                    usuario = u;
                    break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuario;
    }

    public Usuario get(String login) {
        Usuario usuario = null;
        try {
            for (Usuario u : dao.listar()) {
                if (login.equals(u.getLogin())) {
                    usuario = u;
                    break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuario;
    }

    public ArrayList<Usuario> listar() {
        try {
            ArrayList<Usuario> usuarios = new ArrayList<>();
            for (Usuario u : dao.listar()) {
                if (u.isAtivo()) {
                    usuarios.add(u);
                }
            }
            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void salvar(Usuario u) throws Exception {
        try {
            if (u.getId() == 0) {
                dao.inserir(u);
            } else {
                dao.atualizar(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao atualizar usuário.");
        }
    }

    public void excluir(int id) throws Exception {
        try {
            dao.excluir(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao tentar excluir o cadastro de usuário");
        }
    }

    public ArrayList<String> validar(Usuario u) {
        ArrayList<String> listaItensInvalidos = new ArrayList<>();

        if (u.getId() < 0) {
            listaItensInvalidos.add("Valor inválido para o campo Id");
        }
        if (u.getIdPerfil() < 0) {
            listaItensInvalidos.add("Perfil inválido");
        }
        if (u.getIdFilial() < 0) {
            listaItensInvalidos.add("Filial inválida");
        }
        if (Util.isNullOrEmpty(u.getNome())) {
            listaItensInvalidos.add("Nome não informado");
        } else {
            if (!Util.isInMinLength(u.getNome(), 3) || !Util.isInMaxlength(u.getNome(), 100)) {
                listaItensInvalidos.add("Nome de usuário ter entre 3 e 100 caracteres");
            }
        }
        if (Util.isNullOrEmpty(u.getEmail())) {
            listaItensInvalidos.add("Email não informado");
        } else {
            if (!Util.isInMinLength(u.getEmail(), 15) || !Util.isInMaxlength(u.getEmail(), 50)) {
                listaItensInvalidos.add("Email deve ter entre 15 e 50 caracteres");
            }
            if (!Util.isEmail(u.getEmail())) {
                listaItensInvalidos.add("Email no formato inválido");
            }
        }
        if (Util.isNullOrEmpty(u.getLogin())) {
            listaItensInvalidos.add("Login não informado");
        } else {
            if (!Util.isInMinLength(u.getEmail(), 5) || !Util.isInMaxlength(u.getLogin(), 10)) {
                listaItensInvalidos.add("Login deve ter entre 5 e 10 caracteres");
            }
            if (get(u.getLogin()) != null) {
                listaItensInvalidos.add("Login " + u.getLogin() + " já está em uso");
            }
        }
        if (Util.isNullOrEmpty(u.getSenha())) {
            listaItensInvalidos.add("Senha não informada");
        } else {
            if (!Util.isInMinLength(u.getSenha(), 4) ||!Util.isInMaxlength(u.getSenha(), 10)) {
                listaItensInvalidos.add("Senha deve ter entre 4 e 8 caracteres");
            }
        }

        return listaItensInvalidos;
    }
}
