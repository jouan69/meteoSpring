package com.example.log;

/**
 * Created by erwanjouan on 24/02/2018.
 */
public interface LogServiceFactory {

    LogService getLogService(String loggerName);

    default LogService getLogService(Class<?> loggerByClassName){
        return getLogService(loggerByClassName.getClass());
    }
}
