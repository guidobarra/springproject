package com.guba.springaop.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class AccountController {

    String status;
    public void filterAccountController() {
        System.out.println(getClass() + ": DOING MY DB WORK: filterAccountController\n");
    }

    public void getAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: getAccount\n");
    }

    public String getStatus() {
        System.out.println(getClass() + ": DOING MY DB WORK: getStatus\n");
        return status;
    }

    public void setStatus(String status) {
        System.out.println(getClass() + ": DOING MY DB WORK: setStatus\n");
        this.status = status;
    }
}
