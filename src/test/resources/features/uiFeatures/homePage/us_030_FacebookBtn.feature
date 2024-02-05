@BU-90
Feature: Test Execution of US030

  @TEST_BU-89
  @UI
  Scenario: TC01_US030 FaceBook Btn is clickable
    Given User goes to HomePage
    When User click the FacebookBtn
    Then User should be able to click FacebookIcon