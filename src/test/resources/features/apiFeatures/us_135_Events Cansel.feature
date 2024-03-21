Feature: US_135 As a user, I should be able to cancel an event


  @user3token @API
  Scenario: User should be able to cancel an event
    Given User connect to the "https://test.urbanicfarm.com/api/account/event/cancel" and cancels the events
    Then User verifies "You have canceled your attendance" message