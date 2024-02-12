@BU-165 @Arif
Feature: Bottom Bar About Us btn feature

  #About Us should be clickable and relevant page should be visible
  @UI
  @TEST_BU-150
  Scenario: User should be able to perform various operations on homepage
    Given User goes to homepage
    When User click to About Us btn at the bottom
    Then User must verify that the About Us page appears