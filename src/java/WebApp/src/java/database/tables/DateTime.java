/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.tables;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;  

/**
 *
 * @author admin
 */
public class DateTime {
    
    public int getMonthNumber() throws ParseException{
        LocalDate now = LocalDate.now();
        String dl = now.toString();
        System.out.println(dl);
        int month = now.getMonthValue();
        System.out.println("MONTH VALUE: "+ month);
        return month;
    }
    
    public String monthToFullDateFirst(int month) throws ParseException{
        LocalDate now = LocalDate.now();
        String dl = now.toString();
        String ret;
        int year = now.getYear();
        if(month < 10){
           ret = String.valueOf(year) + "-0" + String.valueOf(month) + "-01";
            
        }
        else{
                ret = String.valueOf(year) + "-" + String.valueOf(month) + "-01";
            }
        
        return ret;
        
    }
    
    public String monthToFullDateLast(int month) throws ParseException{
        LocalDate now = LocalDate.now();
        String dl = now.toString();
        String ret;
        int year = now.getYear();
        if(month < 10){
           if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            ret = String.valueOf(year) + "-0" + String.valueOf(month) + "-31";
           }
           else{
               if(month == 2){
                    ret = String.valueOf(year) + "-0" + String.valueOf(month) + "-28";
               }
               else{
                   ret = String.valueOf(year) + "-0" + String.valueOf(month) + "-30";
               }
           }
        }
        else{
                if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            ret = String.valueOf(year) + "-" + String.valueOf(month) + "-31";
           }
           else{
               if(month == 2){
                    ret = String.valueOf(year) + "-" + String.valueOf(month) + "-28";
               }
               else{
                   ret = String.valueOf(year) + "-" + String.valueOf(month) + "-30";
               }
           }
            }
        
        return ret;
        
    }
    
}
