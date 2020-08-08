package com.guba.springaop.controller;

import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

@Controller
public class MembershipController {

    private final Logger LOGGER = Logger.getLogger(getClass().getName());
    
    String status;

    public void filterMembershipController() {
        LOGGER.info(getClass() + ": DOING MY DB WORK: filterAccountController\n");
    }

    public void findMembershipController() {
        LOGGER.info(getClass() + ": DOING MY DB WORK: findMembershipController\n");
    }

    public String getStatus() {
        LOGGER.info(getClass() + ": DOING MY DB WORK: getStatus\n");
        return status;
    }

    public void setStatus(String status) {
        LOGGER.info(getClass() + ": DOING MY DB WORK: setStatus\n");
        this.status = status;
    }
}
