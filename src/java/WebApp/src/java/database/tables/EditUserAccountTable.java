
package database.tables;
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
    public void insert_private_account(Private_account private_account){
        /*try{
            (Connection con = getConnection ();
            PreparedStatement prepared_stat = con.PreparedStatement(INSERT_PRIVATE_ACCOUNT)
            prepared_stat.setInt(1,private_account.getID());
            prepared_stat.setString(2,private_account.getName());
            prepared_stat.setInt(3,private_account.getCredit_line());
            prepared_stat.setInt(4,private_account.getDebt());// 8a nai 0
            prepared_stat.setINT(5,private_account.getCredit_balance());
            System.out.println(prepared_stat);
            prepared_stat.executeUpdate();
            //Credit_balance == credit_line sthn arxh afou den exei 3ode4ei tpt akoma

        }catch(Exception e){
                e.printStackTrace();
        }*/
    }

    //NEW COMPANY
    public void insert_company_account(Company_account Company_account){
        
    }
}