package br.senac.sp.poo.joguinho;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Gabriel Malta
 */
public class PermutaStringEmbaralhador implements Embaralhador {

    @Override
    public String embaralhar(String palavra) {
        ArrayList<Integer> indices = new ArrayList();
        for (int i = 0; i < palavra.length(); i++) {
            indices.add(i);
        }
        Collections.shuffle(indices);
        String novaPalavra = "";
        for (int i = 0; i < indices.size(); i++) {
            novaPalavra += palavra.charAt(indices.get(i));
        }
        return novaPalavra;
    }

    @Override
    public int dificuldade() {
        return 2;
    }

}
