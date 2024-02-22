@wip3
Feature:As a user, after entering valid information, I should be able to perform various actions in the Address section

  Background:
    #Given User goes to homepage
    #When User clicks on Login module
    #And User logs in
    When User click to Address btn at the button
    When User click to Add New Address btn at the button

  @UI
  @Login2  #In the Add New Address page;
  Scenario: User must verify that arrived at Add New Address page
    Then User must verify that the Add New Address page appears

  @UI
  @Login2  #Address Title, Address, State,City, Post/Zip and Mark as delivery address,Mark as sales address options should appear
  Scenario: User should be able to go to the relevant page and add a new address using the My Sales Address button.
    When User must click on the add button that opens and enter a new address
    Then Mark as User Address Title, Address, State, City, Post Post and Delivery address,You should see Mark as sales address options


  @UI
  @Login2  #All titles and menus must be functional and additable
  Scenario: User must verify that all headers and menus are functional and can be added
    When User must click on the add button that opens and enter a new address
    Then User must verify that all headers are functional and appendable


  @UI
  @Login2  #After adding the address, the warning Your address has been successfully added should appear.
  Scenario: After adding the User Address, the user should see the warning Your Address has been successfully added
    When User must click on the add button that opens and enter a new address
    And User enter zip code
    And User should click on submit button on Add New Address page
    Then User should then see the message Your Address Successfully updated


  @UI
    @Login2  #The added address should appear in the relevant section according to the selected transaction (Delivery address or My Sales address).
  Scenario: The user should see the added address in the relevant section (Delivery address or My Sales address) according to the selected transaction.
    When  User must click on the add button that opens and enter a new address
    And User enter postal zip code
    And User selected the options button
    And User must click on add new address submit button
    Then User verifies that sees the address added in the section selected.
    When User click to My Sales Address btn at the button
    Then User cannot cancel the transaction and the visibility of the address is verified

