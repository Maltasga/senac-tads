package sp.senac.atividade01;

/**
 *
 * @author Gabriel Malta
 */
public class ProgressaoGeometrica {

    private int valorAtual;
    private int razao;

    public ProgressaoGeometrica(int valorAtual, int razao) {
        this.valorAtual = valorAtual;
        this.razao = razao;
    }

    public int valorAtual() {
        return this.valorAtual;
    }

    public int proximoValor() {
        this.valorAtual *= razao;
        return this.valorAtual;
    }
}
