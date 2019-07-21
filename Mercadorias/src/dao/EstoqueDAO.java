/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Estoque;
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
public class EstoqueDAO {
    
    private Connection con = null;
    
    public EstoqueDAO() {
    
        con = ConnectionFactory.getConnection();
}
    
        public boolean create(Estoque estoque){
        
        String sql = "INSERT INTO estoque (nomeE, idProduto, qtdP) VALUES (?,?,?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, estoque.getNomeE());
            stmt.setInt(2, estoque.getP().getIdPr());
            stmt.setInt(3, estoque.getQtdP());
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO!"+ex);
            
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        
        public List<Estoque> findAll (){
        
        /*VIEW SQL
        CREATE 
            ALGORITHM = UNDEFINED 
            DEFINER = `root`@`localhost` 
            SQL SECURITY DEFINER
            VIEW `mercado`.`view_estoqueproduto` AS
        SELECT 
            `e`.`idE` AS `idE`,
            `e`.`nomeE` AS `nomeE`,
            `e`.`idProduto` AS `idProduto`,
            `p`.`nomeP` AS `nomeP`,
            `e`.`qtdP` AS `qtdP`,
            `p`.`valorP` AS `valorP`
        FROM
            (`mercado`.`estoque` `e`
            JOIN `mercado`.`produto` `p` ON ((`e`.`idProduto` = `p`.`idP`)))*/
            
        String sql = "select * from view_estoqueproduto;";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        //Pega o que está no banco para colocar na lista
        List<Estoque> estoques = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Estoque estoque = new Estoque();
                Produto P = new Produto();

                estoque.setIdE(rs.getInt("idE"));
                estoque.setNomeE(rs.getString("nomeE"));
                P.setIdPr(rs.getInt("idProduto"));
                P.setNomePr(rs.getString("nomeP"));
                estoque.setQtdP(rs.getInt("qtdP"));
                P.setValorPr(rs.getFloat("valorP"));
                
                estoque.setP(P);
                
                estoques.add(estoque);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO!"+ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return estoques;
    }
        
    public boolean update(Estoque estoque){
        
        String sql = "UPDATE estoque SET nomeE = ?, idProduto = ?,qtdP = ? WHERE idE = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, estoque.getNomeE());
            stmt.setInt(2, estoque.getP().getIdPr());
            stmt.setInt(3, estoque.getQtdP());
            stmt.setInt(4, estoque.getIdE());
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO!"+ex);
            
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
       public boolean delete(Estoque estoque){
        
        String sql = "DELETE FROM estoque WHERE idE = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, estoque.getIdE());
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
