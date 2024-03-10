@Login
@UI
Feature: TE of US_079 As a user, should not able to attend the someone's event(s)
  Background:
    Then User goes to Events Page
    And User see CurrentUrl "https://test.urbanicfarm.com/account/events"
    And User clicks Scheduled Events
    And User see Events list
    Then user clicks on the Register button of the "Fresh supplies for market" events
    And user see Event Registration

  Scenario: TC_001 US_079 As a user enters the number of participants blank

    Given user enters the number of participants blank
      | number |                  |
    And user see so box will be red
    Then user checked check box of terms
    Then user click on the approve button
    And user see the message "The number of attendaces must be bigger than zero(0)."

  Scenario: TC_002 US_079 As a user enters negativ number participant quantity
    Given user enters negativ number participant quantity
      | number |      -1            |
    And user see so box will be red
    When user checked check box of terms
    Then user click on the approve button
    And user see the message "The number of attendaces must be bigger than zero(0)."


  Scenario: TC_003 US_079 As a user enters zero participant quantity

    Given user enters zero participant quantity
      | number |      0            |
    And user see so box will be red
    When user checked check box of terms
    Then user click on the approve button
    And user see the message "The number of attendaces must be bigger than zero(0)."

  Scenario: TC_004 US_079 As a user enters the number of participants over the participant limits

    Given user enters the number of participants over the participant limits
      | number | "Attende Limit"  |
    And user see so box will be red
    When user checked check box of terms
    Then user click on the approve button
    And user see the message "There is no enough free slots for this event. "Attendee Limit:" free slots remained"


  Scenario: TC_005 US_079 As a user leaves the conditions box blank

    Given user participant enters the number of valid participants
      | number | 6  |
    And user see so box will be red
    When user leaves the conditions box blank
    Then user click on the approve button
    And user see the Checkbox message "Klicke dieses Kätschen an, wenn du fortfahren möchtest."

  Scenario: TC_006 US_079 As a user participant enters the number of valid participants

    Given user participant enters the number of valid participants
      | number | 6  |
    When user checked check box of terms
    Then user click on the approve button
    And user see the checkout page

  Scenario: TC_007 US_079 As a user already attented the event can not register again

    Given user participant enters the number of valid participants
      | number | 6  |
    When user checked check box of terms
    Then user click on the approve button
    And user see the message "You've already registered to this event"






    #number of attendee cannot be blank,negative number,
    # 0 and can not be above attendee limits number if so box will be red and approve button will be disabled
    #user must checked check box of terms and conition box otherwise aprove button will be disabled
    #if user already attented the event can not register again and see message "You already attended to this event"
