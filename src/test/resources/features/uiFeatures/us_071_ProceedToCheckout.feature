@US071_ERSIN @Login @UI
Feature: US071_ProceedToCheckout Page

  Scenario: Proceed to Checkout Page functionality

    Given the user goes to the GoToChart page
    When the user clicks on the ProceedToCheckout button, the user can reach the ProceedToCheckout page
    And Next and Prev buttons should be functional
    And GoToPayment button should be functional
    And Payment should be success
    Then Rate button should be functional and give accurate results
    And Order detail button should be functional and correct result should be obtained
    And The status of the orders should be visible.
    And Order statuses must be seen in mutual buyer-seller accounts
    Then As a result of orders, the number in the notifications button should increase



