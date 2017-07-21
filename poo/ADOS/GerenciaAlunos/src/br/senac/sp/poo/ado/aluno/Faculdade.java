package br.senac.sp.poo.ado.aluno;

import java.util.Collection;

public class Faculdade {

	private AlunoDao alunoDao;

	public Faculdade(AlunoDao alunoDao) {
		this.alunoDao = alunoDao;
	}

	public void matricular(Aluno aluno) {
		alunoDao.create(aluno);
	}

	public Aluno consultarAluno(Integer matricula) {
		return alunoDao.read(matricula);
	}

	public Collection<Aluno> listarTodosAlunos() {
		return alunoDao.findAll();
	}

	public void atualizarDadosAluno(Aluno aluno) {
		alunoDao.update(aluno);
	}

	public void removerMatricula(Integer matricula) {
		alunoDao.delete(matricula);
	}

}
