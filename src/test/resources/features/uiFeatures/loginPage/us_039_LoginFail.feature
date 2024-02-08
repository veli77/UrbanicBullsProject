@UI @US_039
Feature: US_039

  Scenario Outline: Invalid Login
    Given Users go to login page
    When  the Email address and password button is functional
    Then  the user enters an invalid email as "<email>" and password as "<password>"
    And   the system should display an error message for invalid credentials

    Examples:
      | email              | password |
      |                    |          |
      |                    | abc1234  |
      | abcde123@gmail.com |          |
      | abcde123@gmail.com | abc1234  |