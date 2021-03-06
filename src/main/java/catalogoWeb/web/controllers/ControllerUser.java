/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogoWeb.web.controllers;

import catalogoWeb.web.entidates.User;
import catalogoWeb.web.services.ServiceUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author figue
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControllerUser {
    @Autowired
    private ServiceUser servicio;
    @GetMapping("/all")
    public List<User> getUsers(){
        return servicio.getAll();
    }
    @GetMapping("/{email}")
    public boolean getByEamil(@PathVariable("email") String email) {
        return servicio.existUserEmail(email);
    }
    @GetMapping("/{email}/{password}")
    public User getByEmailPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
        return servicio.getUserByEmailAndPassword(email,password);
    }
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return servicio.save(user);
    }
    
}
