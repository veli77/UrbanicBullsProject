@UI
@umit @US_061
@Login3
Feature: Your Products/Services Section

    Background:
    #    Given the user enters with buyer information
    When user goes to Your products-services

  Scenario: TC_01_View Products Group
    Then various products should be visible

  Scenario: TC_02_Viewing Products List
    Given the user clicks on  any group
    When each product should display Product Name, Price and Stock information
    Then options for Approved, Review, and Rejected should be visible for each product

  Scenario: TC_03_Viewing Product Information
    Given the user clicks on  any group
    When the user click on the product name to view details
    Then the user should be able to change product information on this page
    Then the organic and Trade buttons should be functional
    And the Update buttons should be visible
    And the Delete buttons should be visible


  Scenario: TC_04_Adding Trade Description
    Given the user clicks on  any group
    When the user click on the product name to view details
    Given the user is viewing product information
    When the user clicks the Trade button If the trade description entry is not visible
    Then the Trade description input should be visible
    Then user sends Selam to Trade input  description
    Then the user makes necessary corrections and clicks the Update button
    And an alert should display confirming the update

#  Scenario: TC_05_Updating Product Information
#    Given the user clicks on  any group
#    When the user click on the product name to view details
#    Given the user is viewing product information
#