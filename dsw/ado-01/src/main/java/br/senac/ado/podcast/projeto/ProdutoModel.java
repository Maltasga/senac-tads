package br.senac.ado.podcast.projeto;

/**
 *
 * @author gabriel malta
 */
public class ProdutoModel {
    String nome;
    String descricao;
    double valor;
    ImagemModel imagem;

    public ProdutoModel(String nome, String descricao, double valor, ImagemModel imagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public ImagemModel getImagem() {
        return imagem;
    }
}
