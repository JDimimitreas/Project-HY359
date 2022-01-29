/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import database.DB_Connection;
import database.tables.EditRandevouzTable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainClasses.Randevouz;

/**
 *
 * @author steli
 */
public class NewRandevouz extends HttpServlet {

    public static String getJsonFromRequest(HttpServletRequest request){
    
        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            // throw ex;
            return "";
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {

                }
            }
        }

        body = stringBuilder.toString();
        return body;
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            JSONObject jObj = new JSONObject( getJsonFromRequest(request) );
            
            String searchQuery = "SELECT * FROM `randevouz` WHERE doctor_id='" + jObj.get("doctor_id") +
                    "' AND date_time='" + jObj.getString("date") + " " + jObj.getString("hours") +
                    ":" + jObj.getString("minutes") + ":00'";
            
//            System.out.println("The first search query is: " + searchQuery );
            
            Connection con = DB_Connection.getConnection();
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(searchQuery);
            
            if( !rs.next() ){
                // rs is empty so we can insert the new Randevouz!!
                response.setStatus(200);
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                System.out.println("Success, this randevouz is available!!");
                out.println("Success, this randevouz is available"); //true for available randevouz
                
                //TODO create the new randevouz
                EditRandevouzTable ert = new EditRandevouzTable();
                
                //First setUp the randevouz
                Randevouz ran = new Randevouz();
                String date_time = jObj.getString("date");
                date_time += " " + jObj.getString("hours") + ":" + jObj.getString("minutes");
                date_time += ":00";
                System.out.println("date_time is: " + date_time);
                
                
//                int doctor_id = jObj.getInt("doctor_id");
                int doctor_id = Integer.parseInt( jObj.getString("doctor_id") );
                
                System.out.println( doctor_id );

                ran.setDoctor_id( jObj.getInt("doctor_id") );
                ran.setUser_id( jObj.getInt("user_id") );
                ran.setPrice( jObj.getInt("price") );
                ran.setDate_time(date_time);
                ran.setDoctor_info( jObj.getString("doctor_info"));
                ran.setUser_info(jObj.getString("user_info"));
                ran.setStatus( jObj.getString("status"));
                
                String insertQuery = "INSERT INTO "
                    + " randevouz (doctor_id,user_id,date_time,price,doctor_info,user_info,status)"
                    + " VALUES ("
                    + "'" + ran.getDoctor_id() + "',"
                    + "'" + ran.getUser_id() + "',"
                    + "'" + ran.getDate_time() + "',"
                    + "'" + ran.getPrice() + "',"
                    + "'" + ran.getDoctor_info() + "',"
                    + "'" + ran.getUser_info() + "',"
                    + "'" + ran.getStatus() + "'"
                    + ")";
                
                System.out.println("insertQuery: "+ insertQuery);
                
                ert.createNewRandevouz(ran);
                
                out.println("New randevouz is added");
                
            } else {
                // rs is not empty we cant enter the new randevouz, display message
                // to user that his date_time and doctor are not available
                response.setStatus(200);
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                System.out.println("Failure, this randevouz is not available..");
                out.println("Failure, this randevouz is not available.."); // false for unavailable randevouz
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(NewRandevouz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewRandevouz.class.getName()).log(Level.SEVERE, null, ex);
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
