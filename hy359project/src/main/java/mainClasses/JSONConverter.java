/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClasses;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import mainClasses.SimpleUser;
import mainClasses.User;

/**
 *
 * @author stelios
 */
public class JSONConverter {
    
    public String getJSONFromAjax(BufferedReader reader) throws IOException {
        StringBuilder buffer = new StringBuilder();
        String line;
        
        while( (line = reader.readLine()) != null) {
            buffer.append(line);
        }
        String data = buffer.toString();
        return data;
    }

    // Afti prepei na thn exw grapsei egw
    public SimpleUser jsonToSimpleUser(BufferedReader json) {
        Gson gson = new Gson();
        SimpleUser simple_user = new SimpleUser();
        simple_user = gson.fromJson(json, SimpleUser.class);
        return simple_user;
    }
    
    public User jsonToUser(BufferedReader json) {
        Gson gson = new Gson();
        User user = new User();
        user = gson.fromJson(json, User.class);
        return user;
    }
}


