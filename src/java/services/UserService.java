/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
import dataaccess.UserDB;
import java.util.List;
import models.User;

/**
 *
 * @author 813033
 */
public class UserService {
    
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
      
    public void insert(String email, boolean active, String firstName, String lastName, String password, int role) throws Exception {
        UserDB userDB = new UserDB();
        User user = new User(email, active, firstName, lastName, password);

        RoleDB roleDB = new RoleDB();
        user.setRole(roleDB.get(role));
        
        userDB.insert(user);
    }
    
    public void update(String email, boolean active, String firstName, String lastName, String password, int role) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        
        RoleDB roleDB = new RoleDB();
        user.setRole(roleDB.get(role));
        
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        System.out.println(user.toString() + " this is in delete");
        userDB.delete(user);
    }
    
}
