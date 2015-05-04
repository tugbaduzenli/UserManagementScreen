package com.tugba.aop;

import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

/**
 * Created by tugba on 01.05.2015.
 */
public class TraceInterceptor  extends CustomizableTraceInterceptor {

    private static final long SERIALVERSIONUID = 287162721460370957L;
    protected static Logger LOGGER4J = Logger.getLogger("aop");

    @Override
    protected void writeToLog(Log logger, String message, Throwable ex) {
        if (ex != null) {
            LOGGER4J.debug(message, ex);
        } else {
            LOGGER4J.debug(message);
        }
    }

    @Override
    protected boolean isInterceptorEnabled(MethodInvocation invocation, Log logger) {
        return true;
    }
}