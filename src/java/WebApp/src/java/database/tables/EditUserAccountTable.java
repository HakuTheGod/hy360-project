
package database.tables;
import com.google.gson.Gson;
import database.Database_Connection;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainClasses.Private_account;


public class EditUserAccountTable{
    
    public Private_account jsonToPrivateAccount(String json){
    
        Gson gson = new Gson();
    
        Private_account pa = gson.fromJson(json, Private_account.class);
        return pa;
    
    }

    public void addPrivateAccountFromJSON(String json){
        Private_account pa = jsonToPrivateAccount(json);
        insertUser(pa);
        insertPrivateAccount(pa);
    }

    public void insertPrivateAccount(Private_account pa){
        try {
            Connection con = Database_Connection.getConnection();
            try (Statement stmt = con.createStatement()) {
                String insertQuery = "INSERT INTO Private_account"
                    +"(user_id, user_name, Credit_line, Debt, Credit_balance) VALUES"
                    +"("
                    + "'" + pa.getUserID() + "',"
                    + "'" + pa.getUserName() + "',"
                    + "'" + pa.getCredit_line() + "',"
                    + "'" + pa.getDebt() + "',"
                    + "'" + pa.getCredit_balance() + "'"
                    + ")";
            
                System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
                System.out.println("# The private account was successfully inserted in the database.");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertUser(Private_account pa){
        try {
            Connection con = Database_Connection.getConnection();
            try (Statement stmt = con.createStatement()) {
                String insertQuery = "INSERT INTO User"
                    +"(user_id, user_name) VALUES"
                    +"("
                    + "'" + pa.getUserID() + "',"
                    + "'" + pa.getUserName()
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

    public Private_account databaseToPrivateAccount(int id) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        try{
            rs = stmt.executeQuery("SELECT * FROM private_account WHERE user_id ='" + id + "'");
            rs.next();
            String json = Database_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Private_account pa = gson.fromJson(json, Private_account.class);
            return pa;
        }catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null; 
    }
    
    public Private_account databaseToPrivateAccountU(String username) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        System.out.println(username);
        String s = "'" + username + "'";
        try{
            rs = stmt.executeQuery("SELECT * FROM private_account WHERE user_name =" + s);
            rs.next();
            String json = Database_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Private_account pa = gson.fromJson(json, Private_account.class);
            System.out.println(pa.getUserName());
            return pa;
        }catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null; 
    }
    
    public void deleteFromDatabase(String username) throws SQLException, ClassNotFoundException{
        deleteUserAccountP(username);
        deletePrivateAccount(username);
    }
    
    public void deletePrivateAccount(String username) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        String deleteQuery = "DELETE FROM private_account WHERE user_name='" + username + "'";
        stmt.executeUpdate(deleteQuery);
    }
    
    public void deleteUserAccountP(String username) throws SQLException, ClassNotFoundException{
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        String deleteQuery = "DELETE FROM user WHERE user_name='" + username + "'";
        stmt.executeUpdate(deleteQuery);
    }
}