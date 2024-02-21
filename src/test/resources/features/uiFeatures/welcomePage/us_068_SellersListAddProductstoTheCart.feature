@UI @Login
Feature: US_068

Scenario: US_068 - I should be able to perform various actions in the Welcome Page

  Given User goes to the Welcome Page
  Then A list of sellers should appear under the heading Local sellers near you
  Then User is able to click on any seller in the list
  Then Products should be seen listed in separate sections
  Then Product quantity icons must be functional
  Then Add to Cart button must be functional
  When User clicks on the Add to Cart button
  Then Product added alert should appear
  And The product should be added to the cart
