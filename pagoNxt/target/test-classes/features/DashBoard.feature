@MerchantOnBoarding
Feature: Testing the Merchant On-boarding Journey

  Background:
    Given user is at home page
    Given user click the SSO button on home page
    And User is on "Login" page

  @MERCH-001 @Tryout
  Scenario: Validating that an Merchant On-boarding record is generated when a Large Enterprise is created by an Operator
  GET /audit
    When User is navigate to "Dashboard Page"
