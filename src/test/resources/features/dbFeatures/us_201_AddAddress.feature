@US_201
Feature: US_201 Add A New Address
@DB
  Scenario:As a user when i should add address then I Should be able to see new address in the correct user schema and columns in DB
    When User creates a new address
    Then User should be able to reach address information in the correct schema and columns in DB
    And User should be able to delete the address