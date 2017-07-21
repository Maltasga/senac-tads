package br.senac.sp.ado;

/**
 *
 * @author Gabriel Malta
 */
public abstract class Empregado {

    private String nome;

    public Empregado(String nome) {
        this.nome = nome;
    }
    
    public final String getNome(){
        return this.nome;
    }
    
    public abstract double calcularSalarioMensal();
}
