package br.senac.sp.poo.joguinho;

/**
 *
 * @author Gabriel Malta
 */
public class InverteStringEmbaralhador implements Embaralhador {

    @Override
    public String embaralhar(String palavra) {
        String reverse = "";
        for (int i = palavra.length() - 1; i >= 0; i--) {
            reverse += palavra.charAt(i);
        }
        return reverse;
    }

    @Override
    public int dificuldade() {
        return 1;
    }

}
