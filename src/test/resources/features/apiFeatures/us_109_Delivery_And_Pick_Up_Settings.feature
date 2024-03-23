Feature: US_109	As a user, I should be able to change availability for buyer picks up.

  @user3token @API
  Scenario: User should be able to change availability for buyer picks up.
    Given User connect to the "https://test.urbanicfarm.com/api/account/change/delivery" and change availability for buyer picks up
    Then User verifies success message 200