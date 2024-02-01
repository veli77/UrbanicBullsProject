Feature: Home Page Accessibility

  Scenario: User accesses the home page successfully
    Given the user is on the home page
    Then the home page should load successfully without errors
    And the user should see the main content of the home page
