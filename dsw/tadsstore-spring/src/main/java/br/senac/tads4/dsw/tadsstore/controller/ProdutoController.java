package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import br.senac.tads4.dsw.tadsstore.common.service.fakeimpl.ProdutoServiceFakeImpl;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author gabri
 */
@Controller
@RequestMapping("ah-que-pena-seria")
public class ProdutoController {

    private ProdutoService service = new ProdutoServiceFakeImpl();

    @RequestMapping
    public ModelAndView lista() {
        List<Produto> produtos = service.listar(0, 0);

        return new ModelAndView("produto/lista")
                .addObject("produtos", produtos);
    }

    @RequestMapping("/{id}")
    public ModelAndView obterPorId(@PathVariable("id") Long id) {
        Produto p = service.obter(id);
        return new ModelAndView("produto/detalhe")
                .addObject("produto", p);
    }
}
