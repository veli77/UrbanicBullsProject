Feature: Event Creation
  As a user
  I want to create an event with valid data
  So that I can successfully create the event

  Scenario: Creating an event with valid data
    Given I am on the Event page
    When I click the "Create Event" button
    And I fill in the required fields with valid data
    And I click the submit button
    Then I should see a success message confirming the event creation

  Scenario Outline: Creating an event with invalid data
    Given I am on the Event page
    When I click the "Create Event" button
    And I fill in the required fields with invalid data:
      | Title           | Address        | Date       | Time | Fee | Duration | Attendee Limit | Terms and Conditions |
      | <title_input>   | <address_input>| <date_input>| <time_input>| <fee_input>| <duration_input>| <attendee_limit_input>| <terms_conditions_input>|
    And I click the submit button
    Then I should see a warning message "<warning_message>"

    Examples:
      | title_input   | address_input    | date_input   | time_input | fee_input | duration_input | attendee_limit_input | terms_conditions_input | warning_message                              |
      | ""            | "Sample Address" | "2024-03-05" | "14:00"    | "10"      | "2 hours"      | "50"                 | "I agree to the terms" | "Please enter a valid title."                |
      | "Event Title" | ""               | "2024-03-05" | "14:00"    | "10"      | "2 hours"      | "50"                 | "I agree to the terms" | "Please select an address."                  |
      | "Event Title" | "Sample Address" | ""           | "14:00"    | "10"      | "2 hours"      | "50"                 | "I agree to the terms" | "Please select a date."                      |
      | "Event Title" | "Sample Address" | "2024-03-05" | ""         | "10"      | "2 hours"      | "50"                 | "I agree to the terms" | "Please enter a time."                       |
      | "Event Title" | "Sample Address" | "2024-03-05" | "14:00"    | ""        | "2 hours"      | "50"                 | "I agree to the terms" | "Please provide a fee."                      |
      | "Event Title" | "Sample Address" | "2024-03-05" | "14:00"    | "10"      | ""             | "50"                 | "I agree to the terms" | "Please enter a valid duration."             |
      | "Event Title" | "Sample Address" | "2024-03-05" | "14:00"    | "10"      | "2 hours"      | ""                   | "I agree to the terms" | "Please enter a valid attendee limit."       |
      | "Event Title" | "Sample Address" | "2024-03-05" | "14:00"    | "10"      | "2 hours"      | "50"                 | ""                     | "Please enter a valid terms and conditions."|

  Scenario: Canceling event creation
    Given I am on the Event page
    When I click the "Create Event" button
    And I decide to cancel the creation
    Then I should be redirected back to the previous page