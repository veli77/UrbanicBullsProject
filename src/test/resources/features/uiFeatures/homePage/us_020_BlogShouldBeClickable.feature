@UIOZLEM
  @UI
Feature: US_020


  Scenario: US_020 - Blog should be clickable and relevant page should be visible
    Given User goes to homepage
    When User clicks on the explore blog button
    Then User should be redirected to the Blog page
    And User should see relevant content on the Blog page