package com.santander.bank.application.pagonxt.steps;

import com.santander.bank.application.pagonxt.pages.MerchantOnBoardingPage;
import com.santander.test.automation.config.TestScenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class MerchantOnBoardingSteps {

    private final MerchantOnBoardingPage merchantOnBoardingPage;

    public MerchantOnBoardingSteps(TestScenario testScenario) {
        merchantOnBoardingPage = new MerchantOnBoardingPage(testScenario);
    }

    @Given("^user is at home page$")
    public void userIsOnHomePage() throws MalformedURLException {
        merchantOnBoardingPage.navigateToApplication();
    }

    @Given("^user click the SSO button on home page$")
    public void userClickSSOButtonIsOnHomePage()  {

        merchantOnBoardingPage.emailText.enterValue();
        merchantOnBoardingPage.continueButton.enterValue();
    }

    @Given("User is on {string} page")
    public void user_is_on_page(String string) {
        merchantOnBoardingPage.ssoButton.click();

       // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/../utils/src/main/resources/drivers/"+"chromedriverMac");
       // WebDriverManager.chromedriver().setup();
       // System.out.println(" chrome.getProperty " +  System.getProperty("webdriver.chrome.driver"));
       // WebDriver driver = new ChromeDriver();
       // driver.manage().window().maximize();
       // driver.get("https://cognizant.udemy.com/course/cucumber-bdd-masterclass/learn/lecture/28973260#notes");

       // System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/../utils/src/main/resources/drivers/"+"geckodriverMac");
       /* WebDriverManager.firefoxdriver().setup();
        System.out.println(" gecko.getProperty " +  System.getProperty("webdriver.gecko.driver"));
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.es/");*/

        //driver.quit();
    }

    @When("User is navigate to {string}")
    public void user_is_navigate_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        //homePage.ssoButton.click();
    }


}
