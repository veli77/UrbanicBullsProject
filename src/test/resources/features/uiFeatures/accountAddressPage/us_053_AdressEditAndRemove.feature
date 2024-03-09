@UI @Erdal @US-53
Feature: TE of US_053 Adress Edit And Remove

    #*Non Selected Address*
    #*If addresses are added but not selected, "You have not set your sales address yet.
          # Please select one of your unselected addresses." alert will be displayed.*
    #*In the Others Address section, the address editing and deletion buttons should be operational.*
	#*The address should be corrected with the edit button and the process should be completed with the send button.*
    #*After clicking Submit, the alert Your address has been successfully updated should appear.*
	#Address should be removed with the Revoke option
	#Revoke should be clickable and alert should appear when Revoke is clicked
	#Are you sure you want to delete the address? alert should be displayed.
	#Yes/No options should appear.
	#One of the Yes/No options must be selected.
	#No option should cancel the action
	#Address should be removed when Yes option is selected
	#As a result of the operation, the address deleted warning should appear.
  Scenario: : TC_01 US_053 Login and goes Account Address Page then goes Others Section
    Given User login as User Erdal
    And User goes to AccountAddress Page
    Then User should be able to add or edit a sales address when there is not
      | Office | 33 Ingolstadt, Germany |  |  | 85039 | Ingolstadt |
    And User should be able to see the Toast Message
    And User should be able to enable Edit and Remove buttons
    And User should be able to click Remove button
    And User should be able to see Yes and No options
    And User should be able to see only Yes and No options
    And User should be able to click Yes option
    #And User should be able to see the Removed Address Toast Message
