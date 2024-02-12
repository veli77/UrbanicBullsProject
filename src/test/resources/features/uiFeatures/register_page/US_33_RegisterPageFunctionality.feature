@BU-164 @veli
Feature: TE_01 of US_33  Functionality of the register page

#AC_1 Name, Surname, Email, Password and Confirm Password enabled
  @TEST_BU-155 @UI @033
  Scenario: TC01 of US_033  Verify that Name, Surname, Email, Password and Confirm password enabled.
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

 #AC_2 User could not register with blank Name
  @TEST_BU-159 @UI @033
  Scenario: TC02 of US_033 User could not register with blank Name
    Given User goes to homepage
    And Click the "Register" button on the main Page
    Then Verify that Name should not be able to left blank
		#     | Fields          |
      |                      |
      | Doe                  |
      | johndoe001@gmail.com |
      | 555pqX27_Re          |
      | 555pqX27_Re          |

	#AC_3 User could not register with blank Surname
  @TEST_BU-160 @UI @033
  Scenario: TC03 of US_033 User could not register with blank Surname
    Given User goes to homepage
    And Click the "Register" button on the main Page
    Then Verify that surname should not be able to left blank
      | John                 |
      |                      |
      | johndoe001@gmail.com |
      | 555pqX27_Re          |
      | 555pqX27_Re          |

	#AC_4 User could not register with blank Email
  @TEST_BU-161 @UI @033
  Scenario: TC04 of US_033 User could not register with blank Email
    Given User goes to homepage
    And Click the "Register" button on the main Page
    Then Verify that email should not be able to left blank
      | John        |
      | Doe         |
      |             |
      | 555pqX27_Re |
      | 555pqX27_Re |

	#AC_5 User could not register with blank Password
  @TEST_BU-162 @UI @033
  Scenario: TC05 of US_033 User could not register with blank Password
    Given User goes to homepage
    And Click the "Register" button on the main Page
    Then Verify that password should not be able to left blank
      | John                 |
      | Doe                  |
      | johndoe001@gmail.com |
      |                      |
      | 555pqX27_Re          |

	#AC_6 User could not register with blank Confirm Password
  @TEST_BU-163 @UI @033
  Scenario: TC06 of US_033 User could not register with blank Confirm Password
    Given User goes to homepage
    And Click the "Register" button on the main Page
    Then Verify that verifypassword should not be able to left blank
      | John                 |
      | Doe                  |
      | johndoe001@gmail.com |
      | 555pqX27_Re          |
      |                      |

