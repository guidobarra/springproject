package com.guba.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Inject our data source that we just configured in "DemoAppConfig"
    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // spring security used table user and authorities for roles, password, read register
        // No Longer hard-coding users :-)
        // Tell spring security to use JDBC authentication with our data source
        auth.jdbcAuthentication().dataSource(securityDataSource);

        /**
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
            .withUser(userBuilder.username("john").password("test123").roles("EMPLOYEE"))
            .withUser(userBuilder.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
            .withUser(userBuilder.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));
         */
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
             .and()
             .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
             .and()
                .logout()
                .permitAll()
             .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }
}
