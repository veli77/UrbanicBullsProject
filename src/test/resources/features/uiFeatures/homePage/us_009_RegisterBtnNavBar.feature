@BU-113
Feature: US-009 Nav Bar Register btn feature

  #Register should be clickable and relevant page should be visible
  @veli
  @UI
  @TEST_BU-112
  @009
  Scenario: User should be able to perform various operations on homepage
    Given User goes to homepage
    When User click to "Register" btn at the navbar
    Then User should be able to see Register page
