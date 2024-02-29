@Login2
@UI
  Feature: TE of US_079 As a user, should not able to attend the someone's event(s)

    Scenario: TC_001 As a user, should not able to attend the someone's event(s)
   Given User goes to Events Page
      And User see Scheduled Events, Registered Events und Attended Events
      And User see CurrentUrl "https://test.urbanicfarm.com/account/events"
  When User clicks Scheduled Events
  And User see Events list
  Then user clicks Register button
      And user see Event Registration
  When user clicks number input
  Then user number of attendee cannot be blank , negative number, zero, above attendee limits number
  And user see so box will be red
  And user see approve button will be disable
  When user checked check box of terms
  And user see conition box otherwise approve button will be disable
  When user who has already participated in the event cannot register again
  And user see the message "You have already participated in this event"






    #number of attendee cannot be blank,negative number,
    # 0 and can not be above attendee limits number if so box will be red and approve button will be disabled
    #user must checked check box of terms and conition box otherwise aprove button will be disabled
    #if user already attented the event can not register again and see message "You already attended to this event"
