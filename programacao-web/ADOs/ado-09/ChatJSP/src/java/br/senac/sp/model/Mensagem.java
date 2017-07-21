package br.senac.sp.model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Gabriel Malta
 */
public class Mensagem {

    private String conteudo;
    private Date data;
    private Usuario usuario;

    public Mensagem(String conteudo, Usuario usuario) {
        this.conteudo = conteudo;
        this.usuario = usuario;
        this.data = Calendar.getInstance().getTime();
    }

    public String getConteudo() {
        return conteudo;
    }

    public Date getData() {
        return data;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}