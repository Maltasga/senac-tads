package sp.senac.atividade02;

/**
 *
 * @author Gabriel Malta
 */
public class SequenciaNumerica {

    protected int primeiroTermo;
    protected int segundoTermo;

    public SequenciaNumerica(int a, int b) {
        this.primeiroTermo = a;
        this.segundoTermo = b;
    }

    public void proximoValor() {
    }

    public int valorAtual() {
        return this.primeiroTermo;
    }
}
