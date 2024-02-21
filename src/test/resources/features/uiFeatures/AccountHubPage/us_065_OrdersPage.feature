Feature: US_065 TC_001 Orders Page functionalities

	#The user should use functionalities in Orders Page.
	@UI
	@Login
	@TEST_BU-224
	Scenario: US_065 TC_001 Orders Page functionalities
		And User can click the "Orders" button on the left side bar in Account Page and verify that user is in the Orders Page
		And User can select any order
		And User can click View order details button for selected order
		And User can see the order details page and order summary
		And User can click Seller Page button in Order Details page and can reach related page.
		And User can navigate to previous page
		And User can click seller's address map
		Then Verify seller map matches with the larger map
		
