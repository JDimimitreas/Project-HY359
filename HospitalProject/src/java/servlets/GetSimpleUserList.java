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
import mainClasses.Doctor;

/**
 *
 * @author Dell
 */
public class GetSimpleUserList extends HttpServlet {
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
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();

                String JSONOBject = gson.toJson(doc_list);

                Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
                String prettyJson = prettyGson.toJson(doc_list);

                response.setStatus(200);
                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(prettyJson);
                System.out.println("this is the JSON\n" + prettyJson);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(getDocList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
