package com.santander.test.automation.elements;

import com.santander.test.automation.types.ElementType;
import com.santander.test.automation.types.LocatorType;
import com.santander.test.automation.util.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

/*
 *  author : Vikas Singh
 * */
public class PageElement {
    private String name;
    private LocatorType locatorType;
    private String locatorValue;
    private PageFrame pageFrame;
    private String testData;
    private final WebDriver driver;
    private ElementType elementType;

    private final Logger logger = LoggerFactory.getLogger(PageElement.class);

    public PageElement(WebDriver driver, ElementType elementType, String name, LocatorType locatorType, String locatorValue, PageFrame pageFrame, String testData) {
        this.driver = driver;
        this.elementType = elementType;
        this.name = name;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
        this.pageFrame = pageFrame;
        this.testData = testData;
    }

    public PageElement(WebDriver driver, ElementType elementType, String name, LocatorType locatorType, String locatorValue, PageFrame pageFrame) {
        this.driver = driver;
        this.elementType = elementType;
        this.name = name;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
        this.pageFrame = pageFrame;
    }

    public PageElement(WebDriver driver, ElementType elementType, String name, LocatorType locatorType, String locatorValue) {
        this.driver = driver;
        this.elementType = elementType;
        this.name = name;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
    }

    public PageElement(WebDriver driver, ElementType elementType, String name, LocatorType locatorType, String locatorValue, String testData) {
        this.driver = driver;
        this.elementType = elementType;
        this.name = name;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
        this.testData = testData;
    }

   /* private void switchToFrame() {
        driver.switchTo().defaultContent();
        if (pageFrame != null) {
            switch (pageFrame.getIdentificationType()) {
                case INDEX:
                    driver.switchTo().frame(pageFrame.getFrameIndex());
                    break;
                case WEB_ELEMENT:
                    driver.switchTo().frame(pageFrame.getFrameWebElement());
                    break;
                case LOCATOR:
                    driver.switchTo().frame(pageFrame.getFrameLocator());
                    break;
                default:
                    logger.error("Invalid choice for frame identification type '{}'");
                    throw new IllegalArgumentException("\"Invalid choice for frame identification type '" + pageFrame.getIdentificationType() + "'");
            }
        }
    }*/

    /*
     *
     * */
    private By getLocator() {
        switch (this.locatorType) {
            case XPATH:
                return By.xpath(this.locatorValue);
            case CSS:
                return By.cssSelector(this.locatorValue);
            case ID:
                return By.id(this.locatorValue);
            case NAME:
                return By.name(this.locatorValue);
            case LINK_TEXT:
                return By.linkText(this.locatorValue);
            case PARTIAL_LINK_TEXT:
                return By.partialLinkText(this.locatorValue);
            case CLASS_NAME:
                return By.className(this.locatorValue);
            case TAG_NAME:
                return By.tagName(this.locatorValue);
            default:
                logger.error("Invalid choice for locator type '{}'", locatorType);
                throw new IllegalArgumentException("Invalid choice for locator type '" + locatorType + "'");
        }
    }

    private List<WebElement> getWebElements() {
        //this.switchToFrame();
        return driver.findElements(getLocator());
    }

    public  void clickViaJavaScript(String elementName, By locator)
    {
            try
            {
                logger.debug(String.format("Clicking element '%s using Javascript'", elementName));
                WebElement ele = getWebElement();
                Point point = ele.getLocation();
                ((JavascriptExecutor)driver).executeScript("window.scroll("+point.getX()+","+(point.getY()-100)+")");
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
            }
            catch(AssertionError | Exception e)
            {
               e.getMessage();
            }

    }

    public void clickViaJavaScript(String elementName, WebElement ele)
    {
            try
            {
                logger.debug(String.format("Clicking element '%s'", elementName));
                Point point = ele.getLocation();
                ((JavascriptExecutor)driver).executeScript("window.scroll("+point.getX()+","+(point.getY()-100)+")");
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
            }
            catch(AssertionError | Exception e)
            {
               e.getMessage();
            }
    }

    public void getTextDropDownSelectedItem(String elementName, String framePath, By locator, boolean waitUntilDisplayed, boolean waitUntilEnabled) throws Exception
    {

        String selectedOption = "";

            try
            {
                String logMessage = String.format("Selected option of element '%s'", elementName);
                WebElement webElement = getWebElement(framePath, locator, waitUntilDisplayed, waitUntilEnabled, Duration.ofSeconds(100));
                selectedOption = new Select(webElement).getFirstSelectedOption().getText();

            }
            catch(TimeoutException e)
            {
                String errorMessage = String.format("Element '%s' is not displayed", elementName);
            }
            catch(AssertionError | Exception e)
            {
                String errorMessage = String.format("Element '%s' selected option vlaue is '%s'", elementName, selectedOption);
            }


    }

    private WebElement getWebElement(String framePath, By locator, boolean waitUntilDisplayed, boolean waitUntilEnabled, Duration timeoutSeconds) throws Exception
    {

        if (waitUntilDisplayed &&
                waitUntilEnabled)
        {
            waitForElementToBeDisplayedAndEnabled(locator, timeoutSeconds);
        }
        else if (waitUntilDisplayed)
        {
            waitForElementToBeDisplayed(locator, timeoutSeconds);
        }
        else
        {
            waitForElement(locator, timeoutSeconds);
        }

        return getElement(locator);
    }

