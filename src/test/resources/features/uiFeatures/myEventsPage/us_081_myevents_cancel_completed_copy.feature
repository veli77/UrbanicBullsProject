  @UI @US_081
  Feature: US_081 - As a user, should able to cancel/completed/share the event(s)
#  Background: Precondition of US_081 User is able to create an event
#    Given User login as USERBASEWEBSITE
#    And User goes to My Events Page
#    When User clicks the Create Event button
#    And User adds an address for the event
#    And User enters valid information to create a new event
#
#      | Title                | New Event             |
#      | Date                 | 30/12/2025            |
#      | Time                 | 15:30                 |
#      | Fee                  | 100                   |
#      | Duration             | 10                    |
#      | Attendee Limit       | 5                     |
#      | Schedule             | Afternoon Events      |
#      | Description          | Online Meeting        |
#      | Terms and Conditions | Attendance Compulsory |
#
#    When User clicks on the submit button
#    And User verifies that a new event is created


  Scenario: User should able to cancel/completed/share the event(s)
    Given User login as USERBASEWEBSITE
    When User clicks My Events menu
    Then User should be able to see Create New Event Button
    When User clicks My Completed Events
    Then User clicks the Copy Link button
    And User should see the message Event Link Copied to Clipboard



#    When User clicks the Cancel button
#    Then User should see the message "Event canceled"
#    And  There should be a "Cancelled" sign displayed when the event is cancelled
#    When User clicks the Mark as Completed button
#    Then User should see the message "Event marked as completed"
#    And there should be a "Completed" sign displayed when the event is completed
#    When User clicks the Copy Link button
#    Then User should see the message "Event Link Copied to Clipboard"
#    And The event link should be copied to the clipboard
