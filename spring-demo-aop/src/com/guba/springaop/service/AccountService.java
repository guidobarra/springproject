package com.guba.springaop.service;

import com.guba.springaop.domain.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private String name;

    private String pass;

    public void findAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN findAccount\n");
    }

    public String findAccountString() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN findAccountString\n");
        return "GUBA";
    }

    public void findAccountParameter(Account account, boolean b) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN findAccountParameter\n");
    }

    public String getName() {
        System.out.println(getClass() + ": getName\n");
        return name;
    }

    public String getPass() {
        System.out.println(getClass() + ": getPass\n");
        return pass;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName\n");
        this.name = name;
    }

    public void setPass(String pass) {
        System.out.println(getClass() + ": setPass\n");
        this.pass = pass;
    }
}
