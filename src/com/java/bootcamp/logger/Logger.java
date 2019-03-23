package com.java.bootcamp.logger;

class Logger {
    String log(String text, Loggable loggerType) {
        return loggerType.log(text);
    }
}
