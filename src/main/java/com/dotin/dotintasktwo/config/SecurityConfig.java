package com.dotin.dotintasktwo.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("employee1").password("123").roles("EMPLOYEE"))
                .withUser(users.username("employee2").password("123").roles("EMPLOYEE"))
                .withUser(users.username("employee3").password("123").roles("EMPLOYEE"))
                .withUser(users.username("manager1").password("123").roles("EMPLOYEE", "MANAGER"))
                .withUser(users.username("manager2").password("123").roles("EMPLOYEE", "MANAGER"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/manager/showForm*").hasRole("MANAGER")
                .antMatchers("/manager/save*").hasAnyRole("MANAGER", "EMPLOYEE")
                .antMatchers("/manager/delete").hasRole("MANAGER")
                .antMatchers("/manager/**").hasRole("EMPLOYEE")
                .antMatchers("/resources/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/LoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");

    }

}

