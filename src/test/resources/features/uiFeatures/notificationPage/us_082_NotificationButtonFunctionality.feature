@UI
Feature: US_082 Notification Buttons Various Actions

  Scenario: US_082 User should be able to perform various actions on notification menu


    Given  User logins the page
    Then  User clicks notification button
    When  User should be able to see Filter by unread
    And   User secondly should be able to see Mark all as read
    Then  User thirdly should be able to see View all
    And   After clicking View all button, user should be able to see "Notifications"
    Then  User should be able to make notifications Unread
    Then  User should be able to make notifications Read
