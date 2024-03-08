@UI
Feature: US_081 - As a user, should able to cancel/completed/share the event(s)

  Scenario: User should able to cancel/completed/share the event(s)

    Given User logs in with valid Credential Two
    When User clicks the Cancel button
    Then User should see the message "Event canceled"
    And  There should be a "Cancelled" sign displayed when the event is cancelled
    When User clicks the Mark as Completed button
    Then User should see the message "Event marked as completed"
    And there should be a "Completed" sign displayed when the event is completed
    When User clicks the Copy Link button
    Then User should see the message "Event Link Copied to Clipboard"
    And The event link should be copied to the clipboard


