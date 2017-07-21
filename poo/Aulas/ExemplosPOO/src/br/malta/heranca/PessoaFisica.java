package br.malta.heranca;

import java.util.Date;

/**
 *
 * @author Gabriel Malta
 */
public class PessoaFisica extends Pessoa {

    private String cpf;

    public PessoaFisica(String nome, Date dataNascimento, String cpf) {
        super(nome, dataNascimento);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
