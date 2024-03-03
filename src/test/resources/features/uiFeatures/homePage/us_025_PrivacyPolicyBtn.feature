@BU-125
@Erdal @US-25
Feature: TE of US_025 Botton Bar Privacy Policy btn feature

  #*Privacy Policy should be clickable and relevant page should be visible*
  @UI @TEST_BU-124 @TESTSET_BU-61
  Scenario: TC_01 US_025 User should be able to perform various operations on homepage
    Given User goes to HomePage
    When User click to Privacy Policy buton at the botton
    Then User should be able to see Privacy Policy page