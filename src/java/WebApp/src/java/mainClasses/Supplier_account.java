/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClasses;


/**
 *
 * @author admin
 */
public class Supplier_account extends User{
    private double Percent_toCCC;
    private double Profit;
    private double Debt;
    private String Products;

   public void setProducts(String product){
       this.Products = product;
   }
   
   public void setProfit(double Profit){
       this.Profit = Profit;
   }
   
   public void setDebt(double Debt){
       this.Debt = Debt;
   }
   public void setPercent_toCCC(double percent_toCCC){
       this.Percent_toCCC = percent_toCCC;
   }
   
   
   public String getProducts(){
       return this.Products;
   }
   
   public double getProfit(){
       return this.Profit;
   }
   
   public double getDebt(){
       return this.Debt;
   }
   
   public double getPercent_toCCC(){
       return this.Percent_toCCC;
   }
}
