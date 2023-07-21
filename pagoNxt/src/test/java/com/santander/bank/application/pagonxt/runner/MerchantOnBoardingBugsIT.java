package com.santander.bank.application.pagonxt.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@MerchantOnBoarding and not @Ignore",
        glue = "com.santander.bank.application.pagonxt",
        plugin = {"pretty",
                "json:target/cucumber-html-reports/json/merchantOnboardingResultsBugs.json",
                "html:target/cucumber-html-reports/html/merchantOnboardingResultsBugs.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class MerchantOnBoardingBugsIT {
}