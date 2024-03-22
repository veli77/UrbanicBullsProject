

Feature: Test Execution US_139 Create Weekly Order

  Scenario: TC_001 US_139 Create Weekly Order
    When the user can create a new weekly order at "/account/weeklyorder/createWeeklyOrder"
    Then the user should be able to create a new weekly order