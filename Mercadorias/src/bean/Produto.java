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
public class Produto {
    private int idPr;
    private String nomePr;
    private double valorPr;

    public Produto(int idPr, String nomePr, float valorPr) {
        this.idPr = idPr;
        this.nomePr = nomePr;
        this.valorPr = valorPr;
    }

    public Produto() {
    }

    public Produto(int idPr) {
        this.idPr = idPr;
    }
    
    public Produto(String nomePr) {
        this.nomePr = nomePr;
    }
    
    
    public Produto(String nomePr, float valorPr) {
        this.nomePr = nomePr;
        this.valorPr = valorPr;
    }
    

    public int getIdPr() {
        return idPr;
    }

    public void setIdPr(int idPr) {
        this.idPr = idPr;
    }

    public String getNomePr() {
        return nomePr;
    }

    public void setNomePr(String nomePr) {
        this.nomePr = nomePr;
    }

    public double getValorPr() {
        return valorPr;
    }

    public void setValorPr(double valorPr) {
        this.valorPr = valorPr;
    }
}
