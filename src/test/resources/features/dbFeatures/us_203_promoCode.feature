@US_203 @Erdal
Feature: TE of US_203 Promo Code feature

  @DB
  Scenario: TC_01 US_203 create Promo Code
    When User create Promo Code
    Then User should be able to see Promo Code information in the correct schema and columns in DB
    And User update Promo Code
    And User delete Promo Code