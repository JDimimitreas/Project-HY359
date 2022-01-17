package servlets;

import database.tables.EditDoctorTable;
import database.tables.EditSimpleUserTable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mainClasses.Doctor;
import mainClasses.SimpleUser;

//@WebServlet("/SignUp")
public class SignUp extends HttpServlet {

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
        try(PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");
            
            String username     = request.getParameter("username");
            String email        = request.getParameter("email");
            String password     = request.getParameter("psw");
            
            String userType     = request.getParameter("userType");
            
            String name         = request.getParameter("name");
            String surname      = request.getParameter("surname");
            String year         = request.getParameter("year");
            String month        = request.getParameter("month");
            String day          = request.getParameter("day");
            String gender       = request.getParameter("gender");
            String amka         = request.getParameter("amka");
            String country      = request.getParameter("country");
            String city         = request.getParameter("city");
            String address      = request.getParameter("address");
            String phone        = request.getParameter("phone");
            String height       = request.getParameter("height");
            String weight       = request.getParameter("weight");
            String bloodDonor   = request.getParameter("bloodDonor");
            String bloodType    = request.getParameter("bloodType");

            if(userType.equals("typeDefault")) {
                EditSimpleUserTable eut = new EditSimpleUserTable();
                SimpleUser su = eut.databaseToSimpleUser(username, password);
                if(su!=null){
                    response.getWriter().write("User already exists");
                    response.setStatus(409);
                }else {
                    String userJSON = "{\"username\":\"" + username + "\","
                        + "\"email\":\"" + email + "\","
                        + "\"password\":\"" + password + "\","
                        + "\"firstname\":\"" + name + "\","
                        + "\"lastname\":\"" + surname + "\","
                        + "\"birthdate\":\"" + year + "-" + month + "-" + day + "\","
                        + "\"gender\":\"" + gender + "\","
                        + "\"amka\":\"" + amka + "\","
                        + "\"country\":\"" + country + "\","
                        + "\"city\":\"" + city + "\","
                        + "\"address\":\"" + address + "\","
                        + "\"lat\":\"35.3053121\",\"lon\":\"25.0722869\","
                        + "\"telephone\":\"" + phone + "\","
                        + "\"height\":\"" + height + "\","
                        + "\"weight\":\"" + weight + "\","
                        + "\"blooddonor\":\"" + bloodDonor + "\","
                        + "\"bloodtype\":\"" + bloodType + "\"}";

                    response.getWriter().write(userJSON);
                    eut.addSimpleUserFromJSON(userJSON);
                    response.setStatus(201);
                }
            }else{
                EditDoctorTable edt = new EditDoctorTable();
                Doctor doc = edt.databaseToDoctor(username, password);
                if(doc!=null){
                    response.getWriter().write("Doctor already exists");
                    response.setStatus(409);
                }else {                
                    String specialty        = request.getParameter("specialty");
                    String doctor_info      = request.getParameter("doc_text");
                    String jsonDoctor = "{\"username\":\"" + username + "\","
                        + "\"email\":\"" + email + "\","
                        + "\"password\":\"" + password + "\","
                        + "\"firstname\":\"" + name + "\","
                        + "\"lastname\":\"" + surname + "\","
                        + "\"birthdate\":\"" + year + "-" + month + "-" + day + "\","
                        + "\"gender\":\"" + gender + "\","
                        + "\"amka\":\"" + amka + "\","
                        + "\"country\":\"" + country + "\","
                        + "\"city\":\"" + city + "\","
                        + "\"address\":\"" + address + "\","
                        + "\"lat\":\"35.3053121\",\"lon\":\"25.0722869\","
                        + "\"telephone\":\"" + phone + "\","
                        + "\"height\":\"" + height + "\","
                        + "\"weight\":\"" + weight + "\","
                        + "\"blooddonor\":\"" + bloodDonor + "\","
                        + "\"bloodtype\":\"" + bloodType + "\","
                        + "\"specialty\":\"" + specialty + "\","
                        + "\"doctor_info\":\"" + doctor_info + "\","
                        + "\"certified\":\"1\""
                        + "}";                 

                    response.getWriter().write(jsonDoctor);
                    edt.addDoctorFromJSON(jsonDoctor);
                    response.setStatus(201);
                }  
            }    
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
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
    }
}

