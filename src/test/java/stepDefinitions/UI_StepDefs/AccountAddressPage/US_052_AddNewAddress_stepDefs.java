package stepDefinitions.UI_StepDefs.AccountAddressPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class US_052_AddNewAddress_stepDefs extends CommonPage {
    @Then("User must verify that the Add New Address page appears")
    public void userMustVerifyThatTheAddNewAddressPageAppears() {
        Assert.assertTrue(getAccountAddressPage().SearchPlacesInput.isDisplayed());
    }

    @And("Mark as User Address Title, Address, State, City, Post Post and Delivery address,You should see Mark as sales address options")
    public void markAsUserAddressTitleAddressStateCityPostPostAndDeliveryAddressYouShouldSeeMarkAsSalesAddressOptions() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(getAccountAddressPage().AddressDetailsPage.getLast().isDisplayed());

    }

    @Then("User must verify that all headers are functional and appendable")
    public void userMustVerifyThatAllHeadersAreFunctionalAndAppendable() throws InterruptedException {
        getAccountAddressPage().verifyAllHeaders();
    }

    @And("User should click on submit button on Add New Address page")
    public void userShouldClickOnSubmitButtonOnAddNewAddressPage() {
        getAccountAddressPage().clickAddNewAddressSubmit();

    }

    @And("User selected the {string} button")
    public void userSelectedTheButton(String option) {
        getAccountAddressPage().clickMarkAsDeliveryAndMarkAsDelivery(option);
    }

    @When("User click to {string} btn at the button")
    public void userClickToBtnAtTheButton(String AddressPage) {
        getAccountAddressPage().clickPagesBtn(AddressPage);
    }

    @Then("User verifies that sees the address added in the section selected.")
    public void userVerifiesThatSeesTheAddressAddedInTheSectionSelected() {
        Assert.assertTrue(getAccountAddressPage().DeliveryAndSalesRegisteredAddress.isDisplayed());
    }

    @And("User enter zip code")
    public void userEnterZipCode() {
        getAccountAddressPage().sendKeysZipCode1();
    }

    @And("User must click on add new address submit button")
    public void userMustClickOnAddNewAddressSubmitButton() {
        JSUtils.clickElementByJS(getAccountAddressPage().AddNewAddressSubmitButton);
    }

    @And("User selected the options button")
    public void userSelectedTheOptionsButton() {
        getAccountAddressPage().clickMarkAsDeliveryAndMarkAsDelivery("isSellerAddress");
        getAccountAddressPage().clickMarkAsDeliveryAndMarkAsDelivery("isDefault");
    }
}
