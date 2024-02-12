@Kubra
Feature:As a user, after entering valid information, I should be able to see the Sell-Pay-Trade page.

  Background:
    Given User goes to homepage
    And User logs in
    And User clicks on Sell-Share-Trade module


    @UI @US_41_TC01
    Scenario:Contact us--User-Logout-Notifications-Cart  sholuld be visible
      Then The Contact Us button appears and is clicked and the page opens.
      Then The User button appears and is clicked and the page opens.
      Then Logout Button appears and is clicked and the page opens
      Then The notification button appears and is clicked and the page opens.
      Then The card appears and is clicked and the page opens.
