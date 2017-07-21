/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.whiletrue.servico;

import br.senac.sp.whiletrue.dao.EnderecoDao;
import br.senac.sp.whiletrue.model.Endereco;
import br.senac.sp.whiletrue.model.Util;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 'Gabi
 */
public class EnderecoService {

    EnderecoDao dao;

    public EnderecoService() {
        dao = new EnderecoDao();
    }

    public Endereco get(int id, String origem) throws Exception {
        Endereco endereco = null;
        try {
            endereco = dao.obter(id, origem);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return endereco;
    }

    public void salvar(Endereco e) throws Exception {
        try {
            if (get(e.getId(), e.getOrigem()) == null) {
                dao.inserir(e);
            } else {
                dao.atualizar(e);
            }
        } catch (Exception x) {
            x.printStackTrace();
            throw new Exception("Falha ao atualizar endereço.");
        }
    }

    public ArrayList<String> validar(Endereco e) {
        ArrayList<String> listaItensInvalidos = new ArrayList<>();

        if (e.getId() < 0) {
            listaItensInvalidos.add("Valor inválido para o campo Id");
        }

        if (Util.isNullOrEmpty(e.getCep())) {
            listaItensInvalidos.add("CEP não informado");
        }

        if (!Util.isInMinLength(e.getCep().replaceAll("[^a-zA-Z0-9]", ""), 8)
                && !Util.isInMaxlength(e.getCep().replaceAll("[^a-zA-Z0-9]", ""), 8)
                || Util.stringToNumber(e.getCep())) {
            listaItensInvalidos.add("CEP deve ter 8 caracteres");
        }

        if (Util.isNullOrEmpty(e.getLogradouro())) {
            listaItensInvalidos.add("Logradouro não informado");
        }

        if (!Util.isInMaxlength(e.getLogradouro(), 100)) {
            listaItensInvalidos.add("Logradouro não pode ter mais de 100 caracteres");
        }

        if (!Util.isInMaxlength(e.getComplemento(), 30)) {
            listaItensInvalidos.add("Complemento não pode ter mais de 30 caracteres");
        }

        if (Util.isNullOrEmpty(e.getBairro())) {
            listaItensInvalidos.add("Bairro não informado");
        }

        if (!Util.isInMinLength(e.getBairro(), 5)
                && !Util.isInMaxlength(e.getBairro(), 50)) {
            listaItensInvalidos.add("Bairro deve ter entre 5 e 50 caracteres");
        }

        if (Util.isNullOrEmpty(e.getCidade())) {
            listaItensInvalidos.add("Cidade não informada");
        }

        if (!Util.isInMinLength(e.getCidade(), 3) && !Util.isInMaxlength(e.getCidade(), 50)) {
            listaItensInvalidos.add("Cidade deve ter entre 3 e 50 caracteres");
        }

        if (Util.isNullOrEmpty(e.getUf())) {
            listaItensInvalidos.add("UF não informado");
        }
        return listaItensInvalidos;

    }
}
