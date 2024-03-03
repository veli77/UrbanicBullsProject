@Erdal @US_100 @API
Feature: TE of US_100 Login

  Scenario: TC_01 US_100 Login feature
    Given user connect to the "https://test.urbanicfarm.com/api/public/login"
    Then user verifies status code 200