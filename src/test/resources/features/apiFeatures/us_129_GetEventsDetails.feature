Feature: US_129	As a user, I should be able to get all events details

  @userUrbanic2Token
  Scenario: As a user, I should be able to get all events details
    Given User connect to the "https://test.urbanicfarm.com/api/public/getEvent/" and 230 get my events
    Then User verifies my events get success message 200