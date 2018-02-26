package com.example.log;


import org.springframework.boot.logging.LogLevel;

import java.util.function.Supplier;

public interface LogService {

    void log(LogLevel logLevel, Supplier<String> msg, Throwable ex);

    default void debug(Supplier<String> msg, Throwable ex){
        log(LogLevel.DEBUG, msg, ex);
    }

    default void info(Supplier<String> msg, Throwable ex){
        log(LogLevel.INFO, msg, ex);
    }

    default void error(Supplier<String> msg, Throwable ex){
        log(LogLevel.ERROR, msg, ex);
    }

}
