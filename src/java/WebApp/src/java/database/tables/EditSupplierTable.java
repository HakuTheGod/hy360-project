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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainClasses.Company_account;
import mainClasses.Private_account;
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
                    +"(user_id, user_name, Products, Profit, Percent_toCCC, Debt, Product_price) VALUES"
                    +"("
                    + "'" + sa.getUserID() + "',"
                    + "'" + sa.getUserName() + "',"
                    + "'" + sa.getProducts() + "',"
                    + "'" + sa.getProfit() + "',"
                    + "'" + sa.getPercent_toCCC()+ "',"
                    + "'" + sa.getDebt() + "',"
                    + "'" + sa.getProduct_price() + "'"
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
    
    public Supplier_account databaseToSupplierAccountU(String username) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        try{
            rs = stmt.executeQuery("SELECT * FROM supplier_account WHERE user_name ='" + username + "'");
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
    
    public Supplier_account databaseToSupplierAccountP(String name, String product) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        try{
            rs = stmt.executeQuery("SELECT * FROM supplier_account WHERE user_name ='" + name + "' AND products='" + product + "'");
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
    
    public Supplier_account databaseToSupplierAccountD(double debt) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        try{
            rs = stmt.executeQuery("SELECT * FROM supplier_account WHERE Debt ='" + debt + "'");
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
    
    public void deleteFromDatabase(String username) throws SQLException, ClassNotFoundException{
        deleteUserAccountS(username);
        deleteSupplierAccount(username);
    }
    
    public void deleteSupplierAccount(String username) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        String deleteQuery = "DELETE FROM supplier_account WHERE user_name='" + username + "'";
        stmt.executeUpdate(deleteQuery);
    }
    
    public void deleteUserAccountS(String username) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        String deleteQuery = "DELETE FROM user WHERE user_name='" + username + "'";
        stmt.executeUpdate(deleteQuery);
    }
    
    public void updateProfit(double profit, double debt, int id){
        try {
            Connection con = Database_Connection.getConnection();
            try (Statement stmt = con.createStatement()) {
                String insertQuery = "UPDATE supplier_account SET Profit='" + profit + "', Debt='" + debt + "' WHERE user_id='" + id + "'";
            
                System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
                System.out.println("# The supplier account was successfully updated.");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void payDebt(double debt, int id){
        try {
            Connection con = Database_Connection.getConnection();
            try (Statement stmt = con.createStatement()) {
                String insertQuery = "UPDATE supplier_account SET Debt='" + debt + "' WHERE user_id='" + id + "'";
            
                System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
                System.out.println("# The supplier account was successfully updated.");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Supplier_account> databaseToSupplierAll() throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ArrayList<Supplier_account> s = new ArrayList<Supplier_account>();
      
        ResultSet rs;
        
        
        try{
            rs = stmt.executeQuery("SELECT * FROM supplier_account");
            while(rs.next()){
                String json = Database_Connection.getResultsToJSON(rs);
                Gson gson = new Gson();
                Supplier_account rdz = gson.fromJson(json, Supplier_account.class);
                s.add(rdz);
            }
            String sap = new Gson().toJson(s);
            System.out.println("LIST: " + sap);
            
            return s;
        }
        catch(Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    public int updateDebt(double debt, String user_name){
        try {
            Connection con = Database_Connection.getConnection();
            try (Statement stmt = con.createStatement()) {
                String insertQuery = "UPDATE supplier_account SET Debt='" + debt + "' WHERE user_name='" + user_name + "'";
            
                System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
                System.out.println("# The supplier account was successfully updated.");
                return 1;
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
}
