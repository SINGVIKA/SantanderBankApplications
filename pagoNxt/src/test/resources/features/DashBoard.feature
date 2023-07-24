@MerchantOnBoarding
Feature: Testing the Merchant On-boarding Journey

  Background:
    Given user is at home page
    And user passed the Login details on home page
    And user click the Login button on home page

  @Scenario-001 @Tryout
  Scenario: Customer creates a new onboarding
    When User clicks on "New Onboarding"
    And User enters the data in search field
    And User clicks on search button
    And User clicks on "create new"
    Then User should see the New entity page
    And User enters "customer name"
    And User enters "legal ID"
    And User enters "Group connect client"
    And User enters "Entity type"
    And User selects result from "Industry Category"
    And User selects result from "MCC Classification"
    Then User should see the MCC classification code
    And User selects result from "Country of oncorporation"
    And User enters "Address line 1"
    And User enters "Address line 2"
    And User selects result from "City/Town"
    And User selects the "State Code"
    And User enters the "Postal Code"
    And User selects the checkbox
    Then User should see the Main business address
    And User should select results from the "Country"
    And User should eneter "Address line 1"
    And User should enter "Address line 2"
    And User should enter "City/Town"
    And User should select "State Code"
    And User should enter "Postal Code"
    And User should enter data in search field
    And User selects result from search field
    Then User should see First name
    And User should see last name
    And User should see ID
    And User should see Phone number type
    And User selects result from "Phone Prefix"
    And user enters "Phone Number"
    And User should see the Primary email
    And User should see the Preferred method of contact
    When User selects "Add Primary Nationality"
    And User selects "Nationality"
    When User clicks on "Next"

