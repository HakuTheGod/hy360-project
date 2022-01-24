/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClasses;

/**
 *
 * @author admin
 */
public class Company_Purchase {
    
    private String c_account_name;
    private String seller_name;
    private String product;
    private int employee_id;
    private int quantity;
    private double total_price;
    private String c_date;
    
    public void setAccountName(String c_account_name){
        this.c_account_name = c_account_name;
    }
    public void setSellerName(String seller_name){
        this.seller_name = seller_name;
    }
    public void setProduct(String product){
        this.product = product;
    }
    public void setEmployeeID(int employee_id){
        this.employee_id = employee_id;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setTotalPrice(double total_price){
        this.total_price = total_price;
    }
    public void setDate(String c_date){
        this.c_date = c_date;
    }
    
    public String getAccountName(){
        return this.c_account_name;
    }
    public String getSellerName(){
        return this.seller_name;
    }
    public String getProduct(){
        return this.product;
    }
    public int getEmployeeID(){
        return this.employee_id;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public double getTotalPrice(){
        return this.total_price;
    }
    public String getDate(){
        return this.c_date;
    }
}
