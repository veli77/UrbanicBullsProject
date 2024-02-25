Feature: TC_001 [US_70_WElcome Page]Order statuses must be seen in mutual buyer-seller accounts

	Background:
		Given User goes to homepage

	#*US_70_As a user, after entering valid information, I should be able to perform various actions in the Welcome Page*
	@UI @TEST_BU-219
	Scenario: TC_001 [US_70_WElcome Page]Order statuses must be seen in mutual buyer-seller accounts
		Given User logs in as buyer
		And User enters cart
		And User adds order on cart page
		And User completes the purchase
		Then Order placed by the user is seen in the Orders section.
		Then Buyer see order message
		And Login as a seller
		Then Seller sees buyer's orders




