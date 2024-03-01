
Feature: US_34 As a user, I should be able to check valid and invalid name, surname, email.

   @UI @US32-TC01
   Scenario:TC001 Successful registration should be achieved when all information is entered correctly.
     Given User goes to homepage
     And User click the register button
     Then First name information is entered as a letter
     And Surname information is entered as letters
     And Valid email information is entered with the @, <something>.<something> sign.
     Then the message 'Welcome' appears.

  @UI @US34-TC02 @smoke
  Scenario: US34_TC32 As a user, I should be able to check valid and invalid name, surname, email.
    Given User goes to homepage
    And Click the "Register" button on the main Page

    Then Verify that first name entries match the expected result
#       | First Name  | Expected |
      |             | false    |
      | Mehmet123   | false    |
      | Mehmet@     | false    |
      | Mehmet      | true     |

    Then Verify that middle name entries match the expected result
#     | Middle Name | Expected |
      |             | true     |
      | Emin456     | false    |
      | Emin#       | false    |
      | Emin        | true     |

    Then verify that last name entries match the expected result
#     | Last Name  | Expected Result |
      |            | false           |
      | Demir123   | false           |
      | Demir-     | false           |
      | Demir      | true            |

    Then Verify that email entries match the expected result
#     | Email                 | Expected |
      |                       | false |
      | @                     | false |
      | mehmetemin.com        | false |
      | mehmet.emin@          | false |
      | mehmet emin@demir.com | false |
      | mehmet.emin@demir.com | true  |











