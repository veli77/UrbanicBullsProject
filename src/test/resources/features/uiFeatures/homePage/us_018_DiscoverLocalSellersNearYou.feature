Feature: US_018

  @UI
  Scenario: US_018 - - User should be able to perform various operations on homepage
    Given User goes to homepage
    When User clicks on the Discover Local Sellers Near You button
    Then User is able to reach to relevant page of Local Sellers
