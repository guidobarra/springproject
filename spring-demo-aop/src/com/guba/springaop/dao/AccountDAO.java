package com.guba.springaop.dao;

import com.guba.springaop.domain.Account;
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

    public void addAccountParameter(Account account, boolean b) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN addAccountParameter\n");
    }
}
