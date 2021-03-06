/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import database.tables.EditSimpleUserTable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mainClasses.SimpleUser;

/**
 *
 * @author Dell
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {
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
        try {
            //response.setContentType("text/html;charset=UTF-8");

            HttpSession session = request.getSession(true);
            response.sendRedirect(request.getContextPath() + "/example_login_sevlet");





            ArrayList<SimpleUser> list = new ArrayList<SimpleUser>();
            EditSimpleUserTable su = new EditSimpleUserTable();
            list = su.getAllUsers();
            
            String userJSON;
            String responseJSON;
            responseJSON = "[";
            
            
            for(int i=0; i<list.size(); i++){
                System.out.println("I got from list: " + list.get(i).getUsername());
                userJSON = "{\"username\":\"" + list.get(i).getUsername() + "\","
                        + "\"email\":\"" + list.get(i).getEmail() + "\","
                        + "\"password\":\"" + list.get(i).getPassword() + "\","
                        + "\"firstname\":\"" + list.get(i).getFirstname() + "\","
                        + "\"lastname\":\"" + list.get(i).getLastname() + "\","
                        + "\"birthdate\":\"" + list.get(i).getBirthdate() + "\","
                        + "\"gender\":\"" + list.get(i).getGender() + "\","
                        + "\"amka\":\"" + list.get(i).getAmka() + "\","
                        + "\"country\":\"" + list.get(i).getCountry() + "\","
                        + "\"city\":\"" + list.get(i).getCity() + "\","
                        + "\"address\":\"" + list.get(i).getAddress() + "\","
                        + "\"lat\":\"35.3053121\",\"lon\":\"25.0722869\","
                        + "\"telephone\":\"" + list.get(i).getTelephone() + "\","
                        + "\"height\":\"" + list.get(i).getHeight() + "\","
                        + "\"weight\":\"" + list.get(i).getWeight() + "\","
                        + "\"blooddonor\":\"" + list.get(i).getBlooddonor() + "\","
                        + "\"bloodtype\":\"" + list.get(i).getBloodtype() + "\"}";
                responseJSON += userJSON;
                if(list.size() != i + 1 ) {
                    responseJSON += ',';
                }
//                response.getWriter().write(userJSON);
                
            }
            responseJSON += "]";
            response.getWriter().write(responseJSON);
            
            response.setStatus(201);
            
         

            
            System.out.println("This is the size: " + list.size());
        } catch (SQLException ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
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
