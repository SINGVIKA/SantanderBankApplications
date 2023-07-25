package com.santander.bank.application.pagonxt.steps;

import com.santander.bank.application.pagonxt.pages.MerchantOnBoardingPage;
import com.santander.test.automation.config.TestScenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
    @Given("user passed the Login details on home page")
    public void userPassedTheLoginDetailsOnHomePage() {
        merchantOnBoardingPage.userNameText.enterValue();
        merchantOnBoardingPage.passwordText.enterValue();
    }

    @Given("^user click the Login button on home page$")
    public void userClickSSOButtonIsOnHomePage()  {
        merchantOnBoardingPage.continueButton.click();
        merchantOnBoardingPage.launchPortal.click();
        merchantOnBoardingPage.caseManager.click();
        merchantOnBoardingPage.switchWindow();
        merchantOnBoardingPage.newOnboarding.click();
        merchantOnBoardingPage.searchCustomer.enterValue();
        merchantOnBoardingPage.searchButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        merchantOnBoardingPage.createNewMerchantButton.click();
        merchantOnBoardingPage.LegalID.enterValue();
        merchantOnBoardingPage.groupConnectedClient.enterValue();
        merchantOnBoardingPage.entityType.click();
        merchantOnBoardingPage.entityTypeValueDropDown.click();
        merchantOnBoardingPage.industryCategory.click();
        merchantOnBoardingPage.industryCategoryValue.click();
        merchantOnBoardingPage.mccClassification.enterValue();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        merchantOnBoardingPage.countryOfIncorporation.enterValue();
        merchantOnBoardingPage.entityOverview.enterValue();
        merchantOnBoardingPage.registeredAddressCountry.enterValue();
        merchantOnBoardingPage.registeredAddressAddressLine1.enterValue();
        merchantOnBoardingPage.registeredAddressAddressLine2.enterValue();
        merchantOnBoardingPage.registeredAddressCityOrTown.enterValue();
        merchantOnBoardingPage.registeredAddressStateCode.enterValue();
    }

    @Given("User is navigate to {string} page")
    public void userIsNavigateToPage(String string) {
        // Write code here that turns the phrase above into concrete actions
        ////throw new io.cucumber.java.PendingException();
    }

    @Given("User is on {string} page")
    public void user_is_on_page(String string) {
       // merchantOnBoardingPage.ssoButton.click();

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

    @When("User clicks on {string}")
    public void userClicksOn(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("User enters the data in search field")
    public void userEntersTheDataInSearchField() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("User clicks on search button")
    public void userClicksOnSearchButton() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User should see the New entity page")
    public void userShouldSeeTheNewEntityPage() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Then("User selects result from {string}")
    public void userSelectsResultFrom(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User should see the MCC classification code")
    public void userShouldSeeTheMCCClassificationCode() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User selects the {string}")
    public void userSelectsThe(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User enters the {string}")
    public void userEntersThe(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User selects the checkbox")
    public void userSelectsTheCheckbox() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User should see the Main business address")
    public void userShouldSeeTheMainBusinessAddress() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User should select results from the {string}")
    public void userShouldSelectResultsFromThe(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User should eneter {string}")
    public void userShouldEneter(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User should enter {string}")
    public void userShouldEnter(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User should select {string}")
    public void userShouldSelect(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User should enter data in search field")
    public void userShouldEnterDataInSearchField() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User selects result from search field")
    public void userSelectsResultFromSearchField() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User should see First name")
    public void userShouldSeeFirstName() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User should see last name")
    public void userShouldSeeLastName() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User should see ID")
    public void userShouldSeeID() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User should see Phone number type")
    public void userShouldSeePhoneNumberType() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Then("User should see the Primary email")
    public void userShouldSeeThePrimaryEmail() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User should see the Preferred method of contact")
    public void userShouldSeeThePreferredMethodOfContact() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("User selects {string}")
    public void userSelects(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @When("User is navigate to {string}")
    public void user_is_navigate_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        ////throw new io.cucumber.java.PendingException();
        //homePage.ssoButton.click();
    }

    @Then("User enters {string}")
    public void userEnters(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

}
