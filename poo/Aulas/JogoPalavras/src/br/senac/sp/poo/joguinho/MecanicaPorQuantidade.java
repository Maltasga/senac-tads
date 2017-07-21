package br.senac.sp.poo.joguinho;

/**
 *
 * @author gabri
 */
public class MecanicaPorQuantidade implements MecanicaDoJogo {

    private int quantidade;
    private int rodada;

    private FabricaEmbaralhador fabrica;
    private BancoDePalavras bancoPalavras;
    private Embaralhador embaralhador;
    private String palavraSorteada;
    private int pontuacao;

    public MecanicaPorQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.rodada = 1;
        this.pontuacao = 0;

        this.fabrica = new FabricaEmbaralhador();
        this.bancoPalavras = new BancoDePalavrasFixas();
    }

    @Override
    public boolean terminou() {
        return rodada > quantidade;
    }

    @Override
    public boolean acertou(String palavra) {
        if (palavraSorteada.equals(palavra)) {
            pontuacao += embaralhador.dificuldade();
            return true;
        }
        return false;
    }

    @Override
    public String tentarNovamente() {
        rodada++;
        palavraSorteada = bancoPalavras.proximaPalavra();
        embaralhador = fabrica.criar();
        return embaralhador.embaralhar(palavraSorteada);
    }

    @Override
    public int pontuacao() {
        return this.pontuacao;
    }

}
