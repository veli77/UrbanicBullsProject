Feature: US_129	As a user, I should be able to get all events details

  @userUrbanic2Token
  Scenario: As a user, I should be able to get all events details
    Given User connect to the "https://test.urbanicfarm.com/api/public/getEvent/230" and get my events
    Then User verifies get my events success message 200