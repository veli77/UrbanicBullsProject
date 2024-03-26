@wip7 @API
Feature: US_104 As a user, I should be able to get address information.

  @user3token
  Scenario: User should be able to add a address information.
    Given User connect to the "https://test.urbanicfarm.com/api/account/address/addAddress" and add a address
    Then User verifies success message
