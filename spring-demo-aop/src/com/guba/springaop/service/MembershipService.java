package com.guba.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class MembershipService {

    public void findAccount() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP findAccount\n");
    }

    public void findSillyMember() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP findSillyMember\n");
    }

    public boolean findThingMember() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ThingMember\n");
        return false;
    }
}
