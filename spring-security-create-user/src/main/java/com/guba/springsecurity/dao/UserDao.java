package com.guba.springsecurity.dao;

import com.guba.springsecurity.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
