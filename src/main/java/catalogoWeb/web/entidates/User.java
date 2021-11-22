/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogoWeb.web.entidates;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 *
 * @author figue
 */
@Entity
@Table(name ="user")
public class User implements Serializable  {

  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID" )
    private Long id;
    @Column(name="EMAIL",length=50,  unique=true ,nullable=false)
    private String email;
    
    @Column(name="PASSWORD",length=50,nullable=false)
    private String password;
    @Column(name="NAME",length=80,nullable=false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
