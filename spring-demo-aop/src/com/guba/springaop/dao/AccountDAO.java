package com.guba.springaop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT\n");
    }

    public String addAccountString() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN addAccountString\n");
        return "GUBA";
    }
}
