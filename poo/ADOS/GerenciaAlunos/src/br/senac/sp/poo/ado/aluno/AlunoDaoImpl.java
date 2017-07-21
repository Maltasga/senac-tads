package br.senac.sp.poo.ado.aluno;

import java.util.ArrayList;
import java.util.Collection;

public class AlunoDaoImpl implements AlunoDao {

    private ArrayList<Aluno> alunos = new ArrayList<>();

    @Override
    public void create(Aluno aluno) {
        alunos.add(aluno);

    }

    @Override
    public Aluno read(Integer matricula) {
        Aluno a = null;
        for (Aluno item : alunos) {
            if (item.equals(matricula)) {
                a = item;
                break;
            }
        }
        return a;
    }

    @Override
    public void update(Aluno aluno) {
        for (Aluno item : alunos) {
            if (item.equals(aluno.getMatricula())) {
                item.setNome(aluno.getNome());
            }
        }
    }

    @Override
    public void delete(Integer matricula) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).equals(matricula)) {
                alunos.remove(i);
                break;
            }
        }
    }

    @Override
    public Collection<Aluno> findAll() {
        return alunos;
    }
}
