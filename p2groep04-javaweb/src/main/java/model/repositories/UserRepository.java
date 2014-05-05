/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.repositories;

import entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Maxim
 */
public interface UserRepository extends JpaRepository<User, Long> 
{
    List<User> findByUsername(String username);
    List<User> findByUsernameAndPassword(String username, String password);
}
