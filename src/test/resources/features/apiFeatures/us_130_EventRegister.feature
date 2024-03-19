Feature: TE of US_130  As a user I should be able to register an existing event

  @userUrbanic2Token
  Scenario: TC_01 US_130 user should be able to register an existing event
    Given user connect to  "https://test.urbanicfarm.com/api/account/event/register"
    Then user verifies event register status code 200
