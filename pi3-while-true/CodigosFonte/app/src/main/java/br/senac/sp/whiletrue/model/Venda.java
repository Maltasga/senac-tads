package br.senac.sp.whiletrue.model;

import br.senac.sp.whiletrue.servico.ProdutoService;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author While True
 */
public class Venda {

    private long id;
    private int idCliente;
    private int idUsuario;
    private double valor;
    private Date dataVenda;
    private ArrayList<ItemVenda> itens;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }

    public Venda(long id, int idCliente, int idUsuario, double valor, Date dataVenda, ArrayList<ItemVenda> itens) {
        this.id = id;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.valor = valor;
        this.dataVenda = dataVenda;
        this.itens = itens;
    }

    public void somaValorTotal() {
        ProdutoService service = new ProdutoService();
        double total = 0;
        for (ItemVenda item : this.itens) {
            total += (service.get(item.getIdProduto()).getValorVenda() * item.getQuantidade());
        }
        this.valor = total;
    }
}
