/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.repositories;

import entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Maxim
 */
public interface UserRepository extends JpaRepository<User, Long> 
{
    @Query("select u from User u where username = ?1")
    List<User> findByUsername(String username);
    
    @Query("select u from User u where username = ?1 and password = ?2")
    List<User> findByUsernameAndPassword(String username, String password);
    
    @Query("select u from User u where username = ?1")
    User findOneByUsername(String username);
}
