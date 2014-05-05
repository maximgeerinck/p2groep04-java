/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
/**
 *
 * @author Maxim
 */
public class MyAuthenticationProvider
        extends AbstractUserDetailsAuthenticationProvider
        implements UserDetailsService {

    @Override
    public Authentication authenticate(Authentication authentication) 
    {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (name.equals("admin") && password.equals("system")) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
            return auth;
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails arg0, UsernamePasswordAuthenticationToken arg1) {

    }

    @Override
    protected UserDetails retrieveUser(String user, UsernamePasswordAuthenticationToken token) {
        return loadUserByUsername(user);
    }

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException, DataAccessException {
        return null;
    }

}
