@US_205
Feature: US_201 Add A New Address
  @DB
  Scenario: User should able to connect DB and see all events in correct schema and columns in DB
    When User creates a new events
    Then User should be able to reach address information in the correct schema and columns in DB
    And User should be able to delete the address