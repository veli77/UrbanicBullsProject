Feature: US_012
@UI
  Scenario: US_012 -  User should be able to perform various operations on homepage
    Given User goes to homepage
    Then Backyard gardeners and farmers join the Movement For Free! is visible
    When User clicks on the Register Now button
    Then User is able to reach to relevant Register Now Page