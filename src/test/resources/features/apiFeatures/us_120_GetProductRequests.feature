@US_120 @user3token @API
Feature: US_120 - Get Product Requests

  Scenario: TC_001 US_120 - Get Product Requests
    When User selects a certain hub
    And User gets product requests for a certain hub
    Then User verifies the status code and response content