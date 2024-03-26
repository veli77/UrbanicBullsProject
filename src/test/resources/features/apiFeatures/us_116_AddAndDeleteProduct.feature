
@US_116
Feature: US116 Test Execution of US116 Add and Delete Product

  Scenario: TC_001 US_116 Add and Delete Product
    When user can add a product at "/account/hub/product/add"
    Then the user should be able to add a product

    Scenario: TC_002 US_116 Delete
    Then the user should be able to delete the product "/account/hub/product/delete"
