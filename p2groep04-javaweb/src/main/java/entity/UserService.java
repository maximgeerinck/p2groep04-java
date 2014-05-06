/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Bram
 */
public class UserService 
{
    @Autowired
    private UserRepository userRepository;

   /* public boolean IsValidPassword(String username, String password) throws NoSuchAlgorithmException 
    {
        //get salt of this username
        List<User> temp = userRepository.findByUsername(username);
        String salt = temp.get(0).salt;

        if (salt == null) {
            return false;
        }

        //rebuild pass
        String saltPassword = Hashing.sha512().hashString(password + salt, Charsets.UTF_8).toString();

        //check if user can be found with this salt
        List<User> user = userRepository.findByUsernameAndPassword(username, saltPassword);

        return user.size() > 0;
    }*/
}
