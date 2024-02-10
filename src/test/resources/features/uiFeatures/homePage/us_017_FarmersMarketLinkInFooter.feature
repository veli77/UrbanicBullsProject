@BU-17
@UI
Feature: Farmers Market Link in Footer
  #User should be able to perform various operations on homepage
  @TEST_BU-83
  Scenario: Explore (Button)-Footer Farmers Market should be clickable and relevant page should be visible
    Given User goes to homepage
    When the user scrolls to the bottom of the page
    And the user clicks on the Farmers Market link in the footer
    Then User must verify that the Farmers Market page appears
