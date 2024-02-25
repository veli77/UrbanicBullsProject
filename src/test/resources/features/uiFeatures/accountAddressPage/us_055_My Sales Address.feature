@wip2
Feature:As a user, after entering valid information, I should be able to perform various actions in the Address section.

  Background:
    #Given User goes to homepage
    #When User clicks on Login module
    #And User logs in
    When User click to Address btn at the button

  @UI
  @Login2  #My Sales Address
  Scenario: User must verify that arrived at my sales address page.
    Then User must verify that the Address page appears

  @UI
  @Login2  #User must add address on my sales address page
  Scenario: User should be able to go to the relevant page and add a new address using the My Sales Address button.
    When User click to My Sales Address btn at the button
    When User click to Add New Address btn at the button
    And  User must click on the add button that opens and enter a new address
    And User enter postal zip code
    And User selected the Mark as a sales address button
    And User must click on submit button
    Then User should then see the message Your Address Successfully updated

  @UI
  @Login2  #Address edit and remove buttons should be functional in the My Sales Address section
  Scenario: User verify that the address Edit button in the My Sales Address section are functional.
    When User click to My Sales Address btn at the button
    When User goes to the address page and clicks the edit button
    Then User verifies that the address details page has opened

  @UI
  @Login2  #When the Remove button is clicked, the "Are you sure to delete the address?" screen should be displayed
  Scenario: User verify that the address Remove button in the My Sales Address section are functional.
    When User click to My Sales Address btn at the button
    When User goes to the address page and clicks the remove button
    Then Are you sure to delete the address confirms that the screen is turned on

  @UI
  @Login2  #After clicking Submit, Your Address successfully updated alert should appear
  Scenario: User must verify that the address Edit process is running in the My Sales address section(Text)
    When User click to My Sales Address btn at the button
    When User clicks on the edit button of the registered Address
    And  Edits User Address details
    And  User clicks on Edit Submit button
    Then User then confirms that sees the Your address successfully updated notice

  @UI
  @Login2  #Yes/No options should appear
  Scenario: User verify that the address Remove button in the My Sales Address section are functional.
    When User click to My Sales Address btn at the button
    When User goes to the address page and clicks the remove button
    Then User should see Yes and No options.


  @UI
    @Login2  #One of the Yes/No options should be selected(YES or NO btn)
  Scenario Outline: User must verify that the address removal button is functional in the My Sales Address section(Yes or No Btn)
    When User click to My Sales Address btn at the button
    When User clicks on Remove registered Address button
    And  Are you sure to delete the address? screen pops up
    And  when the user clicks on the "<option>" button
    Then User cannot cancel the transaction and the visibility of the address is verified
    Examples:
      | option |
      | Yes    |
      | No     |
