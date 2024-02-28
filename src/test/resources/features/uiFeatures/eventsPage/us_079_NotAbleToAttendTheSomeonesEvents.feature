@Login2
@UI
  Feature: TE of US_079 As a user, should not able to attend the someone's event(s)

    Scenario: TC_001 As a user, should not able to attend the someone's event(s)
   Given User goes to Events Page
  When User clicks

    #number of attendee cannot be blank,negative number,
    # 0 and can not be above attendee limits number if so box will be red and approve button will be disabled
    #user must checked check box of terms and conition box otherwise aprove button will be disabled
    #if user already attented the event can not register again and see message "You already attended to this event"
