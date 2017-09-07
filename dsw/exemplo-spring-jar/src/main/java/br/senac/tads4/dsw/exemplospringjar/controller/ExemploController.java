package br.senac.tads4.dsw.exemplospringjar.controller;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author gabri
 */
@Controller
public class ExemploController {

    @RequestMapping("/q")
    public String executar() {
        return "exemplo";
    }

    @RequestMapping("/w")
    public String execuar2(@RequestParam("nome") String nome, @RequestParam("idade") int idade, Model modelo) {

        modelo.addAttribute("nomeAttr", nome);
        modelo.addAttribute("idadeAttr", idade);

        return "exemplo2";
    }

    @RequestMapping("/e")
    public String listarProdutos(Model modelo) {

        ArrayList<Produto> produtos = new ArrayList();
        for (int i = 1; i < 6; i++) {
            produtos.add(new Produto("Produto " + i, i * Math.PI, new Date()));
        }

        modelo.addAttribute("produtos", produtos);
        return "produtos";
    }
}
