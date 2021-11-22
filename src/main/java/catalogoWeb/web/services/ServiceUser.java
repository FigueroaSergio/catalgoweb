/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogoWeb.web.services;

import catalogoWeb.web.entidates.User;
import catalogoWeb.web.repositorios.RepositorioUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author figue
 */
@Service
public class ServiceUser {
     @Autowired
    private RepositorioUser metodosCrud;

    public List<User> getAll() {
        return metodosCrud.getAll();
    }
    public User save(User user){
       boolean usermail;
         usermail = metodosCrud.getUserByEmail(user.getEmail());
         
       if(usermail){
           return user;
       }
       else if (user.getId()== null) {
          
                    return metodosCrud.save(user);
              
        } else {
            User userId = metodosCrud.getUserById(user.getId()).orElse(null);
            if (userId==null) {              
      
                    return metodosCrud.save(user);
            } else {
                return user;
            }
        }
    }
    public boolean existUserEmail(String email){
        return metodosCrud.getUserByEmail(email);
    }
    public User getUserByEmailAndPassword(String email,String password){
        return metodosCrud.getUserByEmailAndPassword(email ,password);
    }
}
