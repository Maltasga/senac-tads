package br.malta.encapsulamento;

/**
 *
 * @author Gabriel Malta
 */
public class Imposto {

    private double taxa;

    public Imposto(double taxa) {
        this.taxa = taxa;
    }

    public double calcular(double valor) {
        return valor * taxa;
    }
}
