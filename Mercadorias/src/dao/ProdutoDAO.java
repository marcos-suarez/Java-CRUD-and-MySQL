/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Produto;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos augusto
 */
public class ProdutoDAO {
    
    private Connection con = null;

    public ProdutoDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean create(Produto produto){
        
        String sql = "INSERT INTO produto (nomeP, valorP) VALUES (?,?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNomePr());
            stmt.setDouble(2, produto.getValorPr());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO!"+ex);
            
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Produto> findAll (){
        
        String sql = "SELECT * From produto";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        //Pega o que está no banco para colocar na lista
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Produto produto = new Produto();
                produto.setNomePr(rs.getString("nomeP"));
                produto.setValorPr(rs.getFloat("valorP"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO!"+ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;
    }
    
     public boolean update(Produto produto){
        
        String sql = "UPDATE produto SET nomeP = ?, valorP = ? WHERE idP = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNomePr());
            stmt.setDouble(2, produto.getValorPr());
            stmt.setInt(3, produto.getIdPr());
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO!"+ex);
            
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     
     public boolean delete(Produto produto){
        
        String sql = "DELETE FROM produto WHERE idP = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, produto.getIdPr());
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO!"+ex);
            
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
