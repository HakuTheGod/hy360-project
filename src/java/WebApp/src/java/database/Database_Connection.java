/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.google.gson.JsonObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Database_Connection {
    
    private static final String url = "jdbc:mysql://localhost";
    private static final String databaseName = "hy360-project";
    private static final int port = 3306;
    private static final String username = "root";
    private static final String password = "";
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url + ":" + port + "/" + databaseName, username, password);
    }
    
    public static String getResultsToJSON(ResultSet rs) throws SQLException {
       ResultSetMetaData metadata = rs.getMetaData();
        int columns = metadata.getColumnCount();
        JsonObject ob = new JsonObject();
      
        for (int i = 1; i <= columns; i++) {
            String Cname = metadata.getColumnName(i);
            String rsVal = rs.getString(i);
            ob.addProperty(Cname,rsVal);
        }
        return ob.toString();
    }
    
}
