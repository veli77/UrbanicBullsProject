@BU-2 @smoke
@UI
  Feature: Home Page Headers Verification
      #Homepage should contain various headers from left to right:
      # 'Support the local food movement, Blog, Farmers Market, Explore, About Us, Contact Us, Login, Register'
    @TEST_BU-79
    Scenario: User should be able to see the various titles when I enter the homepage
      Given User goes to homepage
      Then the user should see the Support the local food movement and following headers from left to right:
      | Blog                         |
      | Farmers Market               |
      | Explore                      |
      | About Us                     |
      | Contact Us                   |
      | Login                        |
      | Register                     |





