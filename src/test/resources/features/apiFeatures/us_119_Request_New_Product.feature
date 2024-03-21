Feature: US_119	As a user, I should be able to request a new product.

  @user3token
  Scenario: As a user, should be able to request a new product.
    Given User connect to the "https://test.urbanicfarm.com/api/account/newProductRequest" and request new product
    Then User verifies request new product success message 200