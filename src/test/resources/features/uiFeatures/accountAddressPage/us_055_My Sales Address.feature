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
    And User must click on submit button
    Then User must verify the address saved message

    Scenario: User must verify that the address editing and removal buttons in the My Sales Address section are functional.
    When User goes to the address page and clicks the edit button
    Then the user verifies that the address details page has opened
    When user clicks Cansel button and returns
    When the user goes to the address page and clicks the remove button
    Then "Are you sure to delete the address?" confirms that the screen is turned on

  Scenario: Removing Sales Address
    Given I am on the Address section of the application
    When I click on the "Remove" button in the My Sales Address section
    Then I should see the confirmation screen "Are you sure to delete the address?"
    When I click on the "No" option
    Then the removal operation should be canceled
    When I click on the "Remove" button again
    And I click on the "Yes" option
    Then the Sales Address should be successfully deleted