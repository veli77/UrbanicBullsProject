@API @user3token
Feature: TE Of US-122 As a user, I should be able to get all orders
  Scenario: US122_TC001 GetAllOrders
    When User gets information on all of the orders
    Then User verifies the status code and response content for all of the orders