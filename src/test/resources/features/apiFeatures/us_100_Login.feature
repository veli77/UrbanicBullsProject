@Erdal @US_100 @API
Feature: Login

  Scenario: Login feature
    Given user connect to the "https://test.urbanicfarm.com/api/public/login"
    Then user verifies status code 200