package stepDefinitions.UI_StepDefs.AccountAddressPage;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;

public class US_054_DeliveryAddressEditAndRemoveFunctionality extends CommonPage {

    @Given("User logins as UserOne")
    public void userLoginsAsUserOne() {
        getLoginPage().login(USERCREDENTIAL. USER1);
    }

    @When("User goes to Delivery Address Section in Account Address Section")
    public void userGoesToDeliveryAddressSectionInAccountAddressSection() {
        getAccountAddressPage().clickDeliveryAddressSection();

    }


    @When("User should be able to see edit and remove buttons are visible")
    public void userShouldBeAbleToSeeEditAndRemoveButtonsAreVisible() {
        getAccountAddressPage().editAndRemoveBtnsCheck();
    }

    @Then("User should be check addresses are same before and after edit button click")
    public void userShouldBeCheckAddressesAreSameBeforeAndAfterEditButtonClick() {
        getAccountAddressPage().checkAddressesBeforeAndAfterClickEdit();
    }

    @Then("User Should be able to click No for cancel remove")
    public void userShouldBeAbleToClickNoForCancelRemove() {
        getAccountAddressPage().clickNoForCancel();
    }
}
