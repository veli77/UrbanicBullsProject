Feature: TC01 of US_054 I should be able to perform various actions in the Address section


  Background: Precondition of US_054 Login and goes Account Address Page then goes Delivery Address Section
    Given User logins as UserOne
    When User goes to AccountAddress Page
    When User goes to Delivery Address Section in Account Address Section

  @TEST_BU-251
  @US_054 @UI
  Scenario: TC01 of US_054 I should be able to perform various actions in the Address section
    When User should be able to see edit and remove buttons are visible
    Then User should be check addresses are same before and after edit button click
    Then User should be able to see the Toast Message
    Then User should be able to click Remove button
    And User should be able to see Yes and No options
    Then User Should be able to click No for cancel remove
    Then User should be able to click Remove button
    And User should be able to click Yes option
    And User should be able to see the Removed Address Toast Message



