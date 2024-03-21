@US_114 @API
Feature: US_114 - Get Hub Information

  Scenario: Get Hub Information

    Given User connects to the "https://test.urbanicfarm.com/api/public/login"
    When User gets hub information details
    Then User verifies status code and hub information details
    Then User gets first hub information and verifies it