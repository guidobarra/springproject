package com.guba.springaop.dao;

import org.springframework.stereotype.Component;

@Component
public class PersonDAO {

    public void addAccount() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP Account\n");
    }

    public void addSillyMember() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP Silly\n");
    }

    public boolean addThingMember() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ThingMember\n");
        return false;
    }

    public void filterMembership() {
        System.out.println(getClass() + ": DOING MY DB WORK: filterAccount\n");
    }
}
