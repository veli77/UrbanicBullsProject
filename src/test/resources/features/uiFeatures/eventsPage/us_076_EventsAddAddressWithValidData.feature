@UI @Erdal @US_076
Feature: TE of US_076 As a user, should able to add an address successfully by providing with valid data

  Background: Precondition of US_076 User goes to add address at My Events and Enter City name
    Given User login as User Erdal
    And User goes to MyEvents Page
    And User clicks Create New Event
    And User click Add Button for new Address adding
    And User enter "Ingolstadt" as a city name

  Scenario Outline: TC_001 US_076 As a user, should able to add an address successfully by providing with valid data
    When user enters the informations in relateds input "<Address Title>" "<Address>" "<Postal>" and click Submit
    Then user should be able to see added address "<Toast Message>"
    Examples: Positive and negative some senarios
      | Address Title | Address                                      | Postal | Toast Message                   |
      |               |                                              |        | Your Address successfully added |
      | Home          | Regensburger Strasse 33, Ingolstadt, Germany | 85521  | Your Address successfully added |




