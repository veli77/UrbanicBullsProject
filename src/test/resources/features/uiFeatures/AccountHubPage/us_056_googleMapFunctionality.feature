Feature: US_056 TC_001 User User can use maps fuctions

	@UI
		@Login
	@TEST_BU-199
	Scenario: US_056 TC_001 User can use maps fuctions
		When User click to Address button, user can see related page
		And Zoom buttons should be clickable.
		Then User click to View Larger Map link, user can reach related page.
		Then User click to satellite screen box, map should change.
		Then User click to park or forest area name, user can see a label related area.
		
