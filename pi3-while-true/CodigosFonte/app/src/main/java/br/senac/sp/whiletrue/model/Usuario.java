package br.senac.sp.whiletrue.model;

import br.senac.sp.whiletrue.servico.FilialService;
import br.senac.sp.whiletrue.servico.PerfilService;
import java.util.Date;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author While True
 */
public class Usuario {

    private int id;
    private int idPerfil;
    private int idFilial;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private boolean ativo;
    private Date dataCadastro;
    private Perfil perfil;
    private Filial filial;

    public Usuario(String login) {
        this.login = login;
    }

    public Usuario(int id, int idPerfil, int idFilial, String nome, String email, String login, boolean ativo, Date dataCadastro) {
        this.id = id;
        this.idPerfil = idPerfil;
        this.idFilial = idFilial;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public Filial getFilial() {
        if (filial == null) {
            try {
                FilialService service = new FilialService();
                filial = service.get(idFilial);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return filial;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Perfil getPerfil() {
        if (perfil == null) {
            try {
                PerfilService service = new PerfilService();
                perfil = service.get(idPerfil);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return perfil;
    }

    public void setHashSenha(String senha) {
        this.senha = BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public static boolean validarSenha(String senhaInformada, String senhaHash) {
        return BCrypt.checkpw(senhaInformada, senhaHash);
    }
}
