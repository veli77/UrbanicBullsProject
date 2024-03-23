@wip7
Feature: US_106-As a user, I should be able to update an existing address.
  @user3token
  Scenario: User should be able to update an existing address.
    Given User connects to the "https://test.urbanicfarm.com/api/account/address/addAddress" and add a address
    When User connect to the "https://test.urbanicfarm.com/api/account/address/update" and update a address
    Then User verifies success message
    And User delete the added address
