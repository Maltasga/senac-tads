package br.senac.sp.ado;

import java.util.ArrayList;

/**
 *
 * @author Gabriel Malta
 */
public class ProgramaPrincipalEmpregado {
    
    public static void main(String[] args) {
        Assalariado assalariado = new Assalariado("Assalariado", 1000.0);        
        Comissionado comissionado = new Comissionado("Comissionado", 1000.0, 0.05);        
        Horista horista = new Horista("Horista", 10.0);
        
        
//        System.out.println("---------------TESTE OUTROS CALCULOS---------------------");
//        System.out.println("Assalariado com 10 horas extras: " + assalariado.calcularSalarioMensal(10));
//        System.out.println("Comissionado com 500,00 em vendas (taxa de 0,05): " + comissionado.calcularSalarioMensal(500.0));
//        System.out.println("Horista com 10 horas extras: "+horista.calcularSalarioMensal(10));
//        System.out.println("---------------------------------------------------------");
        
        ArrayList<Empregado> empregados = new ArrayList<>();
        empregados.add(assalariado);
        empregados.add(comissionado);
        empregados.add(horista);
        
        for (Empregado e : empregados) {
            System.out.print("Nome: " + e.getNome());
            System.out.println(" - Salário: " + e.calcularSalarioMensal());
        }
    }
}
