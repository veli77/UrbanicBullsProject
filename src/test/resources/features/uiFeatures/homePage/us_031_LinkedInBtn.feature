@BU-92
Feature: Test Execution of US031

  	#*LinkedIn icon should be clickable and relevant page should be visible*
  @TEST_BU-91
  @UI
  Scenario: TC01_US031 LinkedIn Btn is clickable
    Given User goes to HomePage
    When User click the LinkedIn
    Then User should be able to click LinkedIn button