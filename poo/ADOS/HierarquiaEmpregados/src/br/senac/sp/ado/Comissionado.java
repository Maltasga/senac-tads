package br.senac.sp.ado;

/**
 *
 * @author Gabriel Malta
 */
public final class Comissionado extends Assalariado {

    private double taxaComissao;

    public Comissionado(String nome, double salarioMensal, double taxaComissao) {
        super(nome, salarioMensal);
        this.taxaComissao = taxaComissao;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    public double calcularSalarioMensal(double valorVendas) {
        double comissao = valorVendas * taxaComissao;
        return super.calcularSalarioMensal() + comissao;
    }
}
