Feature: Test Execution of US116 Add and Delete Product

  Scenario: TC_001 US_116 Add and Delete Product
    When user can add a product at "/account/hub/product/add"
    Then the user should be able to add a product
    Then the user should be able to delete the product
