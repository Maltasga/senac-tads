package br.senac.ado.podcast.projeto;

import java.util.ArrayList;

/**
 *
 * @author gabriel malta
 */
public class ProdutoDAO {

    private ArrayList<ProdutoModel> produtos;

    public ProdutoDAO() {
        produtos = new ArrayList();
        produtos.add(new ProdutoModel("Reserva", "Camiseta Reserva Pica Pau Warhol Preta", 89.99, new ImagemModel(0, "p1-camiseta-reserva.jpg", "Camiseta Reserva Pica Pau Warhol Preta")));
        produtos.add(new ProdutoModel("Calvin Klein Jeans", "Camiseta Calvin Klein Jeans Go For Branca", 83.89, new ImagemModel(1, "p2-camiseta-calvinklein.jpg", "Camiseta Calvin Klein Jeans Go For Branca")));
        produtos.add(new ProdutoModel("FiveBlu", "Camiseta Lemon Grove Authentic Cinza", 39.90, new ImagemModel(2, "p3-camiseta-lemon.jpg", "Camiseta Lemon Grove Authentic Cinza")));
        produtos.add(new ProdutoModel("Colcci", "Camiseta Colcci Collective Preta", 79.99, new ImagemModel(3, "p4-camiseta-colcci.jpg", "Camiseta Colcci Collective Preta")));
        produtos.add(new ProdutoModel("Aramis", "Camiseta Aramis Élémentaire Preta", 79.99, new ImagemModel(4, "p5-camiseta-aramis.jpg", "Camiseta Aramis Élémentaire Preta")));
        produtos.add(new ProdutoModel("Blitzart", "Camiseta Blitzart Game of Thrones - House Stark", 38.99, new ImagemModel(5, "p6-camiseta-blitzart.jpg", "Camiseta Blitzart Game of Thrones - House Stark")));
        produtos.add(new ProdutoModel("Rip Curl", "Camiseta Rip Curl Palms Vermelha", 54.99, new ImagemModel(6, "p7-camiseta-ripcurl.jpg", "Camiseta Rip Curl Palms Vermelha")));
        produtos.add(new ProdutoModel("Aleatory", "Camiseta Aleatory Bordado Azul", 59.99, new ImagemModel(7, "p8-camiseta-aleatory.jpg", "Camiseta Aleatory Bordado Azul")));
        produtos.add(new ProdutoModel("Quiksilver", "Camiseta Quiksilver Slim Fit Plit Photo Azul", 54.99, new ImagemModel(8, "p9-camiseta-quiksilver.jpg", "Camiseta Quiksilver Slim Fit Plit Photo Azul")));
        produtos.add(new ProdutoModel("Hang Loose", "Camiseta Hang Loose Flower Cinza", 59.99, new ImagemModel(8, "p10-camiseta-hangloose.jpg", "Camiseta Hang Loose Flower Cinza")));
    }

    public ArrayList<ProdutoModel> getProdutos() {
        return produtos;
    }
}
