/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.tables;
import com.google.gson.Gson;
import database.Database_Connection;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainClasses.Supplier_account;

/**
 *
 * @author admin
 */
public class EditSupplierTable {
    public Supplier_account jsonToSupplierAccount(String json){
    
        Gson gson = new Gson();
    
        Supplier_account sa = gson.fromJson(json, Supplier_account.class);
        return sa;
    
    }

    public void addSupplierAccountFromJSON(String json){
        Supplier_account sa = jsonToSupplierAccount(json);
        insertUser(sa);
        insertSupplierAccount(sa);
    }

    public void insertSupplierAccount(Supplier_account sa){
        System.out.println("EDWWWWWWWWWWWWWW: " + sa.getPercent_toCCC());
        try {
            Connection con = Database_Connection.getConnection();
            try (Statement stmt = con.createStatement()) {
                String insertQuery = "INSERT INTO supplier_account"
                    +"(user_id, user_name, Products, Profit, Percent_toCCC, Debt) VALUES"
                    +"("
                    + "'" + sa.getUserID() + "',"
                    + "'" + sa.getUserName() + "',"
                    + "'" + sa.getProducts() + "',"
                    + "'" + sa.getProfit() + "',"
                    + "'" + sa.getPercent_toCCC()+ "',"
                    + "'" + sa.getDebt() + "'"
                    + ")";
            
                System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
                System.out.println("# The supplier account was successfully inserted in the database.");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertUser(Supplier_account sa){
        try {
            Connection con = Database_Connection.getConnection();
            try (Statement stmt = con.createStatement()) {
                String insertQuery = "INSERT INTO User"
                    +"(user_id, user_name) VALUES"
                    +"("
                    + "'" + sa.getUserID() + "',"
                    + "'" + sa.getUserName()
                    + "')";
            
                System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
                System.out.println("# The user was successfully inserted in the database.");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Supplier_account databaseToSupplierAccount(int id) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        try{
            rs = stmt.executeQuery("SELECT * FROM supplier_account WHERE user_id ='" + id + "'");
            rs.next();
            String json = Database_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Supplier_account sa = gson.fromJson(json, Supplier_account.class);
            return sa;
        }catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null; 
    }
}