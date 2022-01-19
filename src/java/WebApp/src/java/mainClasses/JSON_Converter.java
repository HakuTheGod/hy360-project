/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClasses;

import java.io.BufferedReader;
import java.io.IOException;


/**
 *
 * @author admin
 */
public class JSON_Converter {
    public String getJsonFromAjax(BufferedReader reader) throws IOException{
        StringBuilder bf = new StringBuilder(); 
        String s;
        while((s = reader.readLine()) != null){
            bf.append(s);
        }
        String data = bf.toString();
        return data;
    }
}
