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
public class Game {

    private int idGame;
    private String titulo;
    private String sinopse;
    private int qtdeJogador;
    private int idGenero;
    private String situacao;

    public Game() {

        this.idGame = 0;
        this.titulo = "";
        this.sinopse = "";
        this.qtdeJogador = 0;
        this.idGenero = 0;
        this.situacao = "";
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getQtdeJogador() {
        return qtdeJogador;
    }

    public void setQtdeJogador(int qtdeJogador) {
        this.qtdeJogador = qtdeJogador;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

}