    public void waitForElementToBeDisplayedAndEnabled(final By locator, Duration timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(this.driver, timeoutSeconds);
        /*
         * wait.until(new Predicate<WebDriver>() {
         *
         * @Override public boolean apply(WebDriver driver) { return
         * driver.findElement(locator).isDisplayed() &&
         * driver.findElement(locator).isEnabled(); } });
         */
    }

    public void waitForElementToBeDisplayed(final By locator, Duration timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(this.driver, timeoutSeconds);
        /*
         * wait.until(new Predicate<WebDriver>() {
         *
         * @Override public boolean apply(WebDriver driver) { return
         * driver.findElement(locator).isDisplayed(); } });
         */
    }

    public void waitForElement(final By locator, Duration timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(this.driver, timeoutSeconds);
        /*
         * wait.until(new Predicate<WebDriver>() {
         *
         * @Override public boolean apply(WebDriver driver) { return
         * driver.findElement(locator) != null; } });
         */
    }

    public  WebElement getElement(By locator) {
        return this.driver.findElement(locator);
    }


    private WebElement getWebElement() {
        //this.switchToFrame();
        return driver.findElement(getLocator());
    }

    public WebElement getObject() {
        return getWebElement();
    }

    public int getObjectsCount() {
        return getWebElements().size();
    }

    public List<WebElement> getObjects() {
        return getWebElements();
    }

    /*
     *
     * */
    public void enterValue() {
        putValue(testData, false);
    }

    public void enterValue(boolean isSecret) {
        putValue(testData, isSecret);
    }

    public void enterPassword() {
        putValue(testData, true);
    }

    public void enterValue(String value, boolean isSecret) {
        putValue(value, isSecret);
    }


    /*
     *
     * */
    public void selectByVisibleText(String value) {
        logger.debug("Trying to select value '{}' of element '{}' ", value, name);
        WebElement webElement = getWebElement();
        assert webElement != null;
        Select select = new Select(webElement);
        select.selectByVisibleText(value);
        logger.info("Selected value '{}' of element '{}' ", value, name);
    }

    public void selectByValueProperty(String value) {
        logger.debug("Trying to select value '{}' of element '{}' ", value, name);
        WebElement webElement = getWebElement();
        assert webElement != null;
        Select select = new Select(webElement);
        select.selectByValue(value);
        logger.info("Selected value '{}' of element '{}' ", value, name);
    }


    /*
     *
     * */
    public void clickIfPresent() {
        logger.debug("Trying to click on element '{}' of type '{}' ", name, elementType);
        List<WebElement> webElement = getWebElements();
        if (!webElement.isEmpty()) {
            waitUntilClickable();
            webElement.get(0).click();
            logger.info("Clicked element '{}' of type '{}'", name, elementType);
            return;
        }
        logger.info("Skipped to click element '{}' of type '{}', element was not present", name, elementType);
    }

    /*
     *
     * */
    public void click() {
        logger.debug("Trying to click on element '{}' of type '{}' ", name, elementType);
        WebElement webElement = getWebElement();
        assert webElement != null;
        waitUntilClickable();
        webElement.click();
        logger.info("Clicked element '{}' of type '{}'", name, elementType);
    }

    /*
     *
     * */
    public void doubleClick() {
        logger.debug("Trying to double click on element '{}' of type '{}' ", name, elementType);
        WebElement webElement = getWebElement();
        assert webElement != null;
        waitUntilClickable();
        Actions actions = new Actions(driver);
        actions.doubleClick(webElement);
        logger.info("Double clicked element '{}' of type '{}'", name, elementType);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLocatorType(LocatorType locatorType) {
        this.locatorType = locatorType;
    }

    public void setLocatorValue(String locatorValue) {
        this.locatorValue = locatorValue;
    }

    public void setPageFrame(PageFrame pageFrame) {
        this.pageFrame = pageFrame;
    }

    public void setTestData(String testData) {
        this.testData = testData;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public void waitUntilClickable(Duration maxTimeOutInSeconds) {
        Wait<WebDriver> wait = new WebDriverWait(driver, maxTimeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(this.getObject()));
    }



    public void waitUntilVisible(Duration maxTimeOutInSeconds) {
        Wait<WebDriver> wait = new WebDriverWait(driver, maxTimeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(this.getObject()));
    }

    /* ============================================ private methods ====================================================
     *
     * */
    private void putValue(String dataValue, boolean isSecret) {
        logger.debug("Trying to enter value '{}' in element '{}' of type '{}'", isSecret ? "*******" : dataValue, name, elementType);
        WebElement webElement = getWebElement();
        assert webElement != null;
        webElement.sendKeys(dataValue);
        logger.info("Entered value '{}' in element '{}' of type '{}'", isSecret ? "*******" : dataValue, name, elementType);
    }


    private void waitUntilVisible() {
        waitUntilVisible(Duration.ofDays(Utility.parseShortTestConfig("object.wait.time.reliable")));
    }

    private void waitUntilClickable() {
        waitUntilClickable(Duration.ofDays(Utility.parseShortTestConfig("object.wait.time.reliable")));
    }

}
