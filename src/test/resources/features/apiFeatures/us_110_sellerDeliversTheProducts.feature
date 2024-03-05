@US_110 @API
Feature: TE of US_110  As a user, I should be able to change availability for seller delivers the products

  Scenario: TC_01 US_110 user should be able to change availability for seller delivers the products
    Given user connect to "https://test.urbanicfarm.com/api/account/change/delivery"
    Then user verifies status code 200