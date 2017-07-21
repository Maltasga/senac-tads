package br.senac.sp.ado;

/**
 *
 * @author Gabriel Malta
 */
public class Assalariado extends Empregado {

    private double salarioMensal;

    public Assalariado(String nome, double salarioMensal) {
        super(nome);
        this.salarioMensal = salarioMensal;
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    @Override
    public double calcularSalarioMensal() {
        return salarioMensal;
    }

    public double calcularSalarioMensal(int horasExtrasTrabalhadas) {
        double valorHoraExtra = ((salarioMensal / 160) * 1.5);
        return salarioMensal + (valorHoraExtra * horasExtrasTrabalhadas);
    }

}
