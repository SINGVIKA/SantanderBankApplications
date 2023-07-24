package com.santander.test.automation.config;

import com.santander.test.automation.exception.FrameworkException;
import com.santander.test.automation.util.Utility;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/*
 *  author : Vikas Singh
 * */
public final class TestScenario {
    private Scenario scenario;
    private final WebDriver driver;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public TestScenario() {
        this.driver = new DriverUtil().getDriverInstance();
    }

    public void setCucumberScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeAndQuitBrowser() {
        driver.close();
        driver.quit();
    }

    private void takeScreenShot() {
        final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenShot, "image/png", Utility.getScreenshotFileName());
    }

    public void cucumberResultLog(String logMessage) {
        scenario.log(logMessage);
    }

    public void attachScreenShotToCucumberResult() {
        takeScreenShot();
    }
}
