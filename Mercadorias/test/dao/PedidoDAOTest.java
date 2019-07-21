/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Cliente;
import bean.Estoque;
import bean.Pedido;
import bean.Produto;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author marcos augusto
 */
public class PedidoDAOTest {
    
    public PedidoDAOTest() {
    }

    @Test
    @Ignore
    public void Create() {
        Pedido ped = new Pedido();
        Cliente c = new Cliente(1);
        Estoque e = new Estoque(1);
        Produto p = new Produto(2);
        
        ped.setC(c);
        ped.setE(e);
        ped.setP(p);
        ped.setValorPed(1500);
        
        PedidoDAO dao = new PedidoDAO();
        
        if(dao.create(ped)){
            System.out.println("SALVO COM SUCESSO!");
        }else{
            fail("ERRO AO SALVAR!");
        }
    }
    
    @Test
    @Ignore
    public void ListarTodos (){
        
        PedidoDAO dao = new PedidoDAO();
        
        for (Pedido p: dao.findAll()) {
            System.out.println("Id do Pedido: "+ p.getIdPed() +"| Id do Cliente: " + p.getC().getIdC() + "| Nome do Cliente:: " + p.getC().getNomeC() + 
                    "| Id do Produto: " + p.getP().getIdPr() + "| Nome do produto: " + p.getP().getNomePr()
                    +"| Valor do Produto: " + p.getP().getValorPr() + "| Id do Estoque: " + p.getE().getIdE()
                    + "| Nome do Estoque: " + p.getE().getNomeE()+ "| Valor Final do Pedido: " + p.getValorPed());
        }
    }
    
    @Test
    @Ignore
    public void Update() {
        
        Pedido ped = new Pedido(2);
        Cliente c = new Cliente(3);
        Estoque e = new Estoque(2);
        Produto prod = new Produto(1);
        
        ped.setC(c);
        ped.setE(e);
        ped.setP(prod);
        ped.setValorPed(3000);
        
        PedidoDAO dao = new PedidoDAO();
        
        if (dao.update(ped)) {
            System.out.println("Atualizado com sucesso!");
        }
        else {
           fail("ERRO AO ATUALIZAR");
        }
    }
    
     @Test
    public void Delete() {
        
        Pedido ped = new Pedido();
        ped.setIdPed(2);
        PedidoDAO dao = new PedidoDAO();
        
        if (dao.delete(ped)) {
            System.out.println("Deletado com sucesso!");
        }
        else {
           fail("ERRO AO DELETAR");
        }
    }
    
}
