@Kubra @API
Feature: US_104 As a user, I should be able to get address information.

  @user3token @US104_TC01
  Scenario:US104-TC_01 User should be able to get address information.
    Given users connect to the "https://test.urbanicfarm.com/api/account/address/getAddress"
    Then user verifies success message
