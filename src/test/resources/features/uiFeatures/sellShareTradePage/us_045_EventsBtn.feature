Feature: us_045
  Scenario: Events should be clickable and relevant page should be visible
    Given User goes to login page
    When User logs in
    Then User clicks on Events button
    And  User verifies that the Events page has been opened