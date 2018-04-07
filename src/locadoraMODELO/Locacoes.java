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
public class Locacoes {

    private int id;
    private int idLocacao;
    private String nomeCliente;
    private String telefone;
    private String dtLocacao;
    private String dtDevolucao;
    private float valor;
    private int idGame;

    public Locacoes() {

        this.id = 0;
        this.dtDevolucao = "";
        this.dtLocacao = "";
        this.idGame = 0;
        this.idLocacao = 0;
        this.nomeCliente = "";
        this.telefone = "";
        this.valor = 0;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDtLocacao() {
        return dtLocacao;
    }

    public void setDtLocacao(String dtLocacao) {
        this.dtLocacao = dtLocacao;
    }

    public String getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(String dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

}
