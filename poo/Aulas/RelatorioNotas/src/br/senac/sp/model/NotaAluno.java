package br.senac.sp.model;

/**
 *
 * @author Gabriel Malta
 */
public class NotaAluno {
    String nome;
    int nota;

    public NotaAluno(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
