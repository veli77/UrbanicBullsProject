
  Feature: Sign up with google account

    #Registration must be created with Sign in with Google and confirmation must be sent to the e-mail.
  @UI
  Scenario: As a user I need to be able to register with my Google account
    Given User goes to homepage
    When User click the register button
    And User click to sign in with google
    Then User successfully logs in with google account
