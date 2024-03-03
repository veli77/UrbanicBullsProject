@BU-92 @Erdal @US-31
Feature: TE of US031 LinkedIn Btn is clickable

  	#*LinkedIn icon should be clickable and relevant page should be visible*
  @TEST_BU-91
  @UI
  Scenario: TC01_US031 LinkedIn Btn is clickable
    Given User goes to HomePage
    When User click the LinkedIn
    Then User should be able to click LinkedIn button