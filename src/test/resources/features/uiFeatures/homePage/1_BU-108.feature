@BU-109
Feature: TestExecution of US-007 Nav Bar Contact US btn feature

	#{{Contact Us should be clickable and relevant page should be visible}}
	@TEST_BU-108
	Scenario: TC 01 _ US-007 User should be able to perform various operations on homepage
		Given User goes to homepage
		    When User click to "Contact Us" btn at the navbar
		    Then User should be able to see Contact Us page
		
