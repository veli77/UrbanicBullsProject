@TEST_US_014
Feature: US_14 TC_001 "Register Now" button should be clickable.

	#The "Register Now" heading under the Contribution to the Environment and Society heading should be clickable
	@TEST_BU-136
		@UI
	Scenario: US_14 TC_001 "Register Now" button should be clickable.
		Given User goes to homepage
		Then The user goes to the register now button and checks the clickability of the button.
		
