/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import database.tables.DateTime;
import database.tables.EditCompanyAccountTable;
import database.tables.EditCompanyPurchaseTable;
import database.tables.EditPrivatePurchaseTable;
import database.tables.EditSupplierTable;
import database.tables.EditTransactionsTable;
import database.tables.EditUserAccountTable;
import database.tables.NewDate;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainClasses.Company_Purchase;
import mainClasses.Company_account;
import mainClasses.Date;
import mainClasses.GoodBoys;
import mainClasses.JSON_Converter;
import mainClasses.Private_Purchase;
import mainClasses.Private_account;
import mainClasses.Squidward;
import mainClasses.Supplier_account;
import mainClasses.Transaction;

/**
 *
 * @author admin
 */
@WebServlet(name = "AccountServlet", urlPatterns = {"/InsertPrivateAccount", "/DeletePrivateAccount", "/DeleteCompanyAccount" ,"/DeleteSupplierAccount", "/InsertCompanyAccount", "/InsertSupplierAccount", "/PurchasePrivate", "/PurchaseCompany", "/PayAccount", "/PayCompany", "/PaySupplier", "/ReturnPrivate", "/ReturnCompany", "/DateQuestion", "/GoodBoys", "/BadBoys", "/SpongeBob"})
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

    private void returnPrivate(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        JSON_Converter jc = new JSON_Converter();
        String s = jc.getJsonFromAjax(request.getReader());
        int f_quantity;
        double f_balance;
        double f_pay;
        double f_debt;
        double f_debt_S;
        Supplier_account sa, tp;
        Private_Purchase p,tmp, a;
        Private_account pa, temp;
        EditUserAccountTable euat = new EditUserAccountTable();
        EditPrivatePurchaseTable eppt = new EditPrivatePurchaseTable();
        EditSupplierTable est = new EditSupplierTable();
        Gson gson = new Gson();
        JsonObject jo = new JsonObject();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        tmp = eppt.jsonToPrivatePurchase(s);
        try {
            p = eppt.databaseToPrivatePurchaseP(tmp.getAccountName(), tmp.getProduct(), tmp.getSellerName());
            if(p != null){
                if(p.getQuantity() > 0){
                    f_quantity = p.getQuantity() - tmp.getQuantity();
                    eppt.updateQuantity(f_quantity, p.getAccountName(), p.getSellerName(), p.getProduct());
                    f_pay = p.getTotalPrice() * tmp.getQuantity();
                    pa = euat.databaseToPrivateAccountU(p.getAccountName());
                    if(pa != null){
                        f_balance = pa.getCredit_balance() + f_pay;
                        f_debt = pa.getDebt() - f_pay;
                        if(f_debt < 0){
                            f_debt = 0.0;
                        }
                        sa = est.databaseToSupplierAccountU(p.getSellerName());
                        if(sa != null){
                            f_debt_S = sa.getDebt() + f_pay;
                        
                            euat.updateBalance(f_balance, f_debt, pa.getUserID());
                            
                            est.updateProfit(sa.getProfit(), f_debt_S, sa.getUserID());
                        
                            a = eppt.databaseToPrivatePurchase(p.getAccountName());
                            if(a.getQuantity() == f_quantity){
                                temp = euat.databaseToPrivateAccountU(pa.getUserName());
                                if(temp.getCredit_balance() == f_balance){
                                    tp = est.databaseToSupplierAccountD(f_debt_S);
                                    if(tp != null){
                                        jo.addProperty("Result", "success!");
                                        response.setStatus(200);
                                        response.getWriter().write(jo.toString());
                                    }
                                    else{
                                        jo.addProperty("Result", "Failed!");
                                        response.setStatus(404);
                                        response.getWriter().write(jo.toString());
                                    }
                                }
                                else{
                                    jo.addProperty("Result", "Failed!");
                                    response.setStatus(404);
                                    response.getWriter().write(jo.toString());
                                } 
                            }
                        }
                        else{
                            jo.addProperty("Result", "Failed!");
                            response.setStatus(404);
                            response.getWriter().write(jo.toString());
                        }
                    }
                    else{
                        jo.addProperty("Result", "Failed!");
                        response.setStatus(404);
                        response.getWriter().write(jo.toString());
                    }
                }
                else{
                    jo.addProperty("Result", "Failed!");
                    response.setStatus(403);
                    response.getWriter().write(jo.toString());
                }
                
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
    
    private void returnCompany(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        JSON_Converter jc = new JSON_Converter();
        String s = jc.getJsonFromAjax(request.getReader());
        int f_quantity;
        double f_balance;
        double f_pay;
        double f_debt;
        double f_debt_S;
        Supplier_account sa, tp;
        Company_Purchase p,tmp, a;
        Company_account pa, temp;
        EditCompanyAccountTable ecat = new EditCompanyAccountTable();
        EditCompanyPurchaseTable ecpt = new EditCompanyPurchaseTable();
        EditSupplierTable est = new EditSupplierTable();
        Gson gson = new Gson();
        JsonObject jo = new JsonObject();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        tmp = ecpt.jsonToCompanyPurchase(s);
        try {
            p = ecpt.databaseToPrivatePurchaseP(tmp.getAccountName(), tmp.getProduct(), tmp.getSellerName());
            if(p != null){
                if(p.getQuantity() > 0){
                    f_quantity = p.getQuantity() - tmp.getQuantity();
                    ecpt.updateQuantity(f_quantity, p.getAccountName(), p.getSellerName(), p.getProduct());
                    f_pay = p.getTotalPrice() * tmp.getQuantity();
                    pa = ecat.databaseToCompanyAccountU(p.getAccountName());
                    if(pa != null){
                        f_balance = pa.getCredit_balance() + f_pay;
                        f_debt = pa.getDebt() - f_pay;
                        if(f_debt < 0){
                            f_debt = 0.0;
                        }
                        sa = est.databaseToSupplierAccountU(p.getSellerName());
                        if(sa != null){
                            f_debt_S = sa.getDebt() + f_pay;
                        
                            ecat.updateBalance(f_balance, f_debt, pa.getUserID());
                            
                            est.updateProfit(sa.getProfit(), f_debt_S, sa.getUserID());
                        
                            a = ecpt.databaseToPrivatePurchase(p.getAccountName());
                            if(a.getQuantity() == f_quantity){
                                temp = ecat.databaseToCompanyAccountU(pa.getUserName());
                                if(temp.getCredit_balance() == f_balance){
                                    tp = est.databaseToSupplierAccountD(f_debt_S);
                                    if(tp != null){
                                        jo.addProperty("Result", "success!");
                                        response.setStatus(200);
                                        response.getWriter().write(jo.toString());
                                    }
                                    else{
                                        jo.addProperty("Result", "Failed!");
                                        response.setStatus(404);
                                        response.getWriter().write(jo.toString());
                                    }
                                }
                                else{
                                    jo.addProperty("Result", "Failed!");
                                    response.setStatus(404);
                                    response.getWriter().write(jo.toString());
                                } 
                            }
                        }
                        else{
                            jo.addProperty("Result", "Failed!");
                            response.setStatus(404);
                            response.getWriter().write(jo.toString());
                        }
                    }
                    else{
                        jo.addProperty("Result", "Failed!");
                        response.setStatus(404);
                        response.getWriter().write(jo.toString());
                    }
                }
                else{
                    jo.addProperty("Result", "Failed!");
                    response.setStatus(403);
                    response.getWriter().write(jo.toString());
                }
                
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
    
    private void dateQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        JSON_Converter jc = new JSON_Converter();
        String s = jc.getJsonFromAjax(request.getReader());
        NewDate date = new NewDate();
        Date d;
        ArrayList<Transaction> t = new ArrayList<Transaction>();
        EditTransactionsTable ett = new EditTransactionsTable();
        System.out.println(s);
        d = date.jsonToDate(s);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try(PrintWriter out = response.getWriter()){
            t = ett.databaseToTransactionDate(d.getDate1(), d.getDate2());
            Gson gson = new Gson();
            JsonObject jo = new JsonObject();
            if(t != null){
                String json = new Gson().toJson(t);
                System.out.println("JSON = " + json);
                response.setStatus(200);
                out.println(json);
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
    
     private void goodBoys(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int i;
        ArrayList<GoodBoys> g = new ArrayList<GoodBoys>();
        ArrayList<Private_account> p = new ArrayList<Private_account>();
        ArrayList<Company_account> c = new ArrayList<Company_account>();
        ArrayList<Supplier_account> s = new ArrayList<Supplier_account>();
        EditUserAccountTable euat = new EditUserAccountTable();
        EditCompanyAccountTable ecat = new EditCompanyAccountTable();
        EditSupplierTable est = new EditSupplierTable();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try(PrintWriter out = response.getWriter()){
            p = euat.databaseToPrivateAll();
            Gson gson = new Gson();
            JsonObject jo = new JsonObject();
            if(p != null){
                for(i = 0; i < p.size(); i++){
                    if(p.get(i).getDebt() == 0.0){
                        GoodBoys gb = new GoodBoys();
                        gb.setUserID(p.get(i).getUserID());
                        gb.setUserName(p.get(i).getUserName());
                        g.add(gb);
                    }
                }
                c = ecat.databaseToCompanyAll();
                if(c != null){
                    
                   for(i = 0; i < c.size(); i++){
                       if(c.get(i).getDebt() == 0.0){
                            GoodBoys gb = new GoodBoys();
                            gb.setUserID(c.get(i).getUserID());
                            gb.setUserName(c.get(i).getUserName());
                            g.add(gb);
                       }
                    } 
                   s = est.databaseToSupplierAll();
                   if(s != null){
                       for(i = 0; i < s.size(); i++){
                           System.out.println(s.get(i).getUserName() + ", " + s.get(i).getDebt());
                        if(s.get(i).getDebt() == 0.0){
                            GoodBoys gb = new GoodBoys();
                            gb.setUserID(s.get(i).getUserID());
                            gb.setUserName(s.get(i).getUserName());
                            g.add(gb);
                        }
                    } 
                       
                       Collections.sort(g, new Comparator<GoodBoys>() {
                            @Override
                            public int compare(GoodBoys item, GoodBoys t1) {
                                String s1 = item.getUserName();
                                String s2 = t1.getUserName();
                                return s1.compareToIgnoreCase(s2);
                            }

                        });
                       
                        String json = new Gson().toJson(g);
                        System.out.println("JSON = " + json);
                        response.setStatus(200);
                        out.println(json);
                       
                   }
                   else{
                       response.setStatus(404);
                   }
                }
                else{
                    response.setStatus(404);
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
     
     private void badBoys(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int i;
        ArrayList<GoodBoys> g = new ArrayList<GoodBoys>();
        ArrayList<Private_account> p = new ArrayList<Private_account>();
        ArrayList<Company_account> c = new ArrayList<Company_account>();
        ArrayList<Supplier_account> s = new ArrayList<Supplier_account>();
        EditUserAccountTable euat = new EditUserAccountTable();
        EditCompanyAccountTable ecat = new EditCompanyAccountTable();
        EditSupplierTable est = new EditSupplierTable();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try(PrintWriter out = response.getWriter()){
            p = euat.databaseToPrivateAll();
            Gson gson = new Gson();
            JsonObject jo = new JsonObject();
            if(p != null){
                for(i = 0; i < p.size(); i++){
                    if(p.get(i).getDebt() > 0.0){
                        GoodBoys gb = new GoodBoys();
                        gb.setUserID(p.get(i).getUserID());
                        gb.setUserName(p.get(i).getUserName());
                        g.add(gb);
                    }
                }
                c = ecat.databaseToCompanyAll();
                if(c != null){
                    
                   for(i = 0; i < c.size(); i++){
                       if(c.get(i).getDebt() > 0.0){
                            GoodBoys gb = new GoodBoys();
                            gb.setUserID(c.get(i).getUserID());
                            gb.setUserName(c.get(i).getUserName());
                            g.add(gb);
                       }
                    } 
                   s = est.databaseToSupplierAll();
                   if(s != null){
                       for(i = 0; i < s.size(); i++){
                           System.out.println(s.get(i).getUserName() + ", " + s.get(i).getDebt());
                        if(s.get(i).getDebt() > 0.0){
                            GoodBoys gb = new GoodBoys();
                            gb.setUserID(s.get(i).getUserID());
                            gb.setUserName(s.get(i).getUserName());
                            g.add(gb);
                        }
                    } 
                       
                       Collections.sort(g, new Comparator<GoodBoys>() {
                            @Override
                            public int compare(GoodBoys item, GoodBoys t1) {
                                String s1 = item.getUserName();
                                String s2 = t1.getUserName();
                                return s1.compareToIgnoreCase(s2);
                            }

                        });
                       
                        String json = new Gson().toJson(g);
                        System.out.println("JSON = " + json);
                        response.setStatus(200);
                        out.println(json);
                       
                   }
                   else{
                       response.setStatus(404);
                   }
                }
                else{
                    response.setStatus(404);
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
     
     private void spongeBob(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
         int month;
         double f_debt;
         double total_sale = 0.0;
         int i = 0;
         double compare_sale = 0.0;
         String name, totalName;
         DateTime date = new DateTime();
         Squidward squidward = new Squidward();
         ArrayList<Transaction> t = new ArrayList<Transaction>();
         ArrayList<Squidward> squid = new ArrayList<Squidward>();
         Supplier_account s;
         EditSupplierTable est = new EditSupplierTable();
         EditTransactionsTable ett = new EditTransactionsTable();
         
         
        try(PrintWriter out = response.getWriter()){
            month = date.getMonthNumber();
            if(month == 1){
                month = 12;
            }
            else{
                month = month - 1;
            }
            String d = date.monthToFullDateFirst(month);
            String l = date.monthToFullDateLast(month);
            
            System.out.println("START OF LAST MONTH: " + d);
            System.out.println("END OF LAST MONTH: " + l);
            
            t = ett.databaseToTransactionMonth(d, l);
            if(t != null){
                name = t.get(0).getSeller();
                totalName = name;
                while(t.get(i).getSeller().equals(name)){
                    total_sale = total_sale + t.get(i).getAmount();
                    i++;
                }
                i = 0;
                while(i < t.size()){
                    if(t.get(i).getSeller().equals(name)){
                        compare_sale = compare_sale + t.get(i).getAmount();
                        System.out.println(name);
                        System.out.println(compare_sale);
                    }
                    else{
                        if(compare_sale > total_sale){
                       
                            total_sale = compare_sale;
                            totalName = t.get(i-1).getSeller();
                        }
                        else{
                            compare_sale = 0.0;
                            compare_sale = compare_sale + t.get(i).getAmount();
                            name = t.get(i).getSeller();
                            System.out.println(name);
                            System.out.println(compare_sale);
                            System.out.println(total_sale);
                        }
                    }
                    i++;
                }
                if(compare_sale > total_sale){
                       
                            total_sale = compare_sale;
                            totalName = t.get(i-1).getSeller();
                }
                System.out.println("NAME: " + totalName + ", SALES: " + total_sale);
                s = est.databaseToSupplierAccountU(totalName);
                if(s != null){
                    squidward.setUserName(totalName);
                    squidward.setTotalSales(total_sale);
                    squid.add(squidward);
                    f_debt = s.getDebt() * 0.95;
                    int f = est.updateDebt(f_debt, s.getUserName());
                    if(f == 1){
                        Gson gson = new Gson();
                        JsonObject jo = new JsonObject();
                        response.setStatus(200);
                        jo.addProperty("user_name", squidward.getUserName());
                        jo.addProperty("total_sales", squidward.getUserID());
                        response.setStatus(200);
                        response.getWriter().write(jo.toString());
                    }
                    else{
                        response.setStatus(404);
                    }
                }
                else{
                    response.setStatus(404);
                }
            }
            else{
                response.setStatus(404);
            }   
        } catch (ParseException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        String action = request.getServletPath();
        System.out.println(action);
        switch(action){
            case "/GoodBoys":
                goodBoys(request, response);
                break;
            case "/BadBoys":
                badBoys(request,response);
                break;
            case "/SpongeBob":
                spongeBob(request,response);
                break;
            default:
                System.out.println("Something Went WRONG. IN DEFAULT.");
                break;
        }
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
            case "/ReturnPrivate":
                returnPrivate(request, response);
                break;
            case "/ReturnCompany":
                returnCompany(request, response);
                break;
            case "/DateQuestion":
                dateQuestion(request, response);
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
