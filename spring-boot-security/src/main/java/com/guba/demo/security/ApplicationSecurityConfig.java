package com.guba.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.guba.demo.enums.UserPermission.COURSE_WRITE;
import static com.guba.demo.enums.UserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasAnyRole(STUDENT.name())
                //.antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
                //.antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
                //.antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
                //.antMatchers("/management/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINING.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/courses", true)
                    .passwordParameter("password")
                    .usernameParameter("username")
                .and()
                .rememberMe()
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                    .key("somethingverysecured")
                    .rememberMeParameter("remember-me")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) // https://docs.spring.io/spring-security/site/docs/4.2.12.RELEASE/apidocs/org/springframework/security/config/annotation/web/configurers/LogoutConfigurer.html
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID", "remember-me")
                    .logoutSuccessUrl("/login");
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        // simulate data base
        /**
        UserDetails guidinhoUser = createUserDetailRole("guidinho", "password", STUDENT.name());

        UserDetails luciaUser = createUserDetailRole("lucia", "password123", ADMIN.name());

        UserDetails tomUser = createUserDetailRole("tom", "password123", ADMINTRAINING.name());
        */
        UserDetails guidinhoUser = createUserDetailRoleAndPermissions("guidinho", "password", STUDENT.getGrantedAuthority());

        UserDetails luciaUser = createUserDetailRoleAndPermissions("lucia", "password123", ADMIN.getGrantedAuthority());

        UserDetails tomUser = createUserDetailRoleAndPermissions("tom", "password123", ADMINTRAINING.getGrantedAuthority());

        return new InMemoryUserDetailsManager(
                guidinhoUser,
                luciaUser,
                tomUser);
    }

    private UserDetails createUserDetailRole(String userName, String pass, String role) {
        return User.builder()
                .username(userName)
                .password(passwordEncoder.encode(pass))
                .roles(role) // is ROLE_STUDENT or ROLE_ADMIN etc
                .build();
    }

    private UserDetails createUserDetailRoleAndPermissions(String userName, String pass, Set<SimpleGrantedAuthority> roleAndPermissions) {
        return User.builder()
                .username(userName)
                .password(passwordEncoder.encode(pass))
                .authorities(roleAndPermissions) // ROLE_STUDENT and permissions of ROLE_STUDENT etc
                .build();
    }
}
