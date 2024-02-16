 @UI @BU-205 @Erdal
 Feature: TE of US_053 Adress Edit And Remove

   Background: Precondition of US_053 Login and goes Account Address Page then goes Others Section
     Given User logins
     When User goes to AccountAddress Page
     When User goes to Others Section in Account Address Section

    #*Non Selected Address*
    #*If addresses are added but not selected, "You have not set your sales address yet.
          # Please select one of your unselected addresses." alert will be displayed.*
    #*In the Others Address section, the address editing and deletion buttons should be operational.*
	#*The address should be corrected with the edit button and the process should be completed with the send button.*
   @TEST_BU-203 @TESTSET_BU-186
   Scenario: TC_01 US_053 User should be able to see the saved address
     When User hat any saved Address user add new address
       | Office | 33 Ingolstadt, Germany |  |  | 85039 | Ingolstadt |
     Then User should be able to see the warning text when user hat any seller address in My Sales Address Section
     And User should be able to enable Edit and Remove buttons in Others Section

    #*After clicking Submit, the alert Your address has been successfully updated should appear.*
	#Address should be removed with the Revoke option
	#Revoke should be clickable and alert should appear when Revoke is clicked
	#Are you sure you want to delete the address? alert should be displayed.
	#Yes/No options should appear.
	#One of the Yes/No options must be selected.
	#No option should cancel the action
	#Address should be removed when Yes option is selected
	#As a result of the operation, the address deleted warning should appear.
   @TEST_BU-204 @TESTSET_BU-186
   Scenario: TC_02 US_053 User should be able to edit and remove address
     When User edit a new address
       | Home | 39 Ingolstadt, Germany |  |  | 85033 |
     Then User should be able to see the Toast Message
     And User should be able to click Remove button
     And User should be able to see Yes and No options
     And User should be able to see only Yes and No options
     And User should be able to click Yes option
     And User should be able to see the Removed Address Toast Message