@UI @Vedat @US_080
  Feature: US_080-As a user, I should be able to delete the event(s)

    Scenario: US_080_TC_01_Event(s) Delete Function
      Given User logs in as Vedat
      When User goes to MyEvents Page
      And User clicks Create New Event
      And User adds an address for the event
      And User enters valid information to create a new event

        | Title                | New Event             |
        | Date                 | 0020241230            |
        | Time                 | 15:30                 |
        | Fee                  | 100                   |
        | Duration             | 10                    |
        | Attendee Limit       | 5                     |
        | Schedule             | Afternoon Events      |
        | Description          | Online Meeting        |
        | Terms and Conditions | Attendance Compulsory |

      When User clicks on the submit button
