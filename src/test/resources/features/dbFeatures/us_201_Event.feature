@DB
Feature: TE of US_201 Event DataBase

  Scenario: TC_01 US_201 Create Event
    When User create an event
    Then User should be able to reach event

  Scenario: TC_02 US_201 Update Event
    When User update an event
    Then User should be able to reach updated event

  Scenario: TC_03 US_201 Delete Event
    When User delete an event
    Then User should be able to reach deleted event