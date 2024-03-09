Feature: US-083 Nav Bar Contact US menu feature

  @UI @Zafer

  Scenario: TC_01 US_083-As a user, I should be able to perform various operations on the Contact us page
    Given User goes to homepage "https://test.urbanicfarm.com"
    When User click to Contact Us menu at the navbar
    Then User should be able to see Contact Us GET IN TOUCH text
    Then User click to "SEND MESSAGE"
    And User should be able to see alert messages
      | Please enter a valid name.                          |
      | Please enter a valid email address.                 |
      | Please enter a message with at least 10 characters. |
    Then User should be able to click after entering the required information "SEND MESSAGE"
