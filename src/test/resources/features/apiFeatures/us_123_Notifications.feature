@API
Feature: TE Of US-123 As a user, I should be able to get all conversations.
  Scenario: US123_TC001 GetAllConversation
    When user get the all conversation "/chat/getConversations"
    Then user verifies status code 200 response from API utilities


