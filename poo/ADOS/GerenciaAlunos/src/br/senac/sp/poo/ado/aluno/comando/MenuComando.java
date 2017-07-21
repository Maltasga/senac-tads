package br.senac.sp.poo.ado.aluno.comando;

public class MenuComando implements Comando {

	@Override
	public void executar() {
		System.out.println("Lista de Comandos:");
		System.out.println("\t[1] - Consultar Aluno pela Matrícula");
		System.out.println("\t[2] - Menu");
		System.out.println("\t[3] - Matricular Aluno");
		System.out.println("\t[4] - Listar Alunos");
		System.out.println("\t[5] - Atualizar Cadastro");
		System.out.println("\t[6] - Remover Matrícula");
		System.out.println("\t[7] - Encerrar");
	}

}
