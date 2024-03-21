@US_103 @API
Feature: US_103 Changing Phone Number of the User

  Scenario: User should be able to change phone number associated with the account
    Given User connects to the site
    When User changes the phone number
    Then User verifies that phone number has been changed