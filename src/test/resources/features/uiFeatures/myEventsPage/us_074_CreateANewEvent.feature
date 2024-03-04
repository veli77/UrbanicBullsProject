@UI @Login
Feature: US_074 - Create a New Event


  Scenario: User is able to create an event
    Given User goes to My Events Page
    When User clicks the Create Event button
    And User adds an address for the event
    And User enters valid information to create a new event

      | Title                | New Event             |
      | Date                 | 30/12/2025            |
      | Time                 | 15:30                 |
      | Fee                  | 100                   |
      | Duration             | 10                    |
      | Attendee Limit       | 5                     |
      | Schedule             | Afternoon Events      |
      | Description          | Online Meeting        |
      | Terms and Conditions | Attendance Compulsory |

    When User clicks on the submit button
    And User verifies that a new event is created