package sp.senac.atividade02;

import java.util.Scanner;

/**
 *
 * @author Gabriel Malta
 */
public class SeqNumerica_Teste {

    public static void main(String[] args) {

        SequenciaNumerica sequencia = null;

        System.out.println("Escolha a sequência numérica desejada:");
        System.out.println("1 - Progressão Geométrica");
        System.out.println("2 - Fatorial");
        int opcao = new Scanner(System.in).nextInt();

        if (opcao == 1) {
            sequencia = new ProgressaoGeometrica(1, 3);
            System.out.println("Progressão Geométrica");
        } else if (opcao == 2) {
            System.out.println("Fatorial");
            sequencia = new Fatorial(5);
        }

        if (sequencia != null) {
            for (int i = 0; i < 5; i++) {
                System.out.println("" + sequencia.valorAtual());
                sequencia.proximoValor();
            }
        }
    }
}
