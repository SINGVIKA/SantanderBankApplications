package com.santander.test.automation.core;

import com.santander.test.automation.config.TestConfig;
import com.santander.test.automation.exception.FrameworkException;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com.vikas.lib.core"})
public class BaseJunitRunner {
    private static final Logger logger = LoggerFactory.getLogger(BaseJunitRunner.class);

    @BeforeClass
    public static void validateTestConfig() {
        try {
            File file = new File(BaseJunitRunner.class.getClassLoader().getResource("TestConfig.properties").getFile());
            if (file.exists()) {
                logger.debug("Found TestConfig.properties file");
            }
        } catch (Exception e) {
            logger.error("Could not find 'TestConfig.properties' file in TestSuite test->resources folder");
            System.exit(1);
        }

        try {
            TestConfig.getConfig("NO_PROPERTY");
        } catch (FrameworkException e) {
            e.printStackTrace();
            logger.error("Stopping test suite execution : reason : {} ", e.getMessage());
            System.exit(1);
        }
    }
}
