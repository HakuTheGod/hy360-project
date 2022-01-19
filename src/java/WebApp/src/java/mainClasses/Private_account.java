/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClasses;

import mainClasses.User;


/**
 *
 * @author admin
 */
public class Private_account extends User{
    private double Debt;
    private double Credit_line;
    private double Credit_balance;


    public double getCredit_balance(){
        return this.Credit_balance;
    }

    public double getCredit_line(){
        return this.Credit_line;    
    }

    public double getDebt(){
        return this.Debt;

    }

    public void setDebt(float debt){
        this.Debt = debt;
    }

    public void setCredit_Line(float credit_line){
        this.Credit_line=Credit_line;
    }
    public void setCredit_balance(float Credit_balance){
        this.Credit_balance = Credit_balance;
    }
}
