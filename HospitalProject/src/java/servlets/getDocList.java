/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import database.tables.EditDoctorTable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import mainClasses.Doctor;
//import org.apache.catalina.connector.Response;

/**
 *
 * @author stelios
 */
public class getDocList extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
//        EditDoctorTable edt = new EditDoctorTable();
//        ArrayList<Doctor> doc_list = new ArrayList<Doctor>();
//        
//        doc_list = edt.databaseToDoctors();
//        
//        //Print docList
//        for( int i=0; i<doc_list.size(); i++){
//            Doctor dummy_doc = new Doctor();
//            dummy_doc = doc_list.get(i);
//            System.out.println("Doc_name: " + dummy_doc.getUsername());
//        }
//        
//        if( doc_list.size() > 0 ){
////            request.setCharacterEncoding("utf8");
////            response.setContentType("application/json");
////            String json = new Gson().toJson(doc_list);
//            GsonBuilder gsonBuilder = new GsonBuilder();
//            Gson gson = gsonBuilder.create();
//            
//            String JSONOBject = gson.toJson(doc_list);
//            
//            Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
//            String prettyJson = prettyGson.toJson(doc_list);
//            
//            System.out.println("this is the JSON\n" + prettyJson);
//            
//            response.setStatus(201);
//            PrintWriter out = response.getWriter();
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
//            out.print(prettyJson);
//            response.getWriter().write(prettyJson);
//            out.flush();
//        }
        
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
        
        try {
            EditDoctorTable edt = new EditDoctorTable();
            ArrayList<Doctor> doc_list = new ArrayList<Doctor>();
            
            doc_list = edt.databaseToDoctors();
            
            //Print docList
            for( int i=0; i<doc_list.size(); i++){
                Doctor dummy_doc = new Doctor();
                dummy_doc = doc_list.get(i);
                System.out.println("Doc_name: " + dummy_doc.getUsername());
            }
            
            if( doc_list.size() > 0 ){
//            request.setCharacterEncoding("utf8");
//            response.setContentType("application/json");
//            String json = new Gson().toJson(doc_list);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();

                String JSONOBject = gson.toJson(doc_list);

                Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
                String prettyJson = prettyGson.toJson(doc_list);

                System.out.println("this is the JSON\n" + prettyJson);

                response.setStatus(200);
                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(prettyJson);
                response.getWriter().write(prettyJson);
                out.flush();
            }
        } catch (SQLException ex) {
            Logger.getLogger(getDocList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getDocList.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(getDocList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getDocList.class.getName()).log(Level.SEVERE, null, ex);
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
