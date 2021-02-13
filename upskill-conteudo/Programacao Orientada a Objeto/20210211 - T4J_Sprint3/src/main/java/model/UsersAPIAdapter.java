/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.security.ntlm.Client;

/**
 *
 * @author nunocastro
 */
public class UsersAPIAdapter {
    private String app_context;

    public UsersAPIAdapter(String app_key) {
    }
    
    private String getContext() {
        if (app_context == "") {
            //Usar a API para obter o app_context
            app_context = "{7E19F342-A903-4C3B-806A-CF771120B9D0}";
        }
        return app_context;
    }
    
    public boolean login(String user_id, String password) {
        return true;
    }
    
    public boolean logout() {
        return true;
    }
    
    public boolean registerUser(String username, String email, String password) {
        return true;
    }
    
    public boolean registerUserWithRoles(String username, String email, String password, String rolenames) {
        return true;
    }
    
    public String getSession() {
        return "[{\"username\": \"anc\",\"email\": \"anc@isep.ipp.pt\",\"logindate\": \"2021-01-23T18:33:27.000Z\"}]";
    }
}
