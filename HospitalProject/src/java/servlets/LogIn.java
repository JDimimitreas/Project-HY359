package servlets;

import database.tables.EditSimpleUserTable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mainClasses.SimpleUser;

public class LogIn extends HttpServlet {

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
        try(PrintWriter out = response.getWriter()) {
            String username     = request.getParameter("username");
            String password     = request.getParameter("psw");
            
            //Assuming he is a simple user
            EditSimpleUserTable eut = new EditSimpleUserTable();
            SimpleUser su = eut.databaseToSimpleUser(username, password);
            if(su!=null){
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);
            }else {
                response.setStatus(404);
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
