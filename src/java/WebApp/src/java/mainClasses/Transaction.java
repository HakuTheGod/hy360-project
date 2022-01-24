/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClasses;

/**
 *
 * @author admin
 */
public class Transaction {
    private String t_date;
    private String seller_name;
    private String customer_name;
    private int t_id;
    private double amount;
    private String t_type;
    
    public void setDate(String date){
        this.t_date = date;
    }
    public void setSeller(String seller){
        this.seller_name = seller;
    }
    public void setCustomer(String customer){
        this.customer_name = customer;
    }
    public void setID(int id){
        this.t_id = id;
    }
    public void setAmount(double quantity){
        this.amount = quantity;
    }
    public void setType(String type){
        this.t_type = type;
    }
    
    public String getDate(){
        return this.t_date;
    }
    public String getSeller(){
        return this.seller_name;
    }
    public String getCustomer(){
        return this.customer_name;
    }
    public int getID(){
        return this.t_id;
    }
    public double getAmount(){
        return this.amount;
    }
    public String getType(){
        return this.t_type;
    }
}
