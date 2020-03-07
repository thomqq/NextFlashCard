/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.conf;

import tq.arxsoft.nextflashcard.logic.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 *
 * @author tkudas
 */
@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
////        authenticationMgr.inMemoryAuthentication()
////                .withUser("journaldev")
////                .password("jd@123")
////                .authorities("ROLE_USER");
//
//        authenticationMgr
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select username, password, enabled "
//                        + "from user_auth where username=?")
//                .authoritiesByUsernameQuery(
//                        "select username, 'ROLE_USER' from user_auth where username=?");
//    }
    
    
    @Autowired
    CustomUserDetailsService customUserDetailsService;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.csrf().disable()
                
                .authorizeRequests()
           
                .antMatchers("/logic/loginPage").permitAll()
                .antMatchers("/logic/*").hasRole("USER")
               
                .and()
                .formLogin().loginPage("/logic/loginPage")
                .defaultSuccessUrl("/logic/show")
                .failureUrl("/logic/loginPage?error")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/logic/logout")
                .logoutSuccessUrl("/logic/loginPage?logout")
                ;
                
//                .invalidateHttpSession(true).
//                deleteCookies("JSESSIONID");

    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new StandardPasswordEncoder("@322Qd#$");
        return encoder;
    }
}
