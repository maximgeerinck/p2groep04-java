/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import entity.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author Maxim
 */
public class MyAuthenticationProvider implements AuthenticationProvider 
{
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException 
    {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String username = String.valueOf(auth.getPrincipal());
        String password = String.valueOf(auth.getCredentials());

        System.out.println("username:" + username);
        System.out.println("password:" + password); // Don't log passwords in real app

        // 1. Use the username to load the data for the user, including authorities and password.
        User user = (User)userRepository.findOneByUsername(username);

        if(user == null) 
            throw new BadCredentialsException("Bad Credentials");
        
        String saltPassword = Hashing.sha512().hashString(password + user.getSalt(), Charsets.UTF_8).toString();
        System.out.println("Salted pass: " + saltPassword);
        // 2. Check the passwords match.
        if (!user.getPassword().equals(saltPassword)) {
            throw new BadCredentialsException("Bad Credentials");
        }

        // 3. Preferably clear the password in the user object before storing in authentication object
        //user.clearPassword();

        // 4. Return an authenticated token, containing user data and authorities  
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
