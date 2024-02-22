@UI @US64 @BU_179
  Feature: US_064 - As a user, after entering valid information, I should be able to perform various actions in the Orders section

    @BU_226
    Scenario: Orders Section Functionality
      When User logs in as Vedat
      Then User should be able to click the Orders button on the left side bar in Account Page and verify that user is in the Orders Page
      And User selects any order
      And User should be able to see Quick Overview Contents
      And User clicks Rate The Product linkText
      Then User should be able to see rating pop-up and contents










