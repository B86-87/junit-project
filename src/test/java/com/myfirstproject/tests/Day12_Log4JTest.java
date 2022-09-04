package com.myfirstproject.tests;
import com.myfirstproject.Day12_Log4J;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day12_Log4JTest {

    private static Logger logger = LogManager.getLogger(Day12_Log4JTest.class.getName());

    @Test
    public void test(){
        logger.fatal("Fatal Log!");
        logger.error("Error Log!");
        logger.warn("Warning Log!");
        logger.debug("Debug Log!");
        logger.info("Info Log!");
    }
}
