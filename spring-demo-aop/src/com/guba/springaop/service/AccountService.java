package com.guba.springaop.service;

import com.guba.springaop.domain.Account;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AccountService {

    private final Logger LOGGER = Logger.getLogger(getClass().getName());
    
    private String name;

    private String pass;

    public void findAccount() {
        LOGGER.info(getClass() + ": DOING MY DB WORK: ADDING AN findAccount\n");
    }

    public String findAccountString() {
        LOGGER.info(getClass() + ": DOING MY DB WORK: ADDING AN findAccountString\n");
        return "GUBA";
    }

    public void findAccountParameter(Account account, boolean b) {
        LOGGER.info(getClass() + ": DOING MY DB WORK: ADDING AN findAccountParameter\n");
    }

    public String getName() {
        LOGGER.info(getClass() + ": getName\n");
        return name;
    }

    public String getPass() {
        LOGGER.info(getClass() + ": getPass\n");
        return pass;
    }

    public void setName(String name) {
        LOGGER.info(getClass() + ": setName\n");
        this.name = name;
    }

    public void setPass(String pass) {
        LOGGER.info(getClass() + ": setPass\n");
        this.pass = pass;
    }
}
