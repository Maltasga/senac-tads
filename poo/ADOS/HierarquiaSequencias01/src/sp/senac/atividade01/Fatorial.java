package sp.senac.atividade01;

/**
 *
 * @author Gabriel Malta
 */
public class Fatorial {

    private int numero;
    private int fat;

    public Fatorial(int numero) {
        this.numero = numero;
        this.fat = numero;
    }

    public int valorAtual() {
        return this.numero;
    }

    public int proximoValor() {
        if (fat >= 1) {
            numero = numero * --fat;
        }
        return 1;
    }
}
