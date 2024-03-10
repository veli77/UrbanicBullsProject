Feature: US_111 As a user, I should be able to change availability for seller flexible delivery.

  @user3token
  Scenario: User should be able to change availability for seller flexible delivery.
    Given User goes to "https://test.urbanicfarm.com/api/account/change/delivery"
    Then User verifies that availability for seller has changed