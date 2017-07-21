package br.senac.sp.poo.ado.aluno.comando;

import java.util.Scanner;

import br.senac.sp.poo.ado.aluno.Aluno;
import br.senac.sp.poo.ado.aluno.Faculdade;

public class ConsultarAlunoComando implements Comando {
	private Faculdade faculdade;
	private Scanner scanner;

	public ConsultarAlunoComando(Faculdade faculdade, Scanner scanner) {
		this.faculdade = faculdade;
		this.scanner = scanner;
	}

	public void executar() {
		System.out.print("Digite o número da matrícula: ");
		Integer matricula = scanner.nextInt();
		Aluno aluno = faculdade.consultarAluno(matricula);
		System.out.println("Nome: " + aluno.getNome());
	}
}
