package com.santander.bank.application.pagonxt.pages;

import com.santander.test.automation.config.TestScenario;
import com.santander.test.automation.core.BasePage;
import com.santander.test.automation.elements.PageElement;

import java.util.Set;

import static com.santander.test.automation.types.ElementType.*;
import static com.santander.test.automation.types.LocatorType.*;

public class MerchantOnBoardingPage extends BasePage {

    public MerchantOnBoardingPage(TestScenario testScenario) {
        super(testScenario, "Cognizant");
    }

    // --------------------------------------------------------------------------------------
    // Page elements
    public final PageElement userNameText = new PageElement(driver,TEXT_BOX , "UserID", ID, "txtUserID", "vikas.singh9@cognizant.com");

    public final PageElement passwordText = new PageElement(driver,TEXT_BOX , "Password", ID, "txtPassword", "rules123#");

    public final PageElement continueButton = new PageElement(driver,BUTTON , "Login", XPATH, "//button[@id='sub']");

    public final PageElement launchPortal = new PageElement(driver,BUTTON , "LaunchPortal", XPATH, " //a[@data-test-id='20140927131516034349915']");

    public final PageElement caseManager = new PageElement(driver,BUTTON , "caseManager", XPATH, "//li[@data-test-id='202005071302360405991_1']");

    public final PageElement newOnboarding = new PageElement(driver,BUTTON , "newOnboarding", XPATH, "//button[@data-test-id='201602221219020476165346']");

    public final PageElement searchCustomer = new PageElement(driver,TEXT_BOX , "searchCustomer", XPATH, "//input[@id='a9aa989a']", "Inditex");

    public final PageElement searchButton = new PageElement(driver,BUTTON , "searchButton", XPATH, "//i[@data-test-id='201705040713210415117486']");

    public final PageElement createNewMerchantButton = new PageElement(driver,LINK , "createNewMerchantButton", XPATH, "//a[@data-test-id='201703150151220238122152' and @name='SearchOnboardCustomer_pyWorkPage_36']");


    public final PageElement LegalID = new PageElement(driver,TEXT_BOX , "LegalID", XPATH, "//input[@data-test-id='202112031205210088503']", "Y8467783F");

    public final PageElement groupConnectedClient = new PageElement(driver,TEXT_BOX , "Group Connected Client", XPATH, "//input[@data-test-id='202112031203310474217']", "Y8467783F");

    public final PageElement entityType = new PageElement(driver,DROP_BOX , "Entity type", XPATH, "//select[@data-test-id='20151210005355017643327']");

    public final PageElement entityTypeValueDropDown = new PageElement(driver,DROP_BOX , "Entity type value", XPATH, "//option[@value='ENTY29']");

    public final PageElement industryCategory = new PageElement(driver,DROP_BOX , "Industry Category", XPATH, "//select[@data-test-id='20220117154628043472']");

    public final PageElement industryCategoryValue = new PageElement(driver,DROP_BOX , "Industry Category value", XPATH, "//option[@value='A']");

    public final PageElement mccClassification = new PageElement(driver,TEXT_BOX , "MCC Classification", XPATH, "//input[@id='f6c78c12' and @data-test-id='202109021143240101582']", "Agricultural Co -operatives");

    public final PageElement mccClassificationValue = new PageElement(driver,DROP_BOX , "MCC Classification value", XPATH, "//tr[@id='$PD_GetMCCNameForIndustry_pa1808016990146699pz$ppxResults$l2']", "Agricultural Co -operatives");

    public final PageElement countryOfIncorporation = new PageElement(driver,TEXT_BOX , "Country of incorporation", XPATH, "//input[@data-test-id='20151106055427054262546']", "Spain");

    public final PageElement countryOfIncorporationValue = new PageElement(driver,DROP_BOX , "Country of incorporation value", XPATH, "//div[@id='po0' and @data-harness-id='HID13E981A86CCBD0BD93DFABD368473AE6']", "Spain");

    public final PageElement entityOverview = new PageElement(driver,TEXT_BOX , "Entity overview", XPATH, "//textarea[@data-test-id='20160222070237062651678']", "Entity overview");

    public final PageElement registeredAddressCountry = new PageElement(driver,TEXT_BOX , "Registered Address Country", XPATH, "//input[@data-test-id='201511100010300682162122' and @id='2917a05a']", "Spain");

    public final PageElement registeredAddressCountryValue = new PageElement(driver,DROP_BOX , "Registered Address Country Value", XPATH, "//div[@id='po0' and @data-harness-id='HID13E981A86CCBD0BD93DFABD368473AE6']", "Australia");

    public final PageElement registeredAddressAddressLine1 = new PageElement(driver,TEXT_BOX , "Registered Address Line 1", XPATH, "//input[@data-test-id='201511100010300680160466' and @id='8e8a3c50']", "C. del Capitán Blanco Argibay, 29");

    public final PageElement registeredAddressAddressLine2 = new PageElement(driver,TEXT_BOX , "Registered Address Line 2", XPATH, "//input[@data-test-id='20151110001030068416495' and @id='17836dea']", "1'D Floor");

    public final PageElement registeredAddressCityOrTown = new PageElement(driver,DROP_BOX , "Registered Address City", XPATH, "//input[@data-test-id='201511100010300683163363' and @id='89363973']", "VICTORIA");

    public final PageElement registeredAddressStateCode = new PageElement(driver , DROP_BOX, "Registered Address State Code", XPATH, "//select[@data-test-id='201511100010300685165611' and @id='5a631eb2']","VICTORIA");

    public final PageElement registeredAddresPostalCode = new PageElement(driver,DROP_BOX , "Registered Address Postal Code", XPATH, "//input[@data-test-id='201511100010300681161634' and @id='8f5ac7c0']", "201001");

    // public final PageElement aptHousingLink = new PageElement(driver, LINK, "Apt/Housing link", LINK_TEXT, "apts / housing");

    // --------------------------------------------------------------------------------------

    public void switchWindow()  {
        // String currentHandle = driver.getWindowHandle();
        // Set<String> handles = driver.getWindowHandles();
        //
        // for (String handle : handles)
        // {
        // if (!handle.equals(currentHandle))
        // {
        // driver.switchTo().window(handle);
        // break;
        // }
        // }
        //
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Set<String> handles = this.driver.getWindowHandles();
        // String handle = "";
        this.driver.switchTo().window((String) handles.toArray()[handles.size() - 1]);
        // Thread.sleep(3000);
    }

}
