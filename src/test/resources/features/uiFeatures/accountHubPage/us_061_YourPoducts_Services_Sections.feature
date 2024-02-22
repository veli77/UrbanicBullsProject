@UI
Feature: US_061_Your Products/Services Section

  Scenario: Viewing Product Information
    Given the user has entered valid information
    When the user clicks on the Products/Services section
    Then various products should be visible
    And each product should display Product Name, Price, Stock, and Unit information
    And options for Approved, Review, and Rejected should be visible for each product
    And the user should be able to click on the product name to view details
    And the user should be able to change product information
    And the organic and Trade buttons should be functional
    And the Update and Delete buttons should be visible

  Scenario: Updating Product Information
    Given the user is viewing product information
    When the user makes necessary corrections and clicks the Update button
    Then an alert should display confirming the update

  Scenario: Adding Trade Description
    Given the user is viewing product information
    When the user clicks the Trade button
    Then the Trade description input should be visible
    And the user should be able to add information to the trade description