@Kubra @API
Feature: US_104 As a user, I should be able to get address information.

  @user3token
  Scenario: User should be able to get address information.
    Given users connect to the "https://test.urbanicfarm.com/api/account/address/getAddress"
    Then user verifies success message
