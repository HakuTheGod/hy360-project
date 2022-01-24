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
import mainClasses.Company_Purchase;
import mainClasses.Private_Purchase;

/**
 *
 * @author admin
 */
public class EditCompanyPurchaseTable {
    public Company_Purchase jsonToCompanyPurchase(String json){
    
        Gson gson = new Gson();
    
        Company_Purchase ca = gson.fromJson(json, Company_Purchase.class);
        return ca;
    
    }

    public void addCompanyPurchaseFromJSON(String json){
        Company_Purchase ca = jsonToCompanyPurchase(json);
        insertCompanyPurchase(ca);
    }

    public void insertCompanyPurchase(Company_Purchase ca){
        try {
            Connection con = Database_Connection.getConnection();
            try (Statement stmt = con.createStatement()) {
                String insertQuery = "INSERT INTO company_purchases"
                    +"(c_account_name, seller_name, product, employee_id, quantity, total_price, c_date) VALUES"
                    +"("
                    + "'" + ca.getAccountName()+ "',"
                    + "'" + ca.getSellerName()+ "',"
                    + "'" + ca.getProduct()+ "',"
                    + "'" + ca.getEmployeeID()+ "',"
                    + "'" + ca.getQuantity()+ "',"
                    + "'" + ca.getTotalPrice()+ "',"
                    + "CURRENT_TIMESTAMP"
                    + ")";
            
                System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
                System.out.println("# The Company purchase was successfully inserted in the database.");
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
                String insertQuery = "UPDATE company_purchases SET quantity='" + quantity + "' WHERE c_account_name='" + name + "' AND seller_name='" + seller + "' AND product='" + product + "'";
            
                System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
                System.out.println("# The Company purchase was successfully inserted in the database.");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Company_Purchase databaseToPrivatePurchase(String name) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        try{
            rs = stmt.executeQuery("SELECT * FROM company_purchases WHERE c_account_name ='" + name + "'");
            rs.next();
            String json = Database_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Company_Purchase ca = gson.fromJson(json, Company_Purchase.class);
            return ca;
        }catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null; 
    }
    
     public Company_Purchase databaseToPrivatePurchaseP(String name, String product, String seller) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        try{
            rs = stmt.executeQuery("SELECT * FROM company_purchases WHERE c_account_name='" + name + "' AND seller_name='" + seller + "' AND product='" + product + "'");
            rs.next();
            String json = Database_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Company_Purchase ca = gson.fromJson(json, Company_Purchase.class);
            return ca;
        }catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null; 
    }
}
