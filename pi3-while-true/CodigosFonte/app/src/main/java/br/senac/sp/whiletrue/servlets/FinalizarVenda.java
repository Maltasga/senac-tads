package br.senac.sp.whiletrue.servlets;

import br.senac.sp.whiletrue.model.ItemVenda;
import br.senac.sp.whiletrue.model.Usuario;
import br.senac.sp.whiletrue.model.Venda;
import br.senac.sp.whiletrue.servico.VendaService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author While True
 */
@WebServlet(urlPatterns = {"/finalizar-venda"})
public class FinalizarVenda extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<ItemVenda> itens = new ArrayList<>();
        Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        try {
            Map<String, String[]> map = request.getParameterMap();
            int indexMap = 0;
            while (true) {
                if (map.containsKey("itens[" + indexMap + "].idVenda")) {
                    String[] idProduto = map.get("itens[" + indexMap + "].idProduto");
                    String[] tamanho = map.get("itens[" + indexMap + "].tamanho");
                    String[] quantidade = map.get("itens[" + indexMap + "].quantidade");

                    ItemVenda item = new ItemVenda(
                            0,
                            Integer.parseInt(idProduto[0]),
                            tamanho[0],
                            Integer.parseInt(quantidade[0]));
                    itens.add(item);
                    indexMap++;
                } else {
                    break;
                }
            }
            Venda venda = new Venda(
                    0,
                    idCliente,
                    usuarioLogado.getId(),
                    0,
                    GregorianCalendar.getInstance().getTime(),
                    itens);

            VendaService service = new VendaService();
            service.salvar(venda);

            request.setAttribute("msgFimVenda", "Venda finalizada com sucesso.");
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("msgFimVenda", "Falha ao concluir a venda.");
        }
        request.getRequestDispatcher("WEB-INF/pdv/posvenda.jsp")
                .forward(request, response);
    }
}
