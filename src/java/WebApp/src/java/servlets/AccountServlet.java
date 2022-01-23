/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import database.tables.EditCompanyAccountTable;
import database.tables.EditSupplierTable;
import database.tables.EditUserAccountTable;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainClasses.Company_account;
import mainClasses.JSON_Converter;
import mainClasses.Private_account;
import mainClasses.Supplier_account;

/**
 *
 * @author admin
 */
@WebServlet(name = "AccountServlet", urlPatterns = {"/InsertPrivateAccount", "/DeletePrivateAccount", "/DeleteCompanyAccount" ,"/DeleteSupplierAccount", "/InsertCompanyAccount", "/InsertSupplierAccount"})
public class AccountServlet extends HttpServlet {
    
    
    
    private void insertPrivateAccount(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        JSON_Converter jc = new JSON_Converter();
        String s = jc.getJsonFromAjax(request.getReader());
        EditUserAccountTable euat = new EditUserAccountTable();
        
        Private_account pa,temp;
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try{
            euat.addPrivateAccountFromJSON(s);
            temp = euat.jsonToPrivateAccount(s);
            pa = euat.databaseToPrivateAccount(temp.getUserID());
            Gson gson = new Gson();
            JsonObject jo = new JsonObject();
            if(pa != null){
                jo.addProperty("Result", "Success!");
                response.setStatus(200);
                response.getWriter().write(jo.toString());
            }
            else{
                jo.addProperty("Result", "Failed!");
                response.setStatus(404);
                response.getWriter().write(jo.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    private void insertCompanyAccount(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        JSON_Converter jc = new JSON_Converter();
        String s = jc.getJsonFromAjax(request.getReader());
        EditCompanyAccountTable ecat = new EditCompanyAccountTable();
        
        Company_account ca,temp;
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try{
            ecat.addCompanyAccountFromJSON(s);
            temp = ecat.jsonToCompanyAccount(s);
            ca = ecat.databaseToCompanyAccount(temp.getUserID());
            Gson gson = new Gson();
            JsonObject jo = new JsonObject();
            if(ca != null){
                jo.addProperty("Result", "Success!");
                response.setStatus(200);
                response.getWriter().write(jo.toString());
            }
            else{
                jo.addProperty("Result", "Failed!");
                response.setStatus(404);
                response.getWriter().write(jo.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    private void insertSupplierAccount(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        JSON_Converter jc = new JSON_Converter();
        String s = jc.getJsonFromAjax(request.getReader());
        EditSupplierTable est = new EditSupplierTable();
        
        Supplier_account ca,temp;
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try{
            est.addSupplierAccountFromJSON(s);
            temp = est.jsonToSupplierAccount(s);
            ca = est.databaseToSupplierAccount(temp.getUserID());
            Gson gson = new Gson();
            JsonObject jo = new JsonObject();
            if(ca != null){
                jo.addProperty("Result", "Success!");
                response.setStatus(200);
                response.getWriter().write(jo.toString());
            }
            else{
                jo.addProperty("Result", "Failed!");
                response.setStatus(404);
                response.getWriter().write(jo.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void deletePrivateAccount(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        JSON_Converter jc = new JSON_Converter();
        String s = jc.getJsonFromAjax(request.getReader());
        Private_account a, p,temp;
        EditUserAccountTable euat = new EditUserAccountTable();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            System.out.println(s);
            a = euat.jsonToPrivateAccount(s);
            System.out.println(a.getUserName());
            p = euat.databaseToPrivateAccountU(a.getUserName());
             Gson gson = new Gson();
            JsonObject jo = new JsonObject();
            
            if(p != null){
                if(p.getDebt() == 0.0){
                    euat.deleteFromDatabase(p.getUserName());
                    temp = euat.databaseToPrivateAccountU(p.getUserName());
                    if(temp == null){
                        response.setStatus(200);
                        jo.addProperty("success", "SUCCESSS");
                        response.getWriter().write(jo.toString());
                    }
                    else{
                        response.setStatus(404);
                        jo.addProperty("fail", "FAIL");
                        response.getWriter().write(jo.toString());
                    }
                }
                else{
                    response.setStatus(403);
                    jo.addProperty("fail", "FAIL");
                    response.getWriter().write(jo.toString());
                }
            }
            else{
                response.setStatus(404);
                jo.addProperty("fail", "FAIL");
                response.getWriter().write(jo.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    
    }
    
    private void deleteCompanyAccount(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        JSON_Converter jc = new JSON_Converter();
        String s = jc.getJsonFromAjax(request.getReader());
        Company_account c,temp;
        EditCompanyAccountTable ecat = new EditCompanyAccountTable();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            c = ecat.databaseToCompanyAccountU(s);
            if(c != null){
                if(c.getDebt() == 0.0){
                    ecat.deleteFromDatabase(c.getUserName());
                    temp = ecat.databaseToCompanyAccountU(c.getUserName());
                    if(temp == null){
                        response.setStatus(200);
                    }
                    else{
                        response.setStatus(404);
                    }
                }
                else{
                    response.setStatus(403);
                }
            }
            else{
                response.setStatus(404);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void deleteSupplierAccount(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        JSON_Converter jc = new JSON_Converter();
        String s = jc.getJsonFromAjax(request.getReader());
        Supplier_account c,temp;
        EditSupplierTable est = new EditSupplierTable();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            c = est.databaseToSupplierAccountU(s);
            if(c != null){
                if(c.getDebt() == 0.0){
                    est.deleteFromDatabase(c.getUserName());
                    temp = est.databaseToSupplierAccountU(c.getUserName());
                    if(temp == null){
                        response.setStatus(200);
                    }
                    else{
                        response.setStatus(404);
                    }
                }
                else{
                    response.setStatus(403);
                }
            }
            else{
                response.setStatus(404);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AccountServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccountServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println("in doPost");
        System.out.println(action);
        switch(action){
            case "/InsertPrivateAccount":
                insertPrivateAccount(request, response);
                break;
            case "/InsertCompanyAccount":
                insertCompanyAccount(request, response);
                break;
            case "/InsertSupplierAccount":
                insertSupplierAccount(request, response);
                break;
            case "/DeletePrivateAccount":
                deletePrivateAccount(request, response);
                break;
            case "/DeleteCompanyAccount":
                deleteCompanyAccount(request, response);
                break;
            case "/DeleteSupplierAccount":
                deleteSupplierAccount(request, response);
                break;
            default:
                System.out.println("Something Went WRONG. IN DEFAULT.");
                break;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
