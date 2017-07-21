package br.senac.sp.poo.joguinho;

/**
 *
 * @author Gabriel Malta
 */
public interface MecanicaDoJogo {

    boolean terminou();

    boolean acertou(String palavra);

    String tentarNovamente();

    int pontuacao();
}
