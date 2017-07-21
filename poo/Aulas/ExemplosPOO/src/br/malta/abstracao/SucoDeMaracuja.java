package br.malta.abstracao;

import java.util.ArrayList;

/**
 *
 * @author Gabriel Malta
 */
public class SucoDeMaracuja implements Suco {

    @Override
    public void preparar(ArrayList<Fruta> frutas) {
        for (Fruta fruta : frutas) {
            System.out.println("Preparando " + fruta.getNome());
        }
        
        System.out.println("Suco de maracujá está pronto!");
    }

}
