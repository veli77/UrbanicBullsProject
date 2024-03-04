@BU-250 @Erdal
Feature:TE of US_062 Actions In Selected Product

    #Your products/services
	#Various products should be seen after the product/services clicked
	#One of the Approved-In, Review, Rejected options for each product should be visible on the file.
	#Product Name, Price, Stock, Unit information about previously added products should be displayed.
	#It should be possible to click on the product name on the file related to the previously added product.
	#When the product name is clicked, the update-delete page is displayed.
	#Product information should be able to be changed on this page
	#Organic, trade buttons should be functional
	#Update-Delete buttons should be functional
	#When the update option is clicked after the necessary corrections, (.....) has been succesfully updated alert should be displayed.
	#When the Delete button is clicked, yes/ no options should appear.
	#Yes/No options should appear.
	#One of the Yes/No options should be selected.
	#No option should cancel the operation
	#When Yes option is selected, the product should be removed from the page.
	#As a result of the operation, < Produck name>has been succesfully deleted alert should be displayed.
  @TEST_BU-249 @TESTSET_BU-188
  @UI @DB
  Scenario:TC_01 US_062 Actions In Selected Product
    Given User login as User Erdal
    Then user goes to Your products-services
    When user click on random Hubs
    And user verifies that Product Name, Price, Stock, Unit information  is displayed.
    And user verifies that APPROVED, IN_REVIEW, REJECTED options for each product should be visible
    And user add new product
    Then In-Review should be visible on the added product.
    When User approve last added product from database
    Then Approved should be visible on the added product.
    When user clicks previously added product name
    And user verifies that Update button is visible
    And user verifies that Delete button is visible
    And user verifies that Organic button is functional
    And user verifies that Trade button is functional
    And user verifies that Trade description is visible
    And user sends Selam to Trade input  description
    And user changes Price,Stocks,Unit type
    Then user clicks Update button
    And user verifies that Updated alert is visible
    When user proceeds forward, retrieves the count of products in the list, then returns back
    When user clicks Delete button
    And user verifies that Yes options is visible
    And user verifies that No options is visible
    And user selects no option and verifies that No option cancel the operation
    When user selects the Yes option and verifies that the last added product has been removed
    Then user verifies that deleting alert is displayed


