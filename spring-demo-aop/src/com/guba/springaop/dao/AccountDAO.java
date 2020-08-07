package com.guba.springaop.dao;

import com.guba.springaop.domain.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT\n");
    }

    public String addAccountString() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN addAccountString\n");
        return "GUBA";
    }

    public void addAccountParameter(Account account, boolean b) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN addAccountParameter\n");
    }

    public void filterAccountDAO() {
        System.out.println(getClass() + ": DOING MY DB WORK: filterAccountDAO\n");
    }

    public void noCallMethodsAspect() {
        System.out.println("\n\n" + getClass() + ": DOING MY DB WORK: noCallMethodsAspect\n");
    }

    public List<Account> getAccounts() {
        System.out.println("\n\n" + getClass() + ": DOING MY DB WORK: getAccounts\n");
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Pepe", "Two"));
        accounts.add(new Account("Lucia", "Tree"));
        System.out.println(getClass() + " List: " + accounts+ "\n");
        return  accounts;
    }

    public List<Account> findAccounts(boolean tripWire) throws RuntimeException {

        // for academic purpose ... simulate an exception
        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        // add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);


        return myAccounts;
    }

    public List<Account> mapReduceAccounts(boolean tripWire) throws RuntimeException {

        // for academic purpose ... simulate an exception
        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        // add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);


        return myAccounts;
    }
}
