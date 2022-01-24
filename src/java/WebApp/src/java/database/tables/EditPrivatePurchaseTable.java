/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.tables;

import com.google.gson.Gson;
import database.Database_Connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainClasses.Private_Purchase;
import mainClasses.Private_account;

/**
 *
 * @author admin
 */
public class EditPrivatePurchaseTable {
     public Private_Purchase jsonToPrivatePurchase(String json){
    
        Gson gson = new Gson();
    
        Private_Purchase pa = gson.fromJson(json, Private_Purchase.class);
        return pa;
    
    }

    public void addPrivatePurchaseFromJSON(String json){
        Private_Purchase pa = jsonToPrivatePurchase(json);
        insertPrivatePurchase(pa);
    }

    public void insertPrivatePurchase(Private_Purchase pa){
        try {
            Connection con = Database_Connection.getConnection();
            try (Statement stmt = con.createStatement()) {
                String insertQuery = "INSERT INTO private_purchases"
                    +"(p_account_name, seller_name, product, quantity, total_price) VALUES"
                    +"("
                    + "'" + pa.getAccountName()+ "',"
                    + "'" + pa.getSellerName()+ "',"
                    + "'" + pa.getProduct()+ "',"
                    + "'" + pa.getQuantity()+ "',"
                    + "'" + pa.getTotalPrice()+ "'"
                    + ")";
            
                System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
                System.out.println("# The private purchase was successfully inserted in the database.");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void updateQuantity(int quantity, String name, String seller, String product){
        try {
            Connection con = Database_Connection.getConnection();
            try (Statement stmt = con.createStatement()) {
                String insertQuery = "UPDATE private_purchases SET quantity='" + quantity + "' WHERE p_account_name='" + name + "' AND seller_name='" + seller + "' AND product='" + product + "'";
            
                System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
                System.out.println("# The private purchase was successfully inserted in the database.");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Private_Purchase databaseToPrivatePurchase(String name) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        try{
            rs = stmt.executeQuery("SELECT * FROM private_purchases WHERE p_account_name ='" + name + "'");
            rs.next();
            String json = Database_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Private_Purchase pa = gson.fromJson(json, Private_Purchase.class);
            return pa;
        }catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null; 
    }
    
     public Private_Purchase databaseToPrivatePurchaseP(String name, String product, String seller) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        try{
            rs = stmt.executeQuery("SELECT * FROM private_purchases WHERE p_account_name='" + name + "' AND seller_name='" + seller + "' AND product='" + product + "'");
            rs.next();
            String json = Database_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Private_Purchase pa = gson.fromJson(json, Private_Purchase.class);
            return pa;
        }catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null; 
    }
}
