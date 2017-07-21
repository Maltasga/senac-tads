package br.senac.sp.whiletrue.model;

import java.util.ArrayList;

/**
 *
 * @author While True
 */
public class Perfil {

    private int id;
    private String nome;
    private ArrayList<Menu> menus;

    public Perfil(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Menu> getMenus() {
        if (menus == null) {
            // obter menus MenuService
        }
        return menus;
    }
}
