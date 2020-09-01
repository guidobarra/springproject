package com.guba.demo.dao;

import com.google.common.collect.Lists;
import com.guba.demo.domain.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.guba.demo.enums.UserRole.*;

@Repository("fake")
public class UserDaoImpl implements UserDao {

    private final PasswordEncoder passwordEncoder;

    private static final String PASS = "password";

    @Autowired
    public UserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<UserDetailsImpl> selectApplicationUserByUsername(String username) {
        return getUserDetailsImpls()
                .stream()
                .filter(u -> username.equals(u.getUsername()))
                .findFirst();
    }

    private List<UserDetailsImpl> getUserDetailsImpls() {
        return Lists.newArrayList(
                new UserDetailsImpl(
                        "annasmith",
                        passwordEncoder.encode(PASS),
                        STUDENT.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true
                ),
                new UserDetailsImpl(
                        "linda",
                        passwordEncoder.encode(PASS),
                        ADMIN.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true
                ),
                new UserDetailsImpl(
                        "tom",
                        passwordEncoder.encode(PASS),
                        ADMINTRAINING.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true
                )
        );
    }

}