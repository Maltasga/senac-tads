package br.senac.sp.whiletrue.servico;

import br.senac.sp.whiletrue.dao.VendaDao;
import br.senac.sp.whiletrue.model.ItemVenda;
import br.senac.sp.whiletrue.model.Usuario;
import br.senac.sp.whiletrue.model.Venda;

/**
 *
 * @author While True
 */
public class VendaService {

    private VendaDao dao;

    public VendaService() {
        dao = new VendaDao();
    }

    public void salvar(Venda venda) {
        try {
            calcularTotal(venda);
            dao.inserir(venda);
            baixaEstoque(venda);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void calcularTotal(Venda venda) {
        ProdutoService service = new ProdutoService();
        double total = 0;
        for (ItemVenda item : venda.getItens()) {
            total += (service.get(item.getIdProduto()).getValorVenda() * item.getQuantidade());
        }
        venda.setValor(total);
    }

    private void baixaEstoque(Venda venda) {
        EstoqueService estoqueService = new EstoqueService();
        UsuarioService usuarioService = new UsuarioService();
        Usuario usuarioVendedor = usuarioService.get(venda.getIdUsuario());

        for (ItemVenda item : venda.getItens()) {
            estoqueService.baixaVenda(usuarioVendedor.getIdFilial(), item.getIdProduto(), item.getTamanho(), item.getQuantidade());
        }
    }
}
