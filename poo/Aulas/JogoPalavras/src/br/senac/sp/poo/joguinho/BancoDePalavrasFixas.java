package br.senac.sp.poo.joguinho;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Gabriel Malta
 */
public class BancoDePalavrasFixas implements BancoDePalavras {

    private Random random = null;
    private ArrayList<String> palavras = null;

    public BancoDePalavrasFixas() {
        random = new Random();
        palavras = new ArrayList<>();
        palavras.add("palavra");
        palavras.add("fixa");
        palavras.add("banco");
        palavras.add("permuta");
        palavras.add("banco");
        palavras.add("proxima");
        palavras.add("baralho");
    }

    @Override
    public String proximaPalavra() {
        return this.palavras.get(random.nextInt(palavras.size()));
    }

}
