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
public class Pedido {
   private int idPed;
   private Cliente C;
   private Produto P;
   private Estoque E;
   private double valorPed;

    public Pedido(int idPed, Cliente C, Produto P, Estoque E, double valorPed) {
        this.idPed = idPed;
        this.C = C;
        this.P = P;
        this.E = E;
        this.valorPed = valorPed;
    }

    public Pedido(int idPed) {
        this.idPed = idPed;
    }
    
    public Pedido() {
    }
    
    public int getIdPed() {
        return idPed;
    }

    public void setIdPed(int idPed) {
        this.idPed = idPed;
    }

    public Cliente getC() {
        return C;
    }

    public void setC(Cliente C) {
        this.C = C;
    }

    public Produto getP() {
        return P;
    }

    public void setP(Produto P) {
        this.P = P;
    }

    public Estoque getE() {
        return E;
    }

    public void setE(Estoque E) {
        this.E = E;
    }

    public double getValorPed() {
        return valorPed;
    }

    public void setValorPed(double valorPed) {
        this.valorPed = valorPed;
    }
   
}
