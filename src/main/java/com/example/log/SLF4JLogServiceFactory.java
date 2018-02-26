package com.example.log;

import org.springframework.stereotype.Component;

@Component
public class SLF4JLogServiceFactory implements LogServiceFactory {

    @Override
    public LogService getLogService(String loggerName) {

        return new SLF4JLogService(loggerName);

    }
}
