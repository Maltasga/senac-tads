package br.senac.sp.poo.joguinho;

import java.util.Random;

/**
 *
 * @author Gabriel Malta
 */
public class FabricaEmbaralhador {

    public Embaralhador criar() {
        Random r = new Random();
        if (r.nextInt(10000) % 2 == 0) {
            return new InverteStringEmbaralhador();
        } else {
            return new PermutaStringEmbaralhador();
        }
    }
}
