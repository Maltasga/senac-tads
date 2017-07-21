package br.senac.sp.whiletrue.model;

import br.senac.sp.whiletrue.dao.EnderecoDao;
import java.util.Date;

/**
 *
 * @author While True
 */
public class Filial {

    private int id;
    private String nome;
    private String cnpj;
    private boolean matriz;
    private boolean ativo;
    private Date dataCadastro;
    private Endereco endereco;

    public Endereco getEndereco() {
        if (this.endereco == null) {
            EnderecoDao dao = new EnderecoDao();
            try {
                this.endereco = dao.obter(this.id, Endereco.ORIGEM_FILIAL);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setMatriz(boolean matriz) {
        this.matriz = matriz;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public boolean isMatriz() {
        return matriz;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Filial(int id, String nome, String cnpj, boolean matriz, boolean ativo, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.matriz = matriz;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }
}
