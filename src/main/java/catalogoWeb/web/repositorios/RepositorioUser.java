/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogoWeb.web.repositorios;

import catalogoWeb.web.entidates.User;
import catalogoWeb.web.interfaces.InterfaceUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author figue
 */
@Repository
public class RepositorioUser {
    @Autowired
    private InterfaceUser crud1;
    public List<User> getAll(){
	        return (List<User>) crud1.findAll();
	    }
    public Optional<User> getUserById(Long id) {
        return crud1.findById(id);
    }
    public boolean getUserByEmail(String email) {
        return crud1.findByEmail(email) != null;
    }
    public User getUserByEmailAndPassword(String email,String password) {
        User generic=crud1.findByEmailAndPassword(email, password);
        if(generic==null){
            User user= new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setName("NO DEFINIDO");
            return user;
        }
        return generic;
    }
    public User save(User user){
	        return crud1.save(user);
	    }
}
