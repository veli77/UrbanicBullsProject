
Feature: Button Bar YourProducts_Services btn feature

  @UI
  @Login2
  Scenario: As a user, after entering valid information,I should be able to perform various actions in the Your products/services section
   # Given User goes to homepage
    #When User clicks on Login module
   # And User logs in
    When User click to YourProducts_Services btn at the button
    Then User must verify that the YourProducts_Services page appears
    And user clicks the return button, it should return
    Then User must verify that the Home page appears




