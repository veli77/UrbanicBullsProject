@Vedat @API @US_134

Feature: TE of US_134
  @userVedatToken
  Scenario: As a user, I should be able to update an existing event.
    When User connects "https://test.urbanicfarm.com/api/account/event/create" and creates an event
    And User connects "https://test.urbanicfarm.com/api/account/event/update"
    Then User should be able to update event and see event updated message
    And User deletes updated event