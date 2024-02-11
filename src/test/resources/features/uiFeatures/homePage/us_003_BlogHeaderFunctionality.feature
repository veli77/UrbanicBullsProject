@BU-3
@UI
Feature: Blog Header Verification
  #User should be able to perform various operations on homepage
  @TEST_BU-81
  Scenario: Blog should be clickable and relevant page should be visible.
    Given User goes to homepage
    When the user clicks on the Blog header
    Then the user should be redirected to the Blog page
    And the user should see relevant content on the Blog page