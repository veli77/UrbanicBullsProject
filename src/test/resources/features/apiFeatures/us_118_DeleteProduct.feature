
@API
Feature: Test Execution of US118 Add and Delete Product
  @US_118
  Scenario: TC_001 US_118 Add and Delete Product
    When user can add a product at "/account/hub/product/add"
    Then the user should be able to add a product

  Scenario: TC_002 US_118 Delete
    Then the user should be able to delete the product "/account/hub/product/delete"
