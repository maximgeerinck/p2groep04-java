/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

/**
 *
 * @author Bram
 */
public class UserService 
{
    public boolean IsValidPassword(String username, String password)
        {
            //get salt of this username
            String salt = UserRepository.FindSaltByUsername(username);

            if (salt == null)
            {
                return false;
            }

            //rebuild pass
            string saltPassword = Encrypt(password + salt);

            //check if user can be found with this salt
            User user = _userRepository.FindByUsernameAndPassword(username, saltPassword);

            return user != null;
        }
    
    
}
