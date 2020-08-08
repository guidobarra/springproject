package com.guba.springaop.service;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MembershipService {

    private final Logger LOGGER = Logger.getLogger(getClass().getName());
    
    public void findAccount() {
        LOGGER.info(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP findAccount\n");
    }

    public void findSillyMember() {
        LOGGER.info(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP findSillyMember\n");
    }

    public boolean findThingMember() {
        LOGGER.info(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ThingMember\n");
        return false;
    }

    public void filterMembershipService() {
        LOGGER.info(getClass() + ": DOING STUFF: findMembershipService\n");
    }
}
