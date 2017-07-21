package br.senac.sp.poo.joguinho;

import java.util.Scanner;

/**
 *
 * @author Gabriel Malta
 */
public class JogoEmbaralhador {

    private Scanner scan = null;
    private MecanicaDoJogo mecanica;

    public JogoEmbaralhador() {
        this.scan = new Scanner(System.in);
        this.mecanica = new MecanicaPorQuantidade(5);
    }

    public void executa() {
        while (!mecanica.terminou()) {
            String palavraEmbaralhada = mecanica.tentarNovamente();
            System.out.println("Qual é a palavra: " + palavraEmbaralhada);

            System.out.println("Digite a palavra correta: ");
            String tentativa = scan.next();

            if (mecanica.acertou(tentativa)) {
                System.out.println("ACERTOU!");
            } else {
                System.out.println("ERROU!");
            }
        }

        System.out.println("Pontuação: " + this.mecanica.pontuacao());
    }
}
