package br.senac.sp.poo.ado.aluno.comando;

import br.senac.sp.poo.ado.aluno.Aluno;
import br.senac.sp.poo.ado.aluno.Faculdade;
import java.util.Scanner;

public class AtualizarCadastroAlunoComando implements Comando {

    private Faculdade faculdade;
    private Scanner scanner;

    public AtualizarCadastroAlunoComando(Faculdade faculdade, Scanner scanner) {
        this.faculdade = faculdade;
        this.scanner = scanner;
    }

    public void executar() {
        System.out.print("Digite o número da matrícula: ");
        Integer matricula = scanner.nextInt();
        Aluno aluno = faculdade.consultarAluno(matricula);
        System.out.print("Digite o novo nome do Aluno: ");
        String nome = scanner.next();
        aluno.setNome(nome);
        faculdade.atualizarDadosAluno(aluno);
        System.out.println("Matricula Atualizada");
    }

}
