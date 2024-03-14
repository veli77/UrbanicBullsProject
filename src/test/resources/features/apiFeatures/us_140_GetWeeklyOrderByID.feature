Feature: TE of US_140

  Scenario: TC_01 US_140 get weekly order by ID
    When user gets the WeeklyOrderbyId at "/account/weeklyorder/getWeeklyOrderbyId"
    Then user should be able to verifies order ID