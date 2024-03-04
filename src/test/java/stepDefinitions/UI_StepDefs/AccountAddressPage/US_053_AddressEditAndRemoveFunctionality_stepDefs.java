package stepDefinitions.UI_StepDefs.AccountAddressPage;

import enums.USERCREDENTIAL;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;

public class US_053_AddressEditAndRemoveFunctionality_stepDefs extends CommonPage {

    @When("User goes to AccountAddress Page")
    public void userGoesToAccountAddressPage() {
        getAccountWeeklyOrderPage().clickAddressBtnAtTheLeftBar();
    }

    @Then("User should be able to see the Toast Message")
    public void userShouldBeAbleToSeeTheToastMessage() {
        getAccountAddressPage().getToastMsj();
    }

    @And("User should be able to click Remove button")
    public void userShouldBeAbleToClickRemoveButton() {
        getAccountAddressPage().clickRemoveBtn();
    }

    @And("User should be able to see Yes and No options")
    public void userShouldBeAbleToSeeYesAndNoOptions() {
        getAccountAddressPage().controlYesNoOptions();
    }

    @And("User should be able to see only Yes and No options")
    public void userShouldBeAbleToSeeOnlyYesAndNoOptions() {
        getAccountAddressPage().controlOnly2Btns();
    }

    @And("User should be able to click Yes option")
    public void userShouldBeAbleToClickYesOption() {
        getAccountAddressPage().clickRemoveYesBtn();
    }

    @And("User should be able to see the Removed Address Toast Message")
    public void userShouldBeAbleToSeeTheRemovedAddressToastMessage() {
        getAccountAddressPage().getToastMsj();
    }


    @Then("User should be able to add or edit a sales address when there is not")
    public void userShouldBeAbleToAddOrEditASalesAddressWhenThereIsNot(DataTable dataTable) {
        getAccountAddressPage().addOrEditAnAddressIfThereIsNot(dataTable);
    }

    @And("User should be able to enable Edit and Remove buttons")
    public void userShouldBeAbleToEnableEditAndRemoveButtons() {
        getAccountAddressPage().clickMySalesAddressBtn();
        getAccountAddressPage().enableEditRemoveBtns();
    }
}
