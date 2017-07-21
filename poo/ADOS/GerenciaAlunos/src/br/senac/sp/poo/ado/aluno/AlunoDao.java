package br.senac.sp.poo.ado.aluno;

import java.util.Collection;

public interface AlunoDao {

	/**
	 * @param aluno
	 */
	void create(Aluno aluno);

	/**
	 * @param matricula
	 * @return
	 */
	Aluno read(Integer matricula);

	/**
	 * @param aluno
	 * @return
	 */
	void update(Aluno aluno);

	/**
	 * @param matricula
	 * @return
	 */
	void delete(Integer matricula);

	/**
	 * @return
	 */
	Collection<Aluno> findAll();
}
