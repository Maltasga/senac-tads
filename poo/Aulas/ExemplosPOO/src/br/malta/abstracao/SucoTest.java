package br.malta.abstracao;

import java.util.ArrayList;

/**
 *
 * @author Gabriel Malta
 */
public class SucoTest {

    public static void main(String[] args) {
        Suco vitamina = new Vitamina();
        
        ArrayList<Fruta> frutas = new ArrayList<>();
        frutas.add(new Mamao());
        frutas.add(new Banana());
        
        vitamina.preparar(frutas);
    }
}
