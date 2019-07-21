/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Cliente;
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
public class ClienteDAO {
    
    private Connection con = null;

    public ClienteDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean create(Cliente cliente){
        
        String sql = "INSERT INTO cliente (nomeC) VALUES (?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeC());
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO!"+ex);
            
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public List<Cliente> findAll (){
        
        String sql = "SELECT * From cliente";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        //Pega o que está no banco para colocar na lista
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Cliente cliente = new Cliente();
                cliente.setNomeC(rs.getString("nomeC"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO!"+ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientes;
    }
    
        public boolean update(Cliente cliente){
        
        String sql = "UPDATE cliente SET nomeC = ? WHERE idC = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeC());
            stmt.setInt(2, cliente.getIdC());
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO!"+ex);
            
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        
     public boolean delete(Cliente cliente){
        
        String sql = "DELETE FROM cliente WHERE idC = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getIdC());
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
