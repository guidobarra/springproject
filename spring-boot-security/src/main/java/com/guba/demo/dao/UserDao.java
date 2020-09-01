package com.guba.demo.dao;

import com.guba.demo.domain.UserDetailsImpl;

import java.util.Optional;

public interface UserDao {

    Optional<UserDetailsImpl> selectApplicationUserByUsername(String username);

}