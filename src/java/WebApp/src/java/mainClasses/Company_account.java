/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClasses;



/**
 *
 * @author admin
 */
public class Company_account extends User{
    private float Debt;
    private float Credit_line;
    private float Credit_balance;

    /*public Company_account(int id, String name,float Credit_line){
        this.id = id;
        this.name =name;
        this.Credit_line=Credit_line; 
        this.Credit_balance = this.Credit_line;  
        this.debt=0; 
    }*/

    float getCredit_balance(){
        return this.Credit_balance;
    }

    float getCredit_line(){
        return this.Credit_line;    
    }

    float getDebt(){
        return this.Debt;

    }

    void setDebt(float debt){
        this.Debt = debt;
    }

    void setCredit_Line(float credit_line){
        this.Credit_line=Credit_line;
    }
    void setCredit_balance(float Credit_balance){
        this.Credit_balance = Credit_balance;
    }
}
