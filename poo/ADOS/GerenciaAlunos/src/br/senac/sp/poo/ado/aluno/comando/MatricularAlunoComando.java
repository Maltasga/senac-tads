package br.senac.sp.poo.ado.aluno.comando;

import br.senac.sp.poo.ado.aluno.Aluno;
import br.senac.sp.poo.ado.aluno.Faculdade;
import java.util.Scanner;

public class MatricularAlunoComando implements Comando {

    private Faculdade faculdade;
    private Scanner scanner;

    public MatricularAlunoComando(Faculdade faculdade, Scanner scanner) {
        this.faculdade = faculdade;
        this.scanner = scanner;
    }

    public void executar() {
        System.out.print("  Digite o nome: ");
        String nome = scanner.next();
        System.out.print(" Digite a matricula: ");
        int matricula = scanner.nextInt();
        Aluno aluno = new Aluno(nome, matricula);
        faculdade.matricular(aluno);
        System.out.println("Aluno matriculado");
    }

}
