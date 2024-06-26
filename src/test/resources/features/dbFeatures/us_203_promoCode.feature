@US_203 @Erdal @DB
Feature: TE of US_203 Promo Code feature

  Scenario: TC_01 US_203 create Promo Code
    When User create Promo Code
    Then User should be able to reach Promo Code information in the correct schema and columns in DB
    Then User should be able to get added Promo Code ID

  Scenario: TC_02 US_203 update Promo Code
    When User update Promo Code
    Then User should be able to reach updated Promo Code

  Scenario: TC_03 US_203 delete Promo Code
    When User delete Promo Code
    Then User should be able to reach deleted Promo Code