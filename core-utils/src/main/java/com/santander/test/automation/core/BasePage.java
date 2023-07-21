package com.santander.test.automation.core;

import com.santander.test.automation.config.TestConfig;
import com.santander.test.automation.config.TestScenario;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

/*
 *  author : Vikas Singh
 * */
public abstract class BasePage {
    protected WebDriver driver;
    private final TestScenario testScenario;
    private final String pageTitle;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected BasePage(TestScenario testScenario, String pageTitle) {
        this.testScenario = testScenario;
        this.driver = testScenario.getDriver();
        this.pageTitle = pageTitle;
    }

    public TestScenario getTestScenario() {
        return testScenario;
    }

    public void navigateTo(URL url) {
        this.driver.navigate().to(url);
    }

    public void navigateTo(String fullURL) throws MalformedURLException {
        navigateTo(new URL(fullURL));
    }

    public void navigateToApplication() throws MalformedURLException {
        navigateTo(new URL(TestConfig.getConfig("application_url")));
    }

    protected void maximise() {
        driver.manage().window().maximize();
    }

    protected void closeAndQuitBrowser() {
        driver.close();
        driver.quit();
    }

    protected void closeBrowserWindow() {
        driver.close();
    }

    // TODO - Implement this
    protected void closeBrowserWindowByIndex(int index) {
    }

    //TODO - Implement this
    protected void closeLastBrowserWindow() {
    }

    /*protected void getAlertBoxText() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Utility.parseIntTestConfig("object.wait.time.macro"));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().getText();
    }*/

    protected String getPageTitle() {
        return null;
    }

    public boolean isValidPage() {
        String title = driver.getTitle();
        if (!title.contains(pageTitle)) {
            logger.error("Page title : actual '{}' contains/equals expected '{}', Checks for contains", title, pageTitle);
            return false;
        }
        logger.info("Page title : actual '{}' contains/equals expected '{}', Checks for contains", title, pageTitle);
        return true;
    }

    public void cucumberResultLog(String logMessage) {
        testScenario.cucumberResultLog(logMessage);
    }
}
