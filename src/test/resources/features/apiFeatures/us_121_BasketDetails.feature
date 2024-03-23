@US_121   @user3token @API
Feature: US_121 As a user, I should be able to get basket details.

  Scenario: Get Basket Details
    When User gets basket details
    Then User verifies status code and basket details