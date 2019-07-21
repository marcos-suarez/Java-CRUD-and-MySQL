/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Cliente;
import bean.Produto;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author marcos augusto
 */
public class ProdutoDAOTest {
    
    public ProdutoDAOTest() {
    }

    @Test
    @Ignore
    public void Inserir() {
        
        Produto prod = new Produto("Feijão",7.8f);
        ProdutoDAO dao = new ProdutoDAO();
        
        if (dao.create(prod)) {
            System.out.println("Produto inserido com sucesso!");
        }
        else {
           fail("ERRO AO INSERIR");
        }
    }
    
    @Test
    @Ignore
    public void ListarTodos (){
        
        ProdutoDAO dao = new ProdutoDAO();
        
        for (Produto p: dao.findAll()) {
            System.out.println("Nome do Produto: " + p.getNomePr()+" | Valor: " + p.getValorPr());
        }
    }
    
    @Test
    @Ignore
    public void Update() {
        
        Produto prod = new Produto("Arroz Integral",6.5f);
        prod.setIdPr(1);
        ProdutoDAO dao = new ProdutoDAO();
        
        if (dao.update(prod)) {
            System.out.println("Atualizado com sucesso!");
        }
        else {
           fail("ERRO AO ATUALIZAR");
        }
    }
    
    @Test
    public void Delete() {
        
        Produto prod = new Produto();
        prod.setIdPr(2);
        ProdutoDAO dao = new ProdutoDAO();
        
        if (dao.delete(prod)) {
            System.out.println("Deletado com sucesso!");
        }
        else {
           fail("ERRO AO DELETAR");
        }
    }
    
}
