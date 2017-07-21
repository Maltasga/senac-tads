package sp.senac.atividade02;

/**
 *
 * @author Gabriel Malta
 */
public class Fatorial extends SequenciaNumerica {

    public Fatorial(int numero) {
        super(numero, numero);
    }

    @Override
    public void proximoValor() {
            primeiroTermo = primeiroTermo * --segundoTermo;
        
    }
}
