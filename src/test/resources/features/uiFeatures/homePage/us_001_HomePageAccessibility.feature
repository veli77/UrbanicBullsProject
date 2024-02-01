Feature: Home Page Accessibility

  Scenario: User accesses the home page successfully
    Given User goes to homepage
    Then home page should load successfully without errors
    And user should see the main content of the home page
