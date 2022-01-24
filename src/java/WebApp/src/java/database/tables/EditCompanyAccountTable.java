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
import mainClasses.Company_account;
import mainClasses.Private_account;

/**
 *
 * @author admin
 */
public class EditCompanyAccountTable {
     public Company_account jsonToCompanyAccount(String json){
    
        Gson gson = new Gson();
    
        Company_account ca = gson.fromJson(json, Company_account.class);
        return ca;
    
    }

    public void addCompanyAccountFromJSON(String json){
        Company_account ca = jsonToCompanyAccount(json);
        insertUser(ca);
        insertCompanyAccount(ca);
    }

    public void insertCompanyAccount(Company_account ca){
        try {
            Connection con = Database_Connection.getConnection();
            try (Statement stmt = con.createStatement()) {
                String insertQuery = "INSERT INTO company_account"
                    +"(user_id, user_name, Credit_line, Debt, Credit_balance) VALUES"
                    +"("
                    + "'" + ca.getUserID() + "',"
                    + "'" + ca.getUserName() + "',"
                    + "'" + ca.getCredit_line() + "',"
                    + "'" + ca.getDebt() + "',"
                    + "'" + ca.getCredit_balance() + "'"
                    + ")";
            
                System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
                System.out.println("# The company account was successfully inserted in the database.");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertUser(Company_account ca){
        try {
            Connection con = Database_Connection.getConnection();
            try (Statement stmt = con.createStatement()) {
                String insertQuery = "INSERT INTO User"
                    +"(user_id, user_name) VALUES"
                    +"("
                    + "'" + ca.getUserID() + "',"
                    + "'" + ca.getUserName()
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

    public Company_account databaseToCompanyAccount(int id) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        try{
            rs = stmt.executeQuery("SELECT * FROM company_account WHERE user_id ='" + id + "'");
            rs.next();
            String json = Database_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Company_account ca = gson.fromJson(json, Company_account.class);
            return ca;
        }catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null; 
    }
    
     public Company_account databaseToCompanyAccountU(String username) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        try{
            rs = stmt.executeQuery("SELECT * FROM company_account WHERE user_name='" + username + "'");
            rs.next();
            String json = Database_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Company_account ca = gson.fromJson(json, Company_account.class);
            return ca;
        }catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null; 
    }
     
     public Company_account databaseToCompanyAccountD(double debt) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        try{
            rs = stmt.executeQuery("SELECT * FROM company_account WHERE Debt ='" + debt + "'");
            rs.next();
            String json = Database_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Company_account ca = gson.fromJson(json, Company_account.class);
            return ca;
        }catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null; 
    }
    
    public void deleteFromDatabase(String username) throws SQLException, ClassNotFoundException{
        deleteUserAccountC(username);
        deleteCompanyAccount(username);
    }
    
    public void deleteCompanyAccount(String username) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        String deleteQuery = "DELETE FROM company_account WHERE user_name='" + username + "'";
        stmt.executeUpdate(deleteQuery);
    }
    
    public void deleteUserAccountC(String username) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        String deleteQuery = "DELETE FROM user WHERE user_name='" + username + "'";
        stmt.executeUpdate(deleteQuery);
    }
    
    public void updateBalance(double credit_balance, double debt, int id){
        try {
            Connection con = Database_Connection.getConnection();
            try (Statement stmt = con.createStatement()) {
                String insertQuery = "UPDATE company_account SET Credit_balance='" + credit_balance + "', Debt='" + debt + "' WHERE user_id='" + id + "'";
            
                System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
                System.out.println("# The company account was successfully updated.");
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
                String insertQuery = "UPDATE company_account SET Debt='" + debt + "' WHERE user_id='" + id + "'";
            
                System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
                System.out.println("# The company account was successfully updated.");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
