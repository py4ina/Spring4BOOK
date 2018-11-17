package com.apress.log;

import org.apache.log4j.Logger;

public class LoggerRunner {
    final static Logger logger = Logger.getLogger(LoggerRunner.class);

    public static void main(String[] args) {
        logger.info("info");
        logger.error("error");
    }
}
