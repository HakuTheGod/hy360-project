/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.tables;

import com.google.gson.Gson;
import database.Database_Connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainClasses.Company_Purchase;
import mainClasses.Date;
/**
 *
 * @author admin
 */
public class NewDate {
    
     public Date jsonToDate(String json){
    
        Gson gson = new Gson();
    
        Date ca = gson.fromJson(json, Date.class);
        return ca;
    
    }
    
    
}
