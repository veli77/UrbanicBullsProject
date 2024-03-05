@UI @Vedat @US_080
  Feature: US_080-As a user, I should be able to delete the event(s)

    Scenario: US_080_TC_01_Event(s) Delete Function
      Given User logs in as Vedat
      When User goes to MyEvents Page
      And User clicks Create New Event
      And User enters title
      And User adds an address for the event
      And User enters the date
      And User enters the time
      And User sets the fee
      And User enter Attendee, schedule , description and terms and conditions and click submit button
