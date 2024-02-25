@BU-254
Feature: TE of US_067 Welcome Page actions
  @TEST_BU-252
  @US_067 @UI @Login
  Scenario: TC01 Of US_067 I should be able to perform various actions in the Welcome Page

    Given User goes to the Welcome Page
    Then User should be able to click seller rating
    Then User is able to see selected option after select any select rating
    Then User should be able to click product rating
    Then User is able to see selected option after select any product rating

