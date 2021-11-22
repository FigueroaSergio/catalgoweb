/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogoWeb.web.interfaces;

import catalogoWeb.web.entidates.User;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author figue
 */
public interface InterfaceUser extends CrudRepository<User,Long>{
    
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);
}
