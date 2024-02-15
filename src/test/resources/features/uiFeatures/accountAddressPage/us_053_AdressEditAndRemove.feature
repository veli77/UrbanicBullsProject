@UI
Feature: TE of US_053 Adress Edit And Remove

  Background:
    Given User logins
    When User goes to AccountAddress Page
    When User goes to Others Section in Account Address Section

  Scenario: TC_01 User should be able to see the saved address
    When User hat any saved Address user add new address
      | Office | 33 Ingolstadt, Germany |  |  | 85039 | Ingolstadt |
    Then User should be able to see the warning text when user hat any seller address in My Sales Address Section
    And User should be able to enable Edit and Remove buttons in Others Section

  Scenario: TC_02 User should be able to edit and remove address
    When User edit a new address
      | Home | 39 Ingolstadt, Germany |  |  | 85033 |
    Then User should be able to see the Toast Message
    And User should be able to click Remove button
    And User should be able to see Yes and No options
    And User should be able to see only Yes and No options
    And User should be able to click Yes option
    And User should be able to see the Removed Address Toast Message