@UI
Feature: US_035 - Controlling the Functionality of Password under RegisterPage
  Background:
    Given User goes to homepage
    Then User goes to Register Page
    Then User enters a valid first name, last name, and email address

  Scenario: US_035 - Password section should not be left blank
    When User leaves the password blank and submits the registration form
    Then An alert appears to fill out the password section

  Scenario Outline: US_035 - Invalid password should be alerted
    When User enters an invalid password "<password>" which is not in line with requirements
    And User submits the registration form
    Then An alert which requires a relevant format should appear on the screen

    Examples:
      | password   |
      | Abcdefgh   |
      | 1234567a   |
      | 1234567A   |
      | Abc123     |

  Scenario: US_035 - Confirm password and initial password does not match
    When User enters a confirm password which does not match the initial password
    And User submits the registration form
    Then An alert appears to match the confirm password with the initial one

  Scenario: US_035 - Confirm password and initial password matches and registration succesfully finishes
    When User enters a confirm password which matches the initial password
    And User submits the registration form
    Then User successfully registers after valid information is entered