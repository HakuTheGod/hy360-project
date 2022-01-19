
package database.tables;
import database.Database_Connection;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import mainClasses.Private_account;
import mainClasses.Company_account;


public class EditUserAccountTable{

//ADD USER

//SQL ADD idiwth/COMPANY
private static final String INSERT_PRIVATE_ACCOUNT = "INSERT INTO Private_account"
            +"(Private_id, Private_name, Credit_line, Debt, Credit_balance) VALUES"
            +"(?, ?, ?, ?, ?)";

private static final String INSERT_COMPANY_ACCOUNT = "INSERT INTO Company_account"
            +"(Company_id, Company_name, Credit_line, Debt, Credit_balance)"
            +"(?, ?, ?, ?, ?)";

//NEW idiwths
    public void insert_private_account(Private_account pa) throws SQLException, ClassNotFoundException{
            Connection con = Database_Connection.getConnection();
            ResultSet rs;
            PreparedStatement prepared_stat;
            prepared_stat = con.prepareStatement(INSERT_PRIVATE_ACCOUNT);
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