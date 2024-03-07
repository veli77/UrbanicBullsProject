@UI @Login @US_075 @umit
Feature: Event Creation

Background:
  Given User goes to MyEvents Page
  When User clicks Create New Event

  Scenario Outline: Creating an event with invalid data
    Then User fills in the required fields with invalid data "<title_input>" "<address_input>" "<date_input>" "<time_input>" "<fee_input>" "<duration_input>" " <attendee_limit_input>" "<terms_conditions_input>"
    Then User clicks on the submit button
    And User verifies that a warning message "<warning_message>"

    Examples:Invalid Data
      | title_input | address_input  | date_input | time_input | fee_input | duration_input | attendee_limit_input | terms_conditions_input | warning_message                          |
      |             | Sample Address | 15-03-2024 | 14:00      | 10        | 30             | 50                   | I agree to the terms"  | Please enter a valid title.              |
      | Event Title |                | 15-03-2024 | 14:00      | 10        | 30             | 50                   | I agree to the terms"  | Please select an address.                |
      | Event Title | Sample Address |            | 14:00      | 10        | 30             | 50                   | I agree to the terms"  | Please fill this field                   |
      | Event Title | Sample Address | 15-03-2024 |            | 10        | 30             | 50                   | I agree to the terms"  | Please fill this field                   |
      | Event Title | Sample Address | 15-03-2024 | 14:00      |           | 30             | 50                   | I agree to the terms"  |                                          |
      | Event Title | Sample Address | 15-03-2024 | 14:00      | 10        |                | 50                   | I agree to the terms"  | Please enter a valid duration.           |
      | Event Title | Sample Address | 15-03-2024 | 14:00      | 10        | 30             |                      | I agree to the terms"  | Please enter a valid attendee limit.     |
#      | Event Title | Sample Address | 15-03-2024 | 14:00      | 10        | 30             | 50                   |                        | Please enter valid terms and conditions. |

  Scenario: Canceling event creation
    Then User clicks Go Back button
    And User verifies that  back to the previous page

