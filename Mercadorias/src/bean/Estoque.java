/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author marcos augusto
 */
public class Estoque {
    private int idE;
    private String nomeE;
    private Produto P;
    private int qtdP;

    public Estoque(int idE, String nomeE, Produto P, int qtdP) {
        this.idE = idE;
        this.nomeE = nomeE;
        this.P = P;
        this.qtdP = qtdP;
    }

    public Estoque(String nomeE, Produto P, int qtdP) {
        this.nomeE = nomeE;
        this.P = P;
        this.qtdP = qtdP;
    }
    
    public Estoque() {
    }

    public Estoque(int idE) {
        this.idE = idE;
    }

    public Estoque(String nomeE) {
        this.nomeE = nomeE;
    }
    
    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public String getNomeE() {
        return nomeE;
    }

    public void setNomeE(String nomeE) {
        this.nomeE = nomeE;
    }

    public Produto getP() {
        return P;
    }

    public void setP(Produto P) {
        this.P = P;
    }

    public int getQtdP() {
        return qtdP;
    }

    public void setQtdP(int qtdP) {
        this.qtdP = qtdP;
    }
    
}
