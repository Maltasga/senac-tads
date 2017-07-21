/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.whiletrue.model;

import java.util.Date;

/**
 *
 * @author Karol
 */
public class Relatorio {

    String nome;
    Date dataVenda;
    String vendedor;
    Double valorTotal;

    public Relatorio(String nome, Date dataVenda, String vendedor, double valorTotal) {
        this.nome = nome;
        this.dataVenda = dataVenda;
        this.vendedor = vendedor;
        this.valorTotal = valorTotal;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public String getVendedor() {
        return vendedor;
    }

    public Double getValorTotal() {
        return valorTotal;
    }
    
    

}
