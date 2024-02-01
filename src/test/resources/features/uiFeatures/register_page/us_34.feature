
Feature: As a user, I should be able to check valid and invalid name, surname, email.

  Background:
    Given User goes to homepage
    When User click the register button

   @UI
   Scenario:TC001 Successful registration should be achieved when all information is entered correctly.
     Then First name information is entered as a letter
     And Surname information is entered as letters
     And Valid email information is entered with the @, <something>.<something> sign.
     Then the message 'Welcome' appears.









