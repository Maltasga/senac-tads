package br.senac.sp.whiletrue.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author While True
 */
public class Produto {

    private int id;
    private String codigo;
    private String nome;
    private String descricao;
    private int idColecao;
    private String tipo;
    private String cor;
    private double valorProducao;
    private double valorVenda;
    private boolean ativo;
    private Date dataCadastro;
    private Colecao colecao;
    private ArrayList<Estoque> estoque;

    public Produto(int id, String codigo, String nome, String descricao, int idColecao, String tipo, String cor, double valorProducao, double valorVenda, boolean ativo, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.idColecao = idColecao;
        this.tipo = tipo;
        this.cor = cor;
        this.valorProducao = valorProducao;
        this.valorVenda = valorVenda;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdColecao() {
        return idColecao;
    }

    public void setIdColecao(int idColecao) {
        this.idColecao = idColecao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValorProducao() {
        return valorProducao;
    }

    public void setValorProducao(double valorProducao) {
        this.valorProducao = valorProducao;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
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

    public ArrayList<Estoque> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Estoque> estoque) {
        this.estoque = estoque;
    }

    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
    }

    public Colecao getColecao() {
        return colecao;
    }
}
