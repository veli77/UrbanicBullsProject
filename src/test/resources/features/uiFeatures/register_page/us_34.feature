@Kubra
Feature: As a user, I should be able to check valid and invalid name, surname, email.

   @UI @US32-TC01
   Scenario:TC001 Successful registration should be achieved when all information is entered correctly.
     Given User goes to homepage
     And User click the register button
     Then First name information is entered as a letter
     And Surname information is entered as letters
     And Valid email information is entered with the @, <something>.<something> sign.
     Then the message 'Welcome' appears.

  @UI @US34-TC02 @smoke
  Scenario: As a user, I should be able to check valid and invalid name, surname, email.
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


@UI
  Scenario Outline: An error message should be received if the name information is invalid or left blank.
   Then firstname is entered in unexpected format "<firstname>","<status>","<middlename>","<status>","<lastname>",<status>","<password>","<status>","<cnfrmpass>","<status>", and error message is received
    Then the error message is appears.
  Examples:
    | firstname | status | middlename | lastname | password | cnfrmpass |









