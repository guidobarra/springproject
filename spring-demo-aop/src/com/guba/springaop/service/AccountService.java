package com.guba.springaop.service;

import com.guba.springaop.domain.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

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
}
