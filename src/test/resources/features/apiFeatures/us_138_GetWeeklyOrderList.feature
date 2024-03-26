@US_138 @API
Feature: US_138 - Get Weekly Order List
  @user3token

  Scenario: Get Weekly Order List

    When User gets weekly order list
    Then User verifies status code and main keys for weekly order list