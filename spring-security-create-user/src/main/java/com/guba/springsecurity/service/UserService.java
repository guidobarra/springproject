package com.guba.springsecurity.service;

import com.guba.springsecurity.crm.CrmUser;
import com.guba.springsecurity.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}
