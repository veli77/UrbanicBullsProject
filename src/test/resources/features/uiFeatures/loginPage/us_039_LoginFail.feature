@UI
Feature: User Login

  Scenario: Invalid Login
    Given User goes to login page
    When  the Email address and password button is functional
    Then  the user enters an invalid email and password
    Then  the login should fail
    And   the system should display an error message for invalid credentials