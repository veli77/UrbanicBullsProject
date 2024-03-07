@UI
Feature:TE of user story_084_DonationFunctionality

  Background: Precondition of user story 84
    Given User login product environment
    When User goes to support page

  Scenario: TC_01 US_084 As a user, I should be able to perform various operations on the Support us page
    Then User should be able to reach "https://wefunder.com/urbanicfarm"

  Scenario: TC_02 US_084 As a user, I should be able to perform various operations on the Support us page
    When User makes "100" $ donation
    Then User should be able to make donation "100"

  Scenario: TC_03 US_084 As a user, I should be able to perform various operations on the Support us page
    When User makes "99" $ donation
    Then User should not be able to make donation