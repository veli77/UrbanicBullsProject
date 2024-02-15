@BU-111
Feature: US-008 Nav Bar Login btn feature

  #Login should be clickable and relevant page should be visible
  @008
  @veli
  @UI
  @TEST_BU-110 @TESTSET_BU-61
  Scenario: User should be able to perform various operations on homepage
    Given User goes to homepage
    When User click to "Login" btn at the navbar
    Then User should be able to see Login page
