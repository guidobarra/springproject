package com.guba.springaop.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;

import java.util.logging.Logger;

@Controller
public class AccountController {

    private final Logger LOGGER = Logger.getLogger(getClass().getName());
    
    String status;
    
    public void filterAccountController() {
        LOGGER.info(getClass() + ": DOING MY DB WORK: filterAccountController\n");
    }

    public void getAccount() {
        LOGGER.info(getClass() + ": DOING MY DB WORK: getAccount\n");
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
