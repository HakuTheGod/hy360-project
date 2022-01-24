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
    private double amount_to_pay;

    /*public Company_account(int id, String name,float Credit_line){
        this.id = id;
        this.name =name;
        this.Credit_line=Credit_line; 
        this.Credit_balance = this.Credit_line;  
        this.debt=0; 
    }*/

    public float getCredit_balance(){
        return this.Credit_balance;
    }

    public float getCredit_line(){
        return this.Credit_line;    
    }

    public float getDebt(){
        return this.Debt;

    }
    
    public double getAmountToPay(){
        return this.amount_to_pay;
    }

    public void setDebt(float debt){
        this.Debt = debt;
    }
    
    public void setAmountToPay(double amount){
        this.amount_to_pay = amount;
    }

    public void setCredit_Line(float credit_line){
        this.Credit_line=Credit_line;
    }
    public void setCredit_balance(float Credit_balance){
        this.Credit_balance = Credit_balance;
    }
}
