@UI
@smoke
Feature: US_038 - As a user I should be able to login with my account

  Scenario: As a user I should be able to login with my account
    Given User goes to homepage
    Then User goes to login page
    Given Email address and password buttons are functional
    Then User enters valid email and password
    Then User successfully logs in after valid information is entered