Feature: As a user I should be able to see the functionality of the register page

  @UI @veli @033
  Scenario: Name, Surname, Email, Password fields must be functional
    Given User goes to homepage
    And Click the "Register" button on the main Page
    Then Verify that Name, Surname, Email, Password fields are enabled
#     | Fields          |
      | firstname       |
      | middlename      |
      | lastname        |
      | email           |
      | plainPassword   |
      | confirmPassword |

  @UI @veli @033
  Scenario: Name should not be able to left blank
    Given User goes to homepage
    And Click the "Register" button on the main Page
    Then Verify that Name should not be able to left blank
#     | Fields          |
      |                      |
      | Doe                  |
      | johndoe001@gmail.com |
      | 555pqX27_Re          |
      | 555pqX27_Re          |

  @UI @veli @033
  Scenario: Surname should not be able to left blank
    Given User goes to homepage
    And Click the "Register" button on the main Page
    Then Verify that surname should not be able to left blank
      | John                 |
      |                      |
      | johndoe001@gmail.com |
      | 555pqX27_Re          |
      | 555pqX27_Re          |

  @UI @veli @033
  Scenario: Email should not be able to left blank
    Given User goes to homepage
    And Click the "Register" button on the main Page
    Then Verify that email should not be able to left blank
      | John        |
      | Doe         |
      |             |
      | 555pqX27_Re |
      | 555pqX27_Re |

  @UI @veli @033
  Scenario: Password should not be able to left blank
    Given User goes to homepage
    And Click the "Register" button on the main Page
    Then Verify that password should not be able to left blank
      | John                 |
      | Doe                  |
      | johndoe001@gmail.com |
      |                      |
      | 555pqX27_Re          |

  @UI @veli @033
  Scenario: Confirm password should not be able to left blank
    Given User goes to homepage
    And Click the "Register" button on the main Page
    Then Verify that verifypassword should not be able to left blank
      | John                 |
      | Doe                  |
      | johndoe001@gmail.com |
      | 555pqX27_Re          |
      |                      |

