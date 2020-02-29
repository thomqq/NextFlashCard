/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 *
 * @author tkudas
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication()
                .withUser("journaldev")
                .password("jd@123")
                .authorities("ROLE_USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //.csrf().disable()
            .authorizeRequests()
            .antMatchers("/logic/loginPage").permitAll()
            .antMatchers("/logic/*").access("hasRole('ROLE_USER')")
            .and()
            .formLogin().loginPage("/logic/loginPage")
            .defaultSuccessUrl("/logic/show")
            .failureUrl("/logic/loginPage?error")
            .usernameParameter("username").passwordParameter("password")
            .and()
            .logout()
            .logoutUrl("/logic/logout")
            .logoutSuccessUrl("/logic/loginPage?logout");
//                .invalidateHttpSession(true).
//                deleteCookies("JSESSIONID");

    }
}