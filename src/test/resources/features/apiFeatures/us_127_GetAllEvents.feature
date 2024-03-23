Feature: US_127	As a user, I should be able to see my all events

  @userUrbanic2Token
  Scenario: As a user, I should be able to recieve all my events info.
    Given User connect to the "https://test.urbanicfarm.com/api/account/event/getMyEvents" and get my events
    Then User verifies get my events success message 200