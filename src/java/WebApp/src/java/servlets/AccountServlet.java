/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import database.tables.EditCompanyAccountTable;
import database.tables.EditCompanyPurchaseTable;
import database.tables.EditPrivatePurchaseTable;
import database.tables.EditSupplierTable;
import database.tables.EditTransactionsTable;
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
import mainClasses.Company_Purchase;
import mainClasses.Company_account;
import mainClasses.JSON_Converter;
import mainClasses.Private_Purchase;
import mainClasses.Private_account;
import mainClasses.Supplier_account;
import mainClasses.Transaction;

/**
 *
 * @author admin
 */
@WebServlet(name = "AccountServlet", urlPatterns = {"/InsertPrivateAccount", "/DeletePrivateAccount", "/DeleteCompanyAccount" ,"/DeleteSupplierAccount", "/InsertCompanyAccount", "/InsertSupplierAccount", "/PurchasePrivate", "/PurchaseCompany", "/PayAccount", "/PayCompany", "/PaySupplier"})
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
        Company_account a,c,temp;
        EditCompanyAccountTable ecat = new EditCompanyAccountTable();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        JsonObject jo = new JsonObject();
        
        try {
            a = ecat.jsonToCompanyAccount(s);
            c = ecat.databaseToCompanyAccountU(a.getUserName());
            if(c != null){
                if(c.getDebt() == 0.0){
                    ecat.deleteFromDatabase(c.getUserName());
                    temp = ecat.databaseToCompanyAccountU(c.getUserName());
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
    
    private void deleteSupplierAccount(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        JSON_Converter jc = new JSON_Converter();
        String s = jc.getJsonFromAjax(request.getReader());
        Supplier_account a,c,temp;
        EditSupplierTable est = new EditSupplierTable();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        JsonObject jo = new JsonObject();
        
        try {
            a = est.jsonToSupplierAccount(s);
            c = est.databaseToSupplierAccountU(a.getUserName());
            if(c != null){
                if(c.getDebt() == 0.0){
                    est.deleteFromDatabase(c.getUserName());
                    temp = est.databaseToSupplierAccountU(c.getUserName());
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
    
    private void purchasePrivate(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        JSON_Converter jc = new JSON_Converter();
        String s = jc.getJsonFromAjax(request.getReader());
        double f_balance;
        Transaction t = new Transaction();
        Transaction tp, l;
        Private_Purchase pa, k, tmp;
        Private_account p;
        Private_account temp = new Private_account();
        Supplier_account sup;
        EditPrivatePurchaseTable eppt = new EditPrivatePurchaseTable();
        EditTransactionsTable ett = new EditTransactionsTable();
        EditSupplierTable est= new EditSupplierTable();
        EditUserAccountTable euat = new EditUserAccountTable();
        pa = eppt.jsonToPrivatePurchase(s);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        JsonObject jo = new JsonObject();
        try {
            System.out.println("EMPOROS: " + pa.getSellerName() + " PRODUCT: " + pa.getProduct());
            sup = est.databaseToSupplierAccountP(pa.getSellerName(), pa.getProduct());
            System.out.println("PRIN NA VROUME SUPPLIER");
            if(sup != null){
                temp.setUserName(pa.getAccountName());
                p = euat.databaseToPrivateAccountU(temp.getUserName());
                System.out.println("PRIN NA VROUME TON XRISTH");
                if(p != null){
                    f_balance = sup.getProduct_price() * pa.getQuantity();
                    if(p.getCredit_balance() < f_balance){
                        response.setStatus(403);
                        jo.addProperty("fail", "Not enough founds");
                        response.getWriter().write(jo.toString());
                    }
                    else{
                        pa.setTotalPrice(sup.getProduct_price());
                        tp = ett.databaseToTransactionID();
                        if(tp == null){
                            t.setID(1);
                        }
                        else{
                            t.setID(tp.getID() + 1);
                        }
                        t.setCustomer(pa.getAccountName());
                        t.setSeller(pa.getSellerName());
                        t.setAmount(f_balance);
                        t.setType("charge");
                        tmp = eppt.databaseToPrivatePurchaseP(pa.getAccountName(), pa.getProduct(), pa.getSellerName());
                        if(tmp != null){
                            int q = tmp.getQuantity() + pa.getQuantity();
                            eppt.updateQuantity(q, pa.getAccountName(), pa.getSellerName(), pa.getProduct());
                        }
                        else{
                            eppt.insertPrivatePurchase(pa);
                        }
                        ett.insertTransaction(t);
                        
                        double bal = p.getCredit_balance() - f_balance;
                        double dbt = p.getDebt() + f_balance;
                        
                        euat.updateBalance(bal, dbt, p.getUserID());
                        
                        double prof = sup.getProfit() + f_balance;
                        double dp = sup.getDebt() + (f_balance*sup.getPercent_toCCC());
                        est.updateProfit(prof, dp, sup.getUserID());
                        
                        
                        k = eppt.databaseToPrivatePurchaseP(pa.getAccountName(), pa.getProduct(), pa.getSellerName());
                        System.out.println("PRIN NA KATAXWRISOUME PP");
                        if(k != null){
                            l = ett.databaseToTransactionP(t.getID());
                            System.out.println("PRIN NA KANOUME TRANSACTION");
                            if(l != null){
                                response.setStatus(200);
                                jo.addProperty("success", "Purchase Completed Successfully!");
                                response.getWriter().write(jo.toString());
                            }
                            else{
                                System.out.println("TRANSACTION ERROR");
                                response.setStatus(404);
                                jo.addProperty("fail", "Could not find the transaction in the database.");
                                response.getWriter().write(jo.toString());
                            }
                        }
                        else{
                            System.out.println("PP ERROR");
                            response.setStatus(404);
                            jo.addProperty("fail", "Could not find the purchase in the database.");
                            response.getWriter().write(jo.toString());
                        }
                    }
                }
                else{
                    System.out.println("USER ERROR");
                    response.setStatus(404);
                    jo.addProperty("fail", "Username is incorrect");
                    response.getWriter().write(jo.toString());
                }
            }
            else{
                System.out.println("SUPPLIER ERROR");
                response.setStatus(404);
                jo.addProperty("fail", "Seller name is incorect");
                response.getWriter().write(jo.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void purchaseCompany(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
         JSON_Converter jc = new JSON_Converter();
        String s = jc.getJsonFromAjax(request.getReader());
        double f_balance;
        Transaction t = new Transaction();
        Transaction tp, l;
        Company_Purchase ca, k, tmp;
        Company_account c;
        Private_account temp = new Private_account();
        Supplier_account sup;
        EditCompanyPurchaseTable ecpt = new EditCompanyPurchaseTable();
        EditTransactionsTable ett = new EditTransactionsTable();
        EditSupplierTable est= new EditSupplierTable();
        EditCompanyAccountTable ecat = new EditCompanyAccountTable();
        ca = ecpt.jsonToCompanyPurchase(s);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        JsonObject jo = new JsonObject();
        try {
            System.out.println("EMPOROS: " + ca.getSellerName() + " PRODUCT: " + ca.getProduct());
            sup = est.databaseToSupplierAccountP(ca.getSellerName(), ca.getProduct());
            System.out.println("PRIN NA VROUME SUPPLIER");
            if(sup != null){
                temp.setUserName(ca.getAccountName());
                c = ecat.databaseToCompanyAccountU(temp.getUserName());
                System.out.println("PRIN NA VROUME TON XRISTH");
                if(c != null){
                    f_balance = sup.getProduct_price() * ca.getQuantity();
                    System.out.println("TOTAL PRICE: " + f_balance);
                    if(c.getCredit_balance() < f_balance){
                        response.setStatus(403);
                        jo.addProperty("fail", "Not enough founds");
                        response.getWriter().write(jo.toString());
                    }
                    else{
                        ca.setTotalPrice(sup.getProduct_price());
                        tp = ett.databaseToTransactionID();
                        if(tp == null){
                            t.setID(1);
                        }
                        else{
                            t.setID(tp.getID() + 1);
                        }
                        t.setCustomer(ca.getAccountName());
                        t.setSeller(ca.getSellerName());
                        t.setAmount(f_balance);
                        t.setType("charge");
                        tmp = ecpt.databaseToPrivatePurchaseP(ca.getAccountName(), ca.getProduct(), ca.getSellerName());
                        if(tmp != null){
                            int q = tmp.getQuantity() + ca.getQuantity();
                            ecpt.updateQuantity(q, ca.getAccountName(), ca.getSellerName(), ca.getProduct());
                        }
                        else{
                            ecpt.insertCompanyPurchase(ca);
                        }
                        ett.insertTransaction(t);
                        
                        double bal = c.getCredit_balance() - f_balance;
                        double dbt = c.getDebt() + f_balance;
                        
                        ecat.updateBalance(bal, dbt, c.getUserID());
                        
                        double prof = sup.getProfit() + f_balance;
                        double dp = sup.getDebt() + (f_balance*sup.getPercent_toCCC());
                        est.updateProfit(prof, dp, sup.getUserID());
                        
                        k = ecpt.databaseToPrivatePurchaseP(ca.getAccountName(), ca.getProduct(), ca.getSellerName());
                        System.out.println("PRIN NA KATAXWRISOUME PP");
                        if(k != null){
                            l = ett.databaseToTransactionP(t.getID());
                            System.out.println("PRIN NA KANOUME TRANSACTION");
                            if(l != null){
                                response.setStatus(200);
                                jo.addProperty("success", "Purchase Completed Successfully!");
                                response.getWriter().write(jo.toString());
                            }
                            else{
                                System.out.println("TRANSACTION ERROR");
                                response.setStatus(404);
                                jo.addProperty("fail", "Could not find the transaction in the database.");
                                response.getWriter().write(jo.toString());
                            }
                        }
                        else{
                            System.out.println("PP ERROR");
                            response.setStatus(404);
                            jo.addProperty("fail", "Could not find the purchase in the database.");
                            response.getWriter().write(jo.toString());
                        }
                    }
                }
                else{
                    System.out.println("USER ERROR");
                    response.setStatus(404);
                    jo.addProperty("fail", "Username is incorrect");
                    response.getWriter().write(jo.toString());
                }
            }
            else{
                System.out.println("SUPPLIER ERROR");
                response.setStatus(404);
                jo.addProperty("fail", "Seller name is incorect");
                response.getWriter().write(jo.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    private void payAccount(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        JSON_Converter jc = new JSON_Converter();
        String s = jc.getJsonFromAjax(request.getReader());
        EditUserAccountTable euat = new EditUserAccountTable();
        double f_debt;
        double f_balance;
        Private_account pa,temp;
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try{
            temp = euat.jsonToPrivateAccount(s);
            pa = euat.databaseToPrivateAccountU(temp.getUserName());
            f_debt = pa.getDebt() - temp.getAmountToPay();
            if(f_debt < 0.0){
                f_debt = 0.0;
            }
            euat.payDebt(f_debt, pa.getUserID());
            pa = euat.databaseToPrivateAccountU(temp.getUserName());
            f_balance = pa.getCredit_line() - pa.getDebt();
            euat.updateBalance(f_balance, pa.getDebt(), pa.getUserID());
            temp = euat.databaseToPrivateAccountD(f_debt);
            Gson gson = new Gson();
            JsonObject jo = new JsonObject();
            if(temp != null){
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
    
    
    private void payCompany(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        JSON_Converter jc = new JSON_Converter();
        String s = jc.getJsonFromAjax(request.getReader());
        EditCompanyAccountTable ecat = new EditCompanyAccountTable();
        double f_debt;
        double f_balance;
        Company_account ca,temp;
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try{
            temp = ecat.jsonToCompanyAccount(s);
            ca = ecat.databaseToCompanyAccountU(temp.getUserName());
            f_debt = ca.getDebt() - temp.getAmountToPay();
            if(f_debt < 0.0){
                f_debt = 0.0;
            }
            ecat.payDebt(f_debt, ca.getUserID());
            ca = ecat.databaseToCompanyAccountU(temp.getUserName());
            f_balance = ca.getCredit_line() - ca.getDebt();
            ecat.updateBalance(f_balance, ca.getDebt(), ca.getUserID());
            temp = ecat.databaseToCompanyAccountD(f_debt);
            Gson gson = new Gson();
            JsonObject jo = new JsonObject();
            if(temp != null){
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
    
    private void paySupplier(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        JSON_Converter jc = new JSON_Converter();
        String s = jc.getJsonFromAjax(request.getReader());
        EditSupplierTable esat = new EditSupplierTable();
        double f_debt;
        double f_balance;
        double f_pay;
        double f_profit;
        Supplier_account sa,temp;
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try{
            temp = esat.jsonToSupplierAccount(s);
            sa = esat.databaseToSupplierAccountU(temp.getUserName());
            if(temp.getAmountToPay() > sa.getProfit()){
                temp.setAmountToPay(sa.getProfit());
            }
            if(temp.getAmountToPay() > sa.getDebt()){
                f_pay = sa.getDebt();
            }
            else{
                f_pay = temp.getAmountToPay();
            }
            
            f_profit = sa.getProfit() - f_pay;
            f_debt = sa.getDebt() - f_pay;
            
            esat.payDebt(f_debt, sa.getUserID());
            sa = esat.databaseToSupplierAccountU(temp.getUserName());
            esat.updateProfit(f_profit, sa.getDebt(), sa.getUserID());
            temp = esat.databaseToSupplierAccountD(f_debt);
            Gson gson = new Gson();
            JsonObject jo = new JsonObject();
            if(temp != null){
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
            case "/PurchasePrivate":
                purchasePrivate(request, response);
                break;
            case "/PurchaseCompany":
                purchaseCompany(request, response);
                break;
            case "/PayAccount":
                payAccount(request, response);
                break;
            case "/PayCompany":
                payCompany(request, response);
                break;
            case "/PaySupplier":
                paySupplier(request, response);
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
