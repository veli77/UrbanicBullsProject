@DB
Feature: US_202 Add New Product

  Scenario:TC_01 US_202 As a user, when i should add new product then I Should be able to see new product  in the correct
  schema and columns in DB
    When User create New Product
    Then User should be able to reach New Product information in the correct schema and columns in DB

  Scenario:TC_02 US_202 Delete New Product
    When User delete New Product
    Then User should be able to reach deleted New Product information in the correct schema and columns in DB


