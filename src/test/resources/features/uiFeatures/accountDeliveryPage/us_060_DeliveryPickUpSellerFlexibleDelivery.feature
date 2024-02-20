@UI
Feature: TE of US_060 Delivery type-Seller flexible delivery input control
#  Delivery type-Seller flexible delivery
#  All menus in the relevant area should be functional and appropriate options should be selected.
#  Free Delivery Range (mile) should be 0-1000. Alert should be seen on different selections
#  Minimum Order Amount For Free Delivery($) should be 0-10000. Alert should be seen on different selections
#  Per Mile Cost ($) should be 0-5. Alert should be seen in different selections
#  Maximum Delivery Range (mile) should be 0-1000. Alert should be seen on different selections
#  A suitable day must be selected for the Order Begin menu.
#  Time menu should work correctly
#  A suitable day must be selected for the Order End menu.
#  Time menu should work correctly
#  A suitable day must be selected for the Deliver By menu
#  Time menu should work correctly
#  Your delivery settings have been succesfully updated alert should appear
  Scenario: TC_01 US_60 Delivery type-Seller flexible delivery Checkbox input control
    Given User logs in with Urbanic two credential
    And User click Delivery pick up settings menü
    And User click Seller flexible delivery Checkbox
    Then User should be able to see menus and inputs
    And User should be see Free Delivery Range input mile should be zero between thousand
    And User should be able to see Alert on different selections zero out of thousand
    And User should be able to see Minimum Order Amount For Free Delivery input zero between ten thousand
    Then User should be able to see Alert on different selections zero out of ten thousand
    And User should be able to see Per Mile Cost  should be zero between five
    Then User should be able to see Alert on different selections zero out of five
    And User should be able to see Maximum Delivery Range should be zero between thousand
    And User should be able to see Maximum Delivery Range input Alert on different selections zero between thousand
    Then User should be able to see A suitable day selected for the Order Begin menu
    Then User should be able to see Order Begin Time menu should work correctly
    Then User should be able to see A suitable day selected for the Order End menu
    Then User should be able to see Order End menu should work correctly
    Then User should be able to see A suitable day selected for the Deliver By menu
    Then User should be able to see Deliver By menu should work correctly
    When User click Update button
    Then User should be able to see "Your delivery settings have been successfully updated" alert should appear



