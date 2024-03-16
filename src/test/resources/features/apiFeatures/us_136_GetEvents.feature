@API
Feature: As a user, I should be able to delete an event

  Scenario: TC_001 US_136 Add and Delete Event
    When user can add a event at "/account/event/create"
    Then the user should be able to add a event
@API_US136_TC02
  Scenario: TC_002 US_136 Delete
    Then the user should be able to delete the event "/account/event/delete"
