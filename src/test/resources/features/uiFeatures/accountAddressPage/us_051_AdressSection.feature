@UI @US051 @Ozlem
Feature: TE of US_051 Address

  Background: Precondition of US_051 Login and goes Account Address Page then goes Others Section
    Given User logins
    When User goes to AccountAddress Page
    When User goes to Others Section in Account Address Section

  Scenario: US_051
    When User click to My Sales Address btn at the button
    When User click to Add New Address btn at the button
    And  User must click on the add button that opens and enter a new address
    And User enter postal zip code
    And User clicks on the button cancel
    And User should be able to see not new address

