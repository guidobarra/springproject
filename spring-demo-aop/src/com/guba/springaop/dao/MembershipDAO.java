package com.guba.springaop.dao;

import com.guba.springaop.domain.Account;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MembershipDAO {

    private final Logger LOGGER = Logger.getLogger(getClass().getName());
    
    public void addAccount() {
        LOGGER.info(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP Account\n");
    }

    public void addSillyMember(String thing, boolean condition) {
        LOGGER.info(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP Silly\n");
    }

    public boolean addThingMember() {
        LOGGER.info(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ThingMember\n");
        return false;
    }

    public void filterMembership() {
        LOGGER.info(getClass() + ": DOING MY DB WORK: filterAccount\n");
    }

    public void noCallMethodsAspect() {
        LOGGER.info("\n\n" + getClass() + ": DOING MY DB WORK: noCallMethodsAspect\n");
    }
}
