package com.guba.springaop.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MembershipController {

    String status;

    public void filterMembershipController() {
        System.out.println(getClass() + ": DOING MY DB WORK: filterAccountController\n");
    }

    public void findMembershipController() {
        System.out.println(getClass() + ": DOING MY DB WORK: findMembershipController\n");
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
