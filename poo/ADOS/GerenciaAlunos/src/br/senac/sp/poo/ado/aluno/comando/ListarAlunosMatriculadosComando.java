package br.senac.sp.poo.ado.aluno.comando;

import br.senac.sp.poo.ado.aluno.Aluno;
import br.senac.sp.poo.ado.aluno.Faculdade;

public class ListarAlunosMatriculadosComando implements Comando {

	private Faculdade faculdade;

	public ListarAlunosMatriculadosComando(Faculdade faculdade) {
		this.faculdade = faculdade;
	}

	@Override
	public void executar() {
		System.out.println("Lista de Alunos Matriculados: ");
		for (Aluno aluno : faculdade.listarTodosAlunos()) {
			System.out.println("\t[" + aluno.getMatricula() + "] " + aluno.getNome());
		}
	}

}
