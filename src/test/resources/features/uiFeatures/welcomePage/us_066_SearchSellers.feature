@UI @Login
Feature: US_066 - Search Sellers

  Background: User goes to Welcome Page
    Given User goes to the Welcome Page

  Scenario: US_066 - Search Products By Name
    Then User is able to search product by name
    Then User is able to search product by distance
      | Any             | 1000 |
      | Up to 5 miles   | 5    |
      | Up to 10 miles  | 10   |
      | Up to 50 miles  | 50   |
      | Up to 100 miles | 100  |
    Then User is able to search product by categories
    Then User is able to search for only organic products
    Then User is able to filter search by price level
      | 0   |
      | 1   |
      | 100 |
      | 150 |
    Then User is able to filter the search by delivery type
    Then User is able to filter the search by unit type