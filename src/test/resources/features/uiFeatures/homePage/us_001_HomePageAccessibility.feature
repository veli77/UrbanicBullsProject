@BU-1 @smoke
@UI
Feature: Home Page Accessibility

  #The home page must be accessible when the URL is entered
  @TEST_BU-52
  Scenario: User accesses the home page successfully
    Given User goes to homepage
    Then home page should load successfully without errors
    And user should see the main content of the home page
