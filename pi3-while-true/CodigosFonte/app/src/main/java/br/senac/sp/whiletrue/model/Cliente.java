package br.senac.sp.whiletrue.model;

import br.senac.sp.whiletrue.dao.EnderecoDao;
import java.util.Date;

/**
 *
 * @author While True
 */
public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private String sexo;
    private Date dataNascimento;
    private boolean ativo;
    private Date dataCadastro;
    private Endereco endereco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Endereco getEndereco() {
        if (endereco == null) {
            EnderecoDao dao = new EnderecoDao();
            try {
                this.endereco = dao.obter(this.id, Endereco.ORIGEM_CLIENTE);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cliente(int id, String nome, String cpf, String sexo, Date dataNascimento, boolean ativo, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }
}
