package com.java.bootcamp.logger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    @Test
    void shouldReturnGivenLogMsgFromLogFile() {
        Logger logger = new Logger();
        String text = "This is some text";
        String actual = logger.log(text, new LogFile());
        String expected = "This is some text from LogFile";
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnGivenLogMsgFromConsole() {
        Logger logger = new Logger();
        String text = "This is some text";
        String actual = logger.log(text,new Console());
        String expected = "This is some text from console";
        assertEquals(expected, actual);
    }
}