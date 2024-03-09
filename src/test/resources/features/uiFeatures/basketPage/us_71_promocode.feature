@UI @Kubra @US71
Feature: As a user, after entering valid information, I should be able to perform various actions in the Welcome Page

  @Login2
  Scenario: US71-TC01 Enter prome code menu should be functional
    Given User enters cart
    And User adds order on cart page
    Then Promocode menu should be clickable
    Then User should be enter promocode
    Then After entering the Promo Code, you should receive the same "10.0" discount
    And User completes the purchase


  @Login2
  Scenario: US71-TC02 Prome code must not be greater than to the total amount
    Given User enters cart
    And User adds order on cart page for order
    Then Promocode is entered greater than the total amount and an error message is expected.


  @Login2
  Scenario: US71-TC03 Prome code must not be equal to the total amount
    Given User enters cart
    And User adds order on cart page for order equals
    Then Promocode is entered equal to the total amount and an error message is expected.
    Then Undefined promocode is entered and an error message is expected.
    And User completes the purchase

  @Login2
  Scenario: US71-TC03 Post payment promecode should show correct result
    Given User enters cart
    And User adds order on cart page
    Then Promocode is entered less than the total amount and the same discount will be seen on the total amount.
    Then Defined promocode is entered and an positif message is expected.
    And User completes the purchase
