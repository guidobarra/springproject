package com.guba.springaop.dao;

import com.guba.springaop.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP Account\n");
    }

    public void addSillyMember(String thing, boolean condition) {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP Silly\n");
    }

    public boolean addThingMember() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ThingMember\n");
        return false;
    }

    public void filterMembership() {
        System.out.println(getClass() + ": DOING MY DB WORK: filterAccount\n");
    }

    public void noCallMethodsAspect() {
        System.out.println("\n\n" + getClass() + ": DOING MY DB WORK: noCallMethodsAspect\n");
    }
}
