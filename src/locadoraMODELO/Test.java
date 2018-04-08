/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraMODELO;

/**
 *
 * @author Taynara Kris
 */
public class Test {

    private int id_game = 0;
    private String titulo = "";
    private String descricao = "";

    public Test() {

        this.id_game = 0;
        this.titulo = "";
        this.descricao = "";

    }

    public int getId_game() {
        return id_game;
    }

    public void setId_game(int id_game) {
        this.id_game = id_game;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
