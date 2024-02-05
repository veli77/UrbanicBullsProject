@UI @US_039
Feature: User Login

  Scenario Outline: Invalid Login
    Given User goes to login page
    When  the Email address and password button is functional
    Then  the user enters an invalid email as "<email>" and password as "<password>"
    And   the system should display an error message for invalid credentials

    Examples:
      | email              | password |
      |                    |          |
      |                    | abc1234  |
      | abcde123@gmail.com |          |
      | abcde123@gmail.com | abc1234  |