
package sp.senac.atividade01;

/**
 *
 * @author Gabriel Malta
 */
public class Main_Teste {

    public static void main(String[] args) {
        System.out.println("Progressão Geométrica");
        ProgressaoGeometrica pg = new ProgressaoGeometrica(1, 3);
        for (int i = 0; i < 5; i++) {
            System.out.println("" + pg.valorAtual());
            pg.proximoValor();
        }
        
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("");

        System.out.println("Fatorial");
        Fatorial fat = new Fatorial(5);
        for (int i = 1; i < 6; i++) {
            System.out.println("" + fat.valorAtual());
            fat.proximoValor();
        }
    }
    
}
