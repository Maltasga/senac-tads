package sp.senac.atividade02;

/**
 *
 * @author Gabriel Malta
 */
public class ProgressaoGeometrica extends SequenciaNumerica {

    public ProgressaoGeometrica(int valorInicial, int razao) {
        super(valorInicial, razao);
    }

    @Override
    public void proximoValor() {
        this.primeiroTermo *= segundoTermo;
    }
}
