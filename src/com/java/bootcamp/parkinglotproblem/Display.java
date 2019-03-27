package com.java.bootcamp.parkinglotproblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Display {
    private static Display ourInstance = new Display();

    public static Display getInstance() {
        return ourInstance;
    }

    Map<String, Integer> parkingLotsDetail = new HashMap<>();

    String showDisplay() {
        return "";
    }
}
