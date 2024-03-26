@API
Feature: TE Of US-124 As a user, I should be able to get unread message count.
  Scenario: US124_TC001 GetUnreadMessageCount
    When user get unread message count "/chat/getUnreadMessagesCount"
    Then user verifies status code 200 response from API utilities
    And user verifies success "true"