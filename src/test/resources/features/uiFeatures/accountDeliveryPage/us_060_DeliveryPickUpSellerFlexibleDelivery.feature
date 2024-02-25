#Delivery type-Seller flexible delivery
#All menus in the relevant area should be functional and appropriate options should be selected.
#Free Delivery Range (mile) should be 0-1000. Alert should be seen on different selections
#Minimum Order Amount For Free Delivery($) should be 0-10000. Alert should be seen on different selections
#Per Mile Cost ($) should be 0-5. Alert should be seen in different selections
#Maximum Delivery Range (mile) should be 0-1000. Alert should be seen on different selections
#A suitable day must be selected for the Order Begin menu.
#Time menu should work correctly
#A suitable day must be selected for the Order End menu.
#Time menu should work correctly
#A suitable day must be selected for the Deliver By menu
#Time menu should work correctly
#Your delivery settings have been succesfully updated alert should appear


@UI @BU-257

Feature: TE of US_060 Delivery type-Seller flexible delivery input control

  Background:
    Given User logs in with Urbanic two credential
    When user clicks on Account button
    And user clicks on delivery and pickup settings
    And unselect all checkbox
    And user clicks on seller flexible
    And enter some order times

  @TEST_BU-223 @TESTSET_BU-187
  Scenario: TC_01 US_60 Delivery type-Seller flexible delivery Checkbox input control
    Given user verifies web elements with following ids displays correct text
      | freeFlexibleDeliveryRange    | Free Delivery Range (mile) :                |
      | minFreeFlexibleDeliveryOrder | Minimum Order Amount For Free Delivery($) : |
      | perMileCostFlex              | Per Mile Cost ($) :                         |
      | maxFlexibleDeliveryRange     | Maximum Delivery Range (mile) :             |

    Then user verifies web elements with following ids input
      | freeFlexibleDeliveryRange    |
      | minFreeFlexibleDeliveryOrder |
      | perMileCostFlex              |
      | maxFlexibleDeliveryRange     |

    Then user should see alert messages out of range input Free Delivery Range
      | -1    | Wert muss größer als oder gleich 0 sein. Value must be greater than or equal to 0.  |
      | 1001  | Wert muss kleiner als oder gleich 1000 sein. Value must be less than or equal to 1000.  |
      | -1    | Wert muss größer als oder gleich 0 sein. Value must be greater than or equal to 0.  |
      | 10001 | Wert muss kleiner als oder gleich 1000 sein. Value must be less than or equal to 10000. |
      | -1    | Wert muss größer als oder gleich 0 sein. Value must be greater than or equal to 0.  |
      | 6     | Wert muss kleiner als oder gleich 5 sein. Value must be less than or equal to 5.     |
      | -1    | Wert muss größer als oder gleich 0 sein. Value must be greater than or equal to 0.  |
      | 1001  | Wert muss kleiner als oder gleich 1000 sein. Value must be less than or equal to 1000.  |

    When user enter address fields

    Then days should be appropriate
      | OrderBegin | OrderEnd | Delivery  | ErrorMessage                                                                     | isOK  |
      | Monday     | Tuesday  | Wednesday | Your delivery settings have been successfully updated                            | true  |
      | Tuesday    | Monday   | Thursday  | At the 1. line, The end time of order must be later than the start time of order | false |
      | Saturday   | Monday   | Monday    | At the 1. line, The end time of order must be later than the start time of order | false |
      | Tuesday    | Thursday | Sunday    | Your delivery settings have been successfully updated                            | true  |

  @TEST_BU-232 @TESTSET_BU-187
  Scenario Template: TC_02 US_60 Delivery type-Seller flexible delivery time control

    Given user selects "<orderBegin>" for orderBegin
    And user enters input to order begin "<beginTime>"
    And user selects "<orderEnd>" for orderEnd
    And user enters input to order end "<endTime>"
    And user selects <deliverBy> for deliverBy
    And user enters input to deliver by "<deliverTime>"
    And user clicks on update button
    Then user verifies the toast message is "<toastMessage>"
    And local clear

    Scenarios:
      | orderBegin | beginTime | orderEnd | endTime | deliverBy | deliverTime | toastMessage                                                                     |
      | 6          | 0205pm    | 3        | 0306pm  | 2         | 0306pm      | At the 1. line, The end time of order must be later than the start time of order |
      | 2          | 0205pm    | 3        | 0205am  | 2         | 0306pm      | Your delivery settings have been successfully updated                            |
      | 3          | 0205pm    | 6        | 0306pm  | 2         | 0306pm      | Your delivery settings have been successfully updated                            |