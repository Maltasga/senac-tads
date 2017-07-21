package br.senac.sp.whiletrue.model;

/**
 *
 * @author While True
 */
public class ItemVenda {

    private long idVenda;
    private int idProduto;
    private String tamanho;
    private int quantidade;

    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }    

    public ItemVenda(long idVenda, int idProduto, String tamanho, int quantidade) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
    }
}
