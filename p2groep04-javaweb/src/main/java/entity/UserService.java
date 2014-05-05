/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.soap.MessageFactory;
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
        String saltPassword = encrypt(password + salt);

        //check if user can be found with this salt
        User user = userRepository.findByUsernameAndPassword(username, saltPassword);

        return user != null;
    }

    public static String encrypt(String password) throws NoSuchAlgorithmException {
//            System.Security.Cryptography.SHA512Managed sha = new System.Security.Cryptography.SHA512Managed();
//            byte[] hash = sha.ComputeHash(Encoding.ASCII.GetBytes(password));
//            StringBuilder stringBuilder = new StringBuilder();
//
//            foreach (byte b in hash)
//            {
//                stringBuilder.AppendFormat("{0:x2}", b);
//            }
//            return stringBuilder.ToString();

        MessageDigest digest = java.security.MessageDigest.getInstance("SHA512");
        byte[] hash;
        
        
        

    }
}
