@UI @Vedat @US_080
  Feature: US_080-As a user, I should be able to delete the event(s)

    Scenario: US_080_TC_01_Event(s) Delete Function
      Given User logs in as Vedat
      When User goes to MyEvents Page
      And User clicks Create New Event
      When User enter title
      And User enter address
      And User enter date
      And User enter time
      And User enter Attendee, schedule , description and terms and conditions and click submit button
