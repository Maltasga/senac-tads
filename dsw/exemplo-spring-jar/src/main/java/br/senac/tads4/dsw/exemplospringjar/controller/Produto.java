package br.senac.tads4.dsw.exemplospringjar.controller;

import java.util.Date;

/**
 *
 * @author gabri
 */
public class Produto {

    private String nome;
    private double preco;
    private Date dataCadastro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Produto() {
    }

    public Produto(String nome, double preco, Date dataCadastro) {
        this.nome = nome;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
    }
    
    
}
