package br.senac.sp.poo.ado.aluno.comando;

import java.util.Scanner;

import br.senac.sp.poo.ado.aluno.Faculdade;

public class RemoverMatriculaComando implements Comando {
	private Scanner scanner;
	private Faculdade faculdade;

	public RemoverMatriculaComando(Faculdade faculdade, Scanner scanner) {
		this.faculdade = faculdade;
		this.scanner = scanner;
	}

	@Override
	public void executar() {
		System.out.print("Digite o número da matricula do aluno que deseja remover: ");
		Integer matricula = scanner.nextInt();

		faculdade.removerMatricula(matricula);
		System.out.print("Aluno com matrícula (" + matricula + ") desmatriculado.");
	}

}
