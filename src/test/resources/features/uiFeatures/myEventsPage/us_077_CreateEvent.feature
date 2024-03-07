@UI
@Login2
Feature: As a user, should not able to add an address successfully by providing with invalid data

  Background:
    #Given User goes to homepage
    #When User clicks on Login module
    #And User logs in
    When User click to My Events btn at the button
    When User click to Create New Event btn at the button

  Scenario: TC_01 Title should be at least two character and can not be blank if so user will see warning message "Please enter a valid title."
    When User enter blank title
    And User enter address
    And User enter date
    And User enter time
    And User enter Attendee, schedule , description and terms and conditions and click submit button
    Then User see Please enter a valid title message

  Scenario: TC_02 address should be at least one character and can not be blank if so user will see warning message "Please enter a valid address."
    When User enter title
    And User enter blank address
    And User enter date
    And User enter time
    And User enter Attendee, schedule , description and terms and conditions and click submit button
    Then User see Please select an address message


  Scenario: TC_03 User should be able to add date. can not be blank if so user will see warning message "Please fill in this field."
    When User enter title
    And User enter address
    And User enter blank date
    And User enter time
    And User enter Attendee, schedule , description and terms and conditions and click submit button
    Then User see Please fill in this field message for date

  Scenario: TC_04 User should be able to add time. can not be blank if so user will see warning message "Please fill in this field."
    When User enter title
    And User enter address
    And User enter date
    And User enter blank time
    And User enter Attendee, schedule , description and terms and conditions and click submit button
    Then User see Please fill in this field message for time






