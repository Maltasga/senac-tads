package br.senac.sp.ado;

/**
 *
 * @author Gabriel Malta
 */
public final class Horista extends Empregado {

    private double valorHora;

    public Horista(String nome, double valorHora) {
        super(nome);
        this.valorHora = valorHora;
    }

    public double getValorHora() {
        return valorHora;
    }

    @Override
    public double calcularSalarioMensal() {
        return valorHora * 160;
    }

    public double calcularSalarioMensal(int horasExtrasTrabalhadas) {
        double valorHoraExtra = valorHora * horasExtrasTrabalhadas;
        return (valorHora * 160) + valorHoraExtra;
    }
}
