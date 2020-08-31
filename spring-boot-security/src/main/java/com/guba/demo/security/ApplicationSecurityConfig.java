package com.guba.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.guba.demo.enums.UserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasAnyRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        // simulate data base
        UserDetails guidinhoUser = createUserDetail("guidinho", "password", STUDENT.name());

        UserDetails luciaUser = createUserDetail("lucia", "password123", ADMIN.name());

        UserDetails tomUser = createUserDetail("lucia", "password123", ADMINTRAINING.name());

        return new InMemoryUserDetailsManager(
                guidinhoUser,
                luciaUser,
                tomUser);
    }

    private UserDetails createUserDetail(String userName, String pass, String role) {
        return User.builder()
                .username(userName)
                .password(passwordEncoder.encode(pass))
                .roles(role) // is ROLE_STUDENT or ROLE_ADMIN etc
                .build();
    }
}
