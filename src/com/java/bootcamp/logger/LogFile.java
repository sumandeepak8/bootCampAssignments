package com.java.bootcamp.logger;

public class LogFile implements Loggable {

    public String log(String text) {
        return text + " from LogFile";
    }
}
