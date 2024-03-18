Feature: TE of US_133
  Scenario: TC_01 US_133 create an event
    When user gets the create an events at "/account/event/create"
    Then user verifies success message