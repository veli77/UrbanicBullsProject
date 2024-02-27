@wip4
Feature: As a user, after entering valid information,I should be able to perform various actions in the Your products/services section

 #Background:  Given User goes to homepage
    #When User clicks on Login module
   # And User logs in
  @UI
  @Login2
  Scenario:The user should be able to go to the relevant page using the YourProducts_Services button
    When User click to YourProducts_Services btn at the button
    Then User must verify that the YourProducts_Services page appears


    @UI
    @Login2
    Scenario:User should be able to go to the previous page using the back button
      And user clicks the return button, it should return
      Then User must verify that the Home page appears



