/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import java.security.NoSuchAlgorithmException;
import model.UserRepository;

/**
 *
 * @author Bram
 */
public class UserService {

    UserRepository userRepository;

    public boolean IsValidPassword(String username, String password) throws NoSuchAlgorithmException {
        //get salt of this username
        User temp = userRepository.findUserByUsername(username);
        String salt = temp.salt;

        if (salt == null) {
            return false;
        }

        //rebuild pass
        String saltPassword = Hashing.sha512().hashString(password + salt, Charsets.UTF_8).toString();        

        //check if user can be found with this salt
        User user = userRepository.findByUsernameAndPassword(username, saltPassword);

        return user != null;
    }
}
