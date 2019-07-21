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
public class PedidoDAO {
    
    private Connection con = null;
    
    public PedidoDAO() {
    
        con = ConnectionFactory.getConnection();
}
    
        public boolean create(Pedido pedido){
        
        String sql = "INSERT INTO pedido (idCli, idProd, idEst, valorPed) VALUES (?,?,?,?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pedido.getC().getIdC());
            stmt.setInt(2, pedido.getP().getIdPr());
            stmt.setInt(3, pedido.getE().getIdE());
            stmt.setDouble(4, pedido.getValorPed());
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO!"+ex);
            
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        
         public List<Pedido> findAll (){
            
        String sql = "select * from view_pedidoall;";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        //Pega o que está no banco para colocar na lista
        List<Pedido> pedidos = new ArrayList<>();
        
        /*VIEW SQL
        CREATE 
            ALGORITHM = UNDEFINED 
            DEFINER = `root`@`localhost` 
            SQL SECURITY DEFINER
            VIEW `mercado`.`view_pedidoall` AS
        SELECT 
            `ped`.`idPed` AS `idPed`,
            `c`.`idC` AS `idC`,
            `c`.`nomeC` AS `nomeC`,
            `pro`.`idP` AS `idP`,
            `pro`.`nomeP` AS `nomeP`,
            `pro`.`valorP` AS `valorP`,
            `e`.`idE` AS `idE`,
            `e`.`nomeE` AS `nomeE`,
            `ped`.`valorPed` AS `valorPed`
        FROM
            (((`mercado`.`pedido` `ped`
            JOIN `mercado`.`cliente` `c` ON ((`ped`.`idCli` = `c`.`idC`)))
            JOIN `mercado`.`produto` `pro` ON ((`ped`.`idProd` = `pro`.`idP`)))
            JOIN `mercado`.`estoque` `e` ON ((`ped`.`idEst` = `e`.`idE`))) */
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Pedido pedido = new Pedido();
                Cliente C = new Cliente();
                Produto P = new Produto();
                Estoque E = new Estoque();

                pedido.setIdPed(rs.getInt("idPed"));
                C.setIdC((rs.getInt("idC")));
                C.setNomeC(rs.getString("nomeC"));
                P.setIdPr(rs.getInt("idP"));
                P.setNomePr(rs.getString("nomeP"));
                P.setValorPr(rs.getDouble("valorP"));
                E.setIdE(rs.getInt("idE"));
                E.setNomeE(rs.getString("nomeE"));
                pedido.setValorPed(rs.getDouble("valorPed"));
                
                pedido.setC(C);
                pedido.setP(P);
                pedido.setE(E);
                
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO!"+ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pedidos;
    }
         
    public boolean update(Pedido pedido){
        
        String sql = "UPDATE pedido SET idCli = ?, idProd = ?, idEst = ?, valorPed = ? WHERE idPed = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pedido.getC().getIdC());
            stmt.setInt(2, pedido.getP().getIdPr());
            stmt.setInt(3, pedido.getE().getIdE());
            stmt.setDouble(4, pedido.getValorPed());
            stmt.setInt(5, pedido.getIdPed());
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO!"+ex);
            
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
     public boolean delete(Pedido pedido){
        
        String sql = "DELETE FROM pedido WHERE idPed = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pedido.getIdPed());
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
