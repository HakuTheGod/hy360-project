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
import java.util.ArrayList;
import java.util.Collections;
import mainClasses.Private_account;
import mainClasses.Transaction;

/**
 *
 * @author admin
 */
public class EditTransactionsTable {
    public void insertTransaction(Transaction t){
        try {
            Connection con = Database_Connection.getConnection();
            try (Statement stmt = con.createStatement()) {
                String insertQuery = "INSERT INTO transactions"
                    +"(t_date, seller_name, customer_name, t_id, amount, t_type) VALUES"
                    +"("
                    + "CURRENT_TIMESTAMP,"
                    + "'" + t.getSeller()+ "',"
                    + "'" + t.getCustomer()+ "',"
                    + "'" + t.getID()+ "',"
                    + "'" + t.getAmount()+ "',"
                    + "'" + t.getType() + "'"
                    + ")";
            
                System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
                System.out.println("# The Transaction was successfully inserted in the database.");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Transaction databaseToTransaction(String date, String customer) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        
        String bf = date + " 00:00:00";
        String af = date + " 23:59:59";
        
        try{
            rs = stmt.executeQuery("SELECT * FROM transactions WHERE customer_name ='" + customer + "' AND t_date BETWEEN '" + bf + "' AND '" + af + "'");
            rs.next();
            String json = Database_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Transaction t = gson.fromJson(json, Transaction.class);
            return t;
        }catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null; 
    }
    
    public Transaction databaseToTransactionP(int id) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        
        try{
            rs = stmt.executeQuery("SELECT * FROM transactions WHERE t_id='" + id + "'");
            rs.next();
            String json = Database_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Transaction t = gson.fromJson(json, Transaction.class);
            return t;
        }catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null; 
    }
    
    public Transaction databaseToTransactionID() throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        ArrayList<Transaction> t = new ArrayList<Transaction>();
        
        try{
            rs = stmt.executeQuery("SELECT * FROM transactions");
            while(rs.next()){
                String json = Database_Connection.getResultsToJSON(rs);
                Gson gson = new Gson();
                Transaction rdz = gson.fromJson(json, Transaction.class);
                t.add(rdz);
            }
            Transaction last = t.get(t.size() - 1);
            return last;
        }catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null; 
    }
    
    public ArrayList<Transaction> databaseToTransactionDate(String date1, String date2) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ArrayList<Transaction> t = new ArrayList<Transaction>();
      
        ResultSet rs;
        int j = 0;
        int o = 0;
        String bf = date1 + " 00:00:00";
        String af = date2 + " 23:59:59";
        
        System.out.println(bf + " --- " + af);
        
        
        try{
            rs = stmt.executeQuery("SELECT * FROM transactions WHERE t_date BETWEEN '" + bf + "' AND '" + af + "'");
            while(rs.next()){
                String json = Database_Connection.getResultsToJSON(rs);
                Gson gson = new Gson();
                Transaction rdz = gson.fromJson(json, Transaction.class);
                t.add(rdz);
            }
            
            return t;
        }
        catch(Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    
}
