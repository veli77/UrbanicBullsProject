@BU-69
Feature: Test Execution of US028

	#*Phone should be visible*
	@TEST_BU-68
		@UI
	Scenario: TC01_US028 Phone should be visible at the botton bar
		Given User goes to HomePage
		When User scroll down the page
		Then User should be able to see phone number
		
