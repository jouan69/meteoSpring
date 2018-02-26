package com.example.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;

import java.util.function.Supplier;

public class SLF4JLogService implements LogService {

    private final Logger logger;

    protected SLF4JLogService(String loggerName){
        this.logger = LoggerFactory.getLogger(loggerName);
    }

    @Override
    public void log(LogLevel logLevel, Supplier<String> msg, Throwable ex) {
        switch (logLevel){
            case TRACE:
                this.logger.trace(msg.get(), ex);
                break;
            case DEBUG:
                this.logger.debug(msg.get(), ex);
                break;
            case INFO:
                this.logger.info(msg.get(), ex);
                break;
            case WARN:
                this.logger.warn(msg.get(), ex);
                break;
            case ERROR:
                this.logger.error(msg.get(), ex);
                break;
            case FATAL:
                this.logger.error(msg.get(), ex);
                break;
            case OFF:
                break;
        }
    }
}