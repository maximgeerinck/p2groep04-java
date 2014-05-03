/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import entity.User;
import java.util.List;

/**
 *
 * @author Bram
 */
public class UserRepository extends Repository
{
    
    
    public List<User> findAll()
    {
        getEm().getTransaction().begin();
        
        List<User> users =  getEm().createQuery("SELECT u FROM " + User.class.getSimpleName()).getResultList();
        getEm().getTransaction().commit();
        getEm().close();
        
        return users;
    }
    
    public User findSaltByUsername(String username)
    {
        getEm().getTransaction().begin();
        User user = getEm().createQuery("SELECT u FROM " + User.class.getSimpleName() + " u WHERE u.username = :username").setParameter("username", username).getSingleResult();
        getEm().getTransaction().commit();
        getEm().close();
        
        return user;
    }
}
