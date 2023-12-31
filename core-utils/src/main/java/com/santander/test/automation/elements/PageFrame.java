package com.santander.test.automation.elements;

import com.santander.test.automation.types.FrameIdentificationType;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 *  author : Vikas Singh
 * */
public class PageFrame {
    private String locator;
    private int index;
    private WebElement webElement;
    private FrameIdentificationType identificationType;

    private final Logger logger = LoggerFactory.getLogger(PageFrame.class);

    public PageFrame(String locator) {
        this.locator = locator;
        this.identificationType = FrameIdentificationType.LOCATOR;
    }

    public PageFrame(int index) {
        this.index = index;
        this.identificationType = FrameIdentificationType.INDEX;
    }

    public PageFrame(WebElement webElement) {
        this.webElement = webElement;
        this.identificationType = FrameIdentificationType.WEB_ELEMENT;
    }

    private void validateLocatorType(FrameIdentificationType identificationType) {
        if (this.identificationType != identificationType) {
            logger.error("Write error message and throw error/exception that invalid method called and currently set locator is of type {}", this.identificationType);
        }
    }

    public FrameIdentificationType getIdentificationType() {
        return this.identificationType;
    }

    public int getFrameIndex() {
        validateLocatorType(FrameIdentificationType.INDEX);
        return index;
    }

    public WebElement getFrameWebElement() {
        validateLocatorType(FrameIdentificationType.WEB_ELEMENT);
        return webElement;
    }

    public String getFrameLocator() {
        validateLocatorType(FrameIdentificationType.LOCATOR);
        return locator;
    }
}
