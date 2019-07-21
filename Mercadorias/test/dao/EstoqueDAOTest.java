/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Estoque;
import bean.Produto;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author marcos augusto
 */
public class EstoqueDAOTest {
    
    public EstoqueDAOTest() {
    }

    @Test
    @Ignore
    public void Create() {
        Estoque est = new Estoque();
        Produto p = new Produto();
        p.setIdPr(1);
        
        est.setNomeE("Quitandinha");
        est.setP(p);
        est.setQtdP(7);
        
        EstoqueDAO dao = new EstoqueDAO();
        
        if(dao.create(est)){
            System.out.println("SALVO COM SUCESSO!");
        }else{
            fail("ERRO AO SALVAR!");
        }
    }
    
    @Test
    @Ignore
    public void ListarTodos (){
        
        EstoqueDAO dao = new EstoqueDAO();
        
        for (Estoque e: dao.findAll()) {
            System.out.println("Id do Estoque: "+ e.getIdE() +"| Nome do Estoque: " + e.getNomeE() + "| Id do Produto: " + e.getP().getIdPr() + 
                    "| Nome do Produto: " + e.getP().getNomePr() + "| Quantidade: " + e.getQtdP()
                    +"| Valor: " + e.getP().getValorPr());
        }
    }
    
    @Test
    @Ignore
    public void Update() {
        
        Estoque est = new Estoque();
        Produto prod = new Produto();
        prod.setIdPr(2);
        est.setP(prod);
        est.setIdE(1);
        est.setNomeE("Quitandinha 2");
        est.setQtdP(65);
        
        EstoqueDAO dao = new EstoqueDAO();
        
        if (dao.update(est)) {
            System.out.println("Atualizado com sucesso!");
        }
        else {
           fail("ERRO AO ATUALIZAR");
        }
    }
    
    @Test
    public void Delete() {
        
        Estoque est = new Estoque();
        est.setIdE(2);
        EstoqueDAO dao = new EstoqueDAO();
        
        if (dao.delete(est)) {
            System.out.println("Deletado com sucesso!");
        }
        else {
           fail("ERRO AO DELETAR");
        }
    }
    
}
