Feature: TE of US_133

  Scenario: TC_01 US_133 create an event
    When user gets the create an events at "/account/event/create"
    Then user verifies success "true"

  Scenario: TC_02 US_133 Delete
    When user gets the delete an events at "/account/event/delete"
    Then user verifies success "true"