package com.santander.bank.application.pagonxt.pages;

import com.santander.test.automation.config.TestScenario;
import com.santander.test.automation.core.BasePage;
import com.santander.test.automation.elements.PageElement;

import static com.santander.test.automation.types.ElementType.*;
import static com.santander.test.automation.types.LocatorType.ID;
import static com.santander.test.automation.types.LocatorType.XPATH;

public class MerchantOnBoardingPage extends BasePage {

    public MerchantOnBoardingPage(TestScenario testScenario) {
        super(testScenario, "Cognizant");
    }

    // --------------------------------------------------------------------------------------
    // Page elements
    public final PageElement emailText = new PageElement(driver,TEXT_BOX , "email", ID, "form-group--3", "476063@cognizant.com");

    public final PageElement continueButton = new PageElement(driver,BUTTON , "Continue", XPATH, "//button[@type='submit']", "476063@cognizant.com");

    public final PageElement ssoButton = new PageElement(driver, LINK , "Continue with SSO", XPATH, "//a[@class='ud-btn ud-btn-large ud-btn-primary ud-heading-md organization-login-sso-button--button--1ymWY']");
   // public final PageElement aptHousingLink = new PageElement(driver, LINK, "Apt/Housing link", LINK_TEXT, "apts / housing");

    // --------------------------------------------------------------------------------------

}
