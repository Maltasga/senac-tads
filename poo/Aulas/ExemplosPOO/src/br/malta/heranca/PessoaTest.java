package br.malta.heranca;

import java.util.Date;

/**
 *
 * @author Gabriel Malta
 */
public class PessoaTest {

    public static void main(String[] args) {
        PessoaFisica p = new PessoaFisica("Gabriel", new Date(1987, 11, 4), "33344455599");
        System.out.println("Nome: " + p.getNome());
        System.out.println("Nro Docto: " + p.getCpf());
    }
}
