
@Login
@UI
@BU-158
Feature:Varios operations can be performed on the accoiunt button

 # Scenario:TC_01 As a user, after entering valid information,
 # I should be able to perform various actions in the Account section.
  # Given user goes to Login Page
  @TEST_BU-154
  Scenario: Viewing Account Information
    Given the user clicks on the Account
     When the following options should be visible
      | Qr code      |
      | Full name    |
      | Email        |
      | Phone        |
      | Choose file  |
    Then the Copy button should be functional
    And the Download button should be functional

  @TEST_BU-156
  Scenario: Editing Account Information
    Given the user is on the account page
    When the user clicks on the Edit button
    Then the Choose file button should be functional
    And the user selects a file using the Choose file button
    And the account photo should be updated with the selected file
    And the phone menu should be updated
    And the Save button should be functional
    When the user clicks on the Save button
    Then an alert with the message "Your account information has been updated" should be displayed

  @TEST_BU-157
  Scenario: Toggling Menu Dimensions
    Given the user is on the account page
    When the user clicks on the Toggle menu button
    Then the menu dimensions should change
    And the menu button should be functional
