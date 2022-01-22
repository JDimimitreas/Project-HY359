/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.tables.EditRandevouzTable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainClasses.Randevouz;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author stelios
 */
public class GetAllRandevouz extends HttpServlet {

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
            EditRandevouzTable ert = new EditRandevouzTable();
            Randevouz randevouz    = new Randevouz();
            ArrayList<Randevouz> ran_list = new ArrayList<Randevouz>();
            
            ran_list = ert.databaseToRandevouz();
            
            // Print all randevouz
            for( Randevouz ran : ran_list ){
                System.out.println(ran.getDate_time());
            }
            
            // Prepare the json answer
            if( ran_list.size() > 0 ){
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson               = gsonBuilder.create();
                String JSON_object      = gson.toJson(ran_list);
                
                Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
                String prettyJson = prettyGson.toJson(ran_list);
                
                response.setStatus(200);
                PrintWriter out = response.getWriter();
                response.setContentType("applicaiton/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(prettyJson);
                System.out.println("this is the JSON\n" + prettyJson);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetAllRandevouz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetAllRandevouz.class.getName()).log(Level.SEVERE, null, ex);
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
        System.out.println("Im in GetAllRandevouz!! POST");
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
