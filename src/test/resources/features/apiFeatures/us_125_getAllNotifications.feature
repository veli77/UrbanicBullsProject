@API
Feature: TE Of US-125 As a user, I should be able to get All Notifications.
  Scenario: US125_TC001 getAllNotifications
    When user get all notification "/account/notifications/getAll"
    Then user verifies status code 200 response from API utilities
    And user verifies success "true"