/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClasses;

import mainClasses.User;
import mainClasses.SimpleUser;
import database.tables.EditSimpleUserTable;
import database.tables.EditDoctorTable;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author stelios
 */
public class Admin extends User{

    /**
     *
     * @param username
     * @param password
     * @param firstname
     * @param lastname
     * @return
     */
    public Admin newAdmin(String username, String password, String firstname, String lastname){
        this.setUsername(username);
        this.setPassword(password);
        this.setFirstname(firstname);
        this.setLastname(lastname);
        return this;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    //Returns all simpleUsers
    public ArrayList<SimpleUser> getSimpleUserList() throws SQLException, ClassNotFoundException{
        EditSimpleUserTable esut = new EditSimpleUserTable();
        
        return esut.getAllUsers();   
    }
    
    //Returns all Doctors
    public ArrayList<Doctor> getDoctorList(){
        
        return null;   
    }
    
}
