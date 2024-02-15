@wip2
Feature:As a user, after entering valid information, I should be able to perform various actions in the Address section.
  Background: #Given User goes to homepage
    #When User clicks on Login module
   # And User logs in
    When User click to Address btn at the button
    Then User must verify that the Address page appears

  @UI
  @Login2
  Scenario: User should be able to go to the relevant page and add a new address using the My Sales Address button.
    When User click to My Sales Address btn at the button
    When User click to Add New Address btn at the button
    And  User must click on the add button that opens and enter a new address
    And  User must enter the posta zip code on the page that opens
    Then User must click on the submit button and confirm the incoming message