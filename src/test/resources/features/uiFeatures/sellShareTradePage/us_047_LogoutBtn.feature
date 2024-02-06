
Feature: Button Bar Logout btn feature

  @UI @Login
  Scenario:As a user, after entering valid information, I should be able to perform various operations on the Sale-Pay-Trade page.
    Given User goes to homepage
    When User clicks on Login module
    And User logs in
    When User clicks on Sell-Share-Trade module
    And User clicks on Logout module
    Then Verifies that the user has returned to the home page