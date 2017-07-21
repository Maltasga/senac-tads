package br.senac.sp.whiletrue.model;

/**
 *
 * @author While True
 */
public class Endereco {

    private int id;
    private String origem;
    private String logradouro;
    private String cep;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;

    public static String ORIGEM_FILIAL = "FILIAL";
    public static String ORIGEM_CLIENTE = "CLIENTE";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Endereco(int id, String origem, String logradouro, String cep, String complemento, String bairro, String cidade, String uf) {
        this.id = id;
        this.origem = origem;
        this.logradouro = logradouro;
        this.cep = cep;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }
}
