@UI @BU-248
Feature: TE of US_058 Delivery type-Buyer picks up

  Scenario: TC_01 US_058 Delivery type-Buyer picks up

    Given User logs in with valid Credential Two
    When User clicks Delivery Pick up settings menu
    And Deselect all checkboxes in the Delivery Type
    And User clicks Buyer picks up
    Then User should see that the Your Available Hours menu is functional
    When User selects suitable hours from the Your available hours menu
    And User clicks Update button
    Then User should see the alert that Your delivery settings have been successfully updated
    And User clicks Buyer picks up
    When User selects start time later than end time
    And User clicks Update button
    Then User should see the alert Start time cannot be greater than end time at the Buyer picks up field

