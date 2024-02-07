
Feature: US_042_TC_001: After logging in, the user should be able to see the segments on the left side of the account page.

	#After logging in with a valid e-mail address, the user should be able to see the Account, Address, Delivery & Pickup settings, Orders, Events, My Events, Scheduled Delivery, Delivery Scheduler tabs.
	@TEST_BU-95
		@UI
		#@Login
	Scenario: US_042_TC_001: After logging in, the user should be able to see the segments on the left side of the account page.
		Given User goes to homepage
		And user goes to Login Page
		Then The user should see leftside tabs
		| Account |
		| Address |
		| Delivery & Pick up settings |
		| Orders |
		| Events |
		| My Events |
		| Scheduled Delivery |
		| Delivery Scheduler |

		
