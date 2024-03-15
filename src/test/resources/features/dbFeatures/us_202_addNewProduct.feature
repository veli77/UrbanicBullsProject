Feature: US_202 Add New Product

  Scenario:As a user, when i should add new product then I Should be able to see new product  in the correct
  schema and columns in DB
    When User create TOMATO
    Then User should be able to reach Tomato information in the correct schema and columns in DB
    Then User should be able to get added Tomato

