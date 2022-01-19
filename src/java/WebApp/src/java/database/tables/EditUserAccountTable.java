
package database.tables;
import com.google.gson.Gson;
import database.Database_Connection;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainClasses.Private_account;
import mainClasses.Company_account;


public class EditUserAccountTable{

//ADD USER

//SQL ADD idiwth/COMPANY

private static final String INSERT_COMPANY_ACCOUNT = "INSERT INTO Company_account"
            +"(Company_id, Company_name, Credit_line, Debt, Credit_balance)"
            +"(?, ?, ?, ?, ?)";

public Private_account jsonToPrivateAccount(String json){
    
    Gson gson = new Gson();
    
    Private_account pa = gson.fromJson(json, Private_account.class);
    return pa;
    
}

public void addPrivateAccountFromJSON(String json){
    Private_account pa = jsonToPrivateAccount(json);
    insertPrivateAccount(pa);
}

public void insertPrivateAccount(Private_account pa){
    try {
        Connection con = Database_Connection.getConnection();
        Statement stmt = con.createStatement();
        String insertQuery = "INSERT INTO Private_account"
            +"(Private_id, Private_name, Credit_line, Debt, Credit_balance) VALUES"
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
        
        stmt.close();
        
    } catch (SQLException ex) {
        Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(EditUserAccountTable.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}

//NEW idiwths
    public void insert_private_account(Private_account pa) throws SQLException, ClassNotFoundException{
            Connection con = Database_Connection.getConnection();
            ResultSet rs;
            PreparedStatement prepared_stat;
            prepared_stat = con.prepareStatement("");
            prepared_stat.setInt(1,pa.getUserID());
            prepared_stat.setString(2,pa.getUserName());
            prepared_stat.setDouble(3,pa.getCredit_line());
            prepared_stat.setDouble(4,pa.getDebt());// 8a nai 0
            prepared_stat.setDouble(5,pa.getCredit_balance());
            System.out.println(prepared_stat);
            rs = prepared_stat.executeQuery();
            
            
            //Credit_balance == credit_line sthn arxh afou den exei 3ode4ei tpt akoma
    }

    //NEW COMPANY
    public void insert_company_account(Company_account Company_account){
        
    }
}