@US_108 @API
Feature: US_108 Changing Delivery Modalities for Pick Up From Branch

  @user3token
  Scenario: User should be able to change availability for pick up from branch
    Given User gets and changes the delivery modalities for pick up from branch
    Then User verifies that delivery modalities have been changed