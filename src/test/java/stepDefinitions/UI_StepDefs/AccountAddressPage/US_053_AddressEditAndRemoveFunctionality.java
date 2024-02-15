package stepDefinitions.UI_StepDefs.AccountAddressPage;

import enums.USERCREDENTIAL;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;

public class US_053_AddressEditAndRemoveFunctionality extends CommonPage {
    @Given("User logins")
    public void userLogins() {
        getLoginPage().login(USERCREDENTIAL.USERERDAL);
    }

    @When("User goes to AccountAddress Page")
    public void userGoesToAccountAddressPage() {
        getAccountWeeklyOrderPage().clickAddressBtnAtTheLeftBar();
    }

    @Then("User should be able to see the warning text when user hat any seller address in My Sales Address Section")
    public void userShouldBeAbleToSeeTheWarningTextWhenUserHatAnySellerAddressInMySalesAddressSection() {
        Assert.assertFalse(getAccountAddressPage().clickMySalesAddressBtnAndControlTheAdress());
    }

    @When("User goes to Others Section in Account Address Section")
    public void userGoesToOthersSectionInAccountAddressSection() {
        getAccountAddressPage().clickOthersSection();
    }

    @When("User hat any saved Address user add new address")
    public void userHatAnySavedAddressUserAddNewAddress(DataTable dataTable) {
        //List<String> list = ReusableMethods.turnDatatableFirstRowToAList(dataTable);
        getAccountAddressPage().areThereAnySavedAddressesInOdersSectionAndAdd(dataTable);
    }

    @Then("User should be able to enable Edit and Remove buttons in Others Section")
    public void userShouldBeAbleToEnableEditAndRemoveButtonsInOthersSection() {
        getAccountAddressPage().clickOthersSection();
        getAccountAddressPage().enableEditRemoveBtns();
    }

    @When("User edit a new address")
    public void userEditANewAddress(DataTable dataTable) {
        getAccountAddressPage().editAnAddress(dataTable);
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
}
