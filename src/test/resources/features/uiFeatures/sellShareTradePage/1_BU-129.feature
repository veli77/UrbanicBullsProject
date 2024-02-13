
Feature: TE_43 [US_43 - As a user, after entering valid information, I should be able to perform various operations on the Sale-Pay-Trade page.]

	#Contact us should be clickable and relevant page should be visible
	@TEST_BU-129 @TESTSET_BU-61
	Scenario: TC_01 [US_43 - As a user, after entering valid information, I should be able to perform various operations on the Sale-Pay-Trade page.]
		#Given User goes to homepage
		  #  When User clicks on Login module
		  #  And User logs in
		    When User clicks on Sell-Share-Trade module
		    When User clicks on Contact Us module
		    Then User should be able to see Contact Us page
		
