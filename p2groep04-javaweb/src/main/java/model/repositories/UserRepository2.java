/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package model.repositories;


import entity.User;
import java.util.List;
import model.Repository;

/**
 *
 * @author Bram
 *//*
public class UserRepository2 extends Repository
{  
    public List<User> findAll()
    {       
        List<User> users =  getEm().createQuery("SELECT u FROM " + User.class.getSimpleName()).getResultList();
                
        return users;
    }
    
    public User findUserByUsername(String username)
    {       
       return (User)getEm().createQuery("SELECT u FROM" + User.class.getSimpleName() + "WHERE username=" + username +";").getSingleResult();           
    }
    
    public User findByUsernameAndPassword(String username, String saltpassword)
    {
        return (User)getEm().createQuery("SELECT u FROM" + User.class.getSimpleName() + "WHERE username=" + username + " AND password=" +  saltpassword + ";").getSingleResult(); 
    }
}
*/