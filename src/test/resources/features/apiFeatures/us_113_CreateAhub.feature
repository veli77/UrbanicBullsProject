@wip7
Feature:US_113-As a user, I should be able to create a hub.
  @user3token @API
  Scenario: User should be able to create a hub information.
    Given User connect to the "https://test.urbanicfarm.com/api/account/hub/create" and create a hub
    Then User verifies success message