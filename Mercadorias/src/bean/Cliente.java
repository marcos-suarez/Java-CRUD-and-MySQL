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
public class Cliente {
    private int idC;
    private String nomeC;

    public Cliente(int idC, String nomeC) {
        this.idC = idC;
        this.nomeC = nomeC;
    }

    public Cliente(String nomeC) {
        this.nomeC = nomeC;
    }

    public Cliente() {
    }

    public Cliente(int idC) {
        this.idC = idC;
    }
    
    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getNomeC() {
        return nomeC;
    }

    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }
}
