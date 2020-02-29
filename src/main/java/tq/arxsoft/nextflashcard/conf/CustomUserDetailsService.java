/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.conf;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tq.arxsoft.nextflashcard.entity.UserAuth;
import tq.arxsoft.nextflashcard.logic.AuthorizationManager;
import tq.arxsoft.nextflashcard.logic.LessonManager;

/**
 *
 * @author tkudas
 */

@Service
@Primary
class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    AuthorizationManager authorizationManager;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserAuth userAuth = authorizationManager.getUserUtAuth(userName);
        if( userAuth == null || !userAuth.getEnabled() ) {
            throw new UsernameNotFoundException("Error: " + userName);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        User user = new User(userAuth.getUsername(), userAuth.getPassword(), authorities);
        return user;
    }
    
}
