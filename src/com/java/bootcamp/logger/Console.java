package com.java.bootcamp.logger;

public class Console implements Loggable{
    public String log(String text) {
        return text+ " from console";
    }
}
