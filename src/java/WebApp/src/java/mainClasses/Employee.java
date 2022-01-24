/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClasses;

/**
 *
 * @author admin
 */
public class Employee {
    private int employee_id;
    private String employee_name;
    private int company_id;
    private String company_name;
    
    public void setEmployeeID(int id){
        this.employee_id = id;
    }
    public void setEmployeeName(String name){
        this.employee_name = name;
    }
    public void setCompanyID(int id){
        this.company_id = id;
    }
    public void setCompanyName(String name){
        this.company_name = name;
    }
    
    public int getEmployeeID(){
        return this.employee_id;
    }
    public String getEmployeeName(){
        return this.employee_name;
    }
    public int getCompanyID(){
        return this.company_id;
    }
    public String getCompanyName(){
        return this.company_name;
    }
}
