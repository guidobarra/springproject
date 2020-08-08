package com.guba.springaop.dao;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Component
public class TrafficFortuneDAO {

    private final Logger LOGGER = Logger.getLogger(getClass().getName());

    public String getFortune() {
        // simulate a delay

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Expect heavy traffic this morning";
    }

    public String getFortune(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("Major accident! Highway is closed");
        }

        return "Expect heavy traffic this morning";
    }

    public String getFortune(Boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("Major accident! Highway is closed");
        }

        return "Expect heavy traffic this morning";
    }
}
