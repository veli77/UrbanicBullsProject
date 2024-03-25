Feature: TE of US_130  As a user I should be able to register an existing event


  Scenario: TC_01 US_130 user should be able to register an existing event
    Given user connect to  "https://test.urbanicfarm.com/api/account/event/register"
    Then Status code is 200
    And description is successful
