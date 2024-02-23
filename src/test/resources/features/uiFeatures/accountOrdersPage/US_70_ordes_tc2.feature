Feature: TC_002[US_70_Orders] Seller, order status should be updated in cart

	Background:
		Given User goes to homepage
	#US-70
	@UI @TEST_BU-222
	Scenario: TC_002[US_70_Orders] Seller, order status should be updated in cart
		Given Login as a buyer
		Then Orders can be changed (increased, decreased) in the cart section.
		Then New orders can be added to the cart section.
		
