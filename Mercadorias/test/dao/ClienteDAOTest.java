/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author marcos augusto
 */
    public class ClienteDAOTest {
    
    public ClienteDAOTest() {
    }

    @Test
    @Ignore
    public void Inserir() {
        
        Cliente cli = new Cliente("Marcos Augusto");
        ClienteDAO dao = new ClienteDAO();
        
        if (dao.create(cli)) {
            System.out.println("Inserido com sucesso!");
        }
        else {
           fail("ERRO AO SALVAR");
        }
    }
    
    @Test
    @Ignore
    public void ListarTodos (){
        
        ClienteDAO dao = new ClienteDAO();
        
        for (Cliente c: dao.findAll()) {
            System.out.println("Nome do Cliente: " + c.getNomeC());
        }
    }
    
    @Test
    @Ignore
    public void Update() {
        
        Cliente cli = new Cliente("Marcos Augusto Suarez");
        cli.setIdC(1);
        ClienteDAO dao = new ClienteDAO();
        
        if (dao.update(cli)) {
            System.out.println("Atualizado com sucesso!");
        }
        else {
           fail("ERRO AO ATUALIZAR");
        }
    }
    
    @Test
    public void Delete() {
        
        Cliente cli = new Cliente();
        cli.setIdC(2);
        ClienteDAO dao = new ClienteDAO();
        
        if (dao.delete(cli)) {
            System.out.println("Deletado com sucesso!");
        }
        else {
           fail("ERRO AO DELETAR");
        }
    }
    
}
