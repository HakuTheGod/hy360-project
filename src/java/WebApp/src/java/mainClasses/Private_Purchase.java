/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClasses;

/**
 *
 * @author admin
 */
public class Private_Purchase {
    private String p_account_name;
    private String seller_name;
    private String product;
    private int quantity;
    private double total_price;
    
    public void setAccountName(String p_account_name){
        this.p_account_name = p_account_name;
    }
    public void setSellerName(String seller_name){
        this.seller_name = seller_name;
    }
    public void setProduct(String product){
        this.product = product;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setTotalPrice(double total_price){
        this.total_price = total_price;
    }
    
    public String getAccountName(){
        return this.p_account_name;
    }
    public String getSellerName(){
        return this.seller_name;
    }
    public String getProduct(){
        return this.product;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public double getTotalPrice(){
        return this.total_price;
    }
}
