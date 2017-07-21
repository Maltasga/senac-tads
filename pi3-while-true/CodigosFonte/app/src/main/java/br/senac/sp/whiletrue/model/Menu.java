
package br.senac.sp.whiletrue.model;

/**
 *
 * @author While True
 */
public class Menu {
    private int id;
    private String nome;
    private String caminho;

    public Menu(int id, String nome, String caminho) {
        this.id = id;
        this.nome = nome;
        this.caminho = caminho;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCaminho() {
        return caminho;
    }
}
