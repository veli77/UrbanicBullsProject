@UI
Feature: US_036

  Scenario: As a user I should be able to successfully add zipcode

    Given User goes to HomePage
    And Click the "Login" button on the main Page
    And Login with credentials
      | testuser@deneme.com | Testuser1/. |

    Then Verify that zipCode entries match the expected result
#     | ZipCode | Expected |
      |         | false    |
      | 1       | false    |
      | 02      | false    |
      | 109     | false    |
      | 9999    | false    |
      | 10A23   | false    |
      | 6546452 | false    |
      | ?546452 | false    |
      | 54..2   | false    |
      | 95170   | true     |
