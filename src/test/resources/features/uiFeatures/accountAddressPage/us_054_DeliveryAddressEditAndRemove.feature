
Feature: TE of US_054 Delivery Adress Edit And Remove


  Background: Precondition of US_054 Login and goes Account Address Page then goes Delivery Address Section
    Given User logins as UserOne
    When User goes to AccountAddress Page
    When User goes to Delivery Address Section in Account Address Section

  @US_054 @UI
  Scenario: TC_01 US_054 Address edit and remove buttons should be visible in the Delivery Address section
    When User should be able to see edit and remove buttons are visible
    Then User should be check addresses are same before and after edit button click
