/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClasses;

/**
 *
 * @author admin
 */
public class Squidward {
    private String user_name;
    private double total_sales;
    
    public void setTotalSales(double total_sales){
        this.total_sales = total_sales;
    }
    
    public void setUserName(String user_name){
        this.user_name = user_name;
    }
    
    public double getUserID(){
        return this.total_sales;
    }
    
    public String getUserName(){
        return this.user_name;
    }
}
