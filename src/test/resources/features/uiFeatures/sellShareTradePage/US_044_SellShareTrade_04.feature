@UI
@headless
  Feature: US_044 - User should be able to perform various operations on the Sale-Pay-Trade page after login

    Scenario: Scheduled delivery should be clickable and relevant page should be visible

      Given User goes to HomePage
      And Click the "Login" button on the main Page
      And Login with credential as
        | testuser@deneme.com | Testuser1/. |

      And Click the Sell-Share-Trade button
      Then Verify Scheduled Delivery module can be accessible

