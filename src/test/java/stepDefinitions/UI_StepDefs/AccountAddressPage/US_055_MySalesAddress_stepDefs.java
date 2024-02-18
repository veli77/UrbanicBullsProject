package stepDefinitions.UI_StepDefs.AccountAddressPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class US_055_MySalesAddress_stepDefs extends CommonPage {

    @When("User click to Address btn at the button")
    public void user_click_to_address_btn_at_the_button() throws InterruptedException {
        JSUtils.clickElementByJS(getAccountWeeklyOrderPage().AddressBtn);
        Thread.sleep(3000);
    }

    @Then("User must verify that the Address page appears")
    public void user_must_verify_that_the_address_page_appears() {
        getAccountAddressPage().verifyPageUrl("https://test.urbanicfarm.com/account/address");
    }

    @When("User click to My Sales Address btn at the button")
    public void user_click_to_my_sales_address_btn_at_the_button() throws InterruptedException {
        Thread.sleep(3000);
        JSUtils.clickElementByJS(getAccountAddressPage().MySalesAddressBtn);
    }

    @When("User click to Add New Address btn at the button")
    public void user_click_to_add_new_address_btn_at_the_button() throws InterruptedException {
        Thread.sleep(3000);
        JSUtils.clickElementByJS(getAccountAddressPage().AddNewAddressBtn);
    }

    @When("User must click on the add button that opens and enter a new address")
    public void user_must_click_on_the_add_button_that_opens_and_enter_a_new_address() throws InterruptedException {
        getAccountAddressPage().sendKeysAddress();
        getAccountAddressPage().addressOptions();
    }

    @And("User selected the Mark as a sales address button")
    public void userSelectedTheMarkAsASalesAddressButton() throws InterruptedException {
        Thread.sleep(3000);
        JSUtils.clickElementByJS(getAccountAddressPage().MarkAsASalerAddressInput);
    }

    @When("User must click on submit button")
    public void user_must_click_on_submit_button() {
getAccountAddressPage().MySalesAddressSubmitBtn.click();
    }

    @Then("Are you sure to delete the address confirms that the screen is turned on")
    public void areYouSureToDeleteTheAddressConfirmsThatTheScreenIsTurnedOn() {
        Assert.assertTrue(getAccountAddressPage().AreYouSureToDeleteTheAddressMessage.isDisplayed());
    }

    @Then("User should then see the message Your Address Successfully updated")
    public void userShouldThenSeeTheMessageYourAddressSuccessfullyUpdated() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(getAccountAddressPage().AlertYourAddresssuccessfullyAdded.isDisplayed());
    }

    @When("User goes to the address page and clicks the edit button")
    public void user_goes_to_the_address_page_and_clicks_the_edit_button() {
   JSUtils.clickElementByJS(getAccountAddressPage().MySalesAddressEditBtn);
    }

    @Then("User verifies that the address details page has opened")
    public void user_verifies_that_the_address_details_page_has_opened() {
       Assert.assertTrue(getAccountAddressPage().AddressDetailsPage.isDisplayed());
    }

    @When("User goes to the address page and clicks the remove button")
    public void user_goes_to_the_address_page_and_clicks_the_remove_button() throws InterruptedException {
        Thread.sleep(3000);
        JSUtils.clickElementByJS(getAccountAddressPage().MySalesAddressRemoveBtn);
    }

    @Then("User should see Yes and No options.")
    public void userShouldSeeYesAndNoOptions() {
        Assert.assertTrue(getAccountAddressPage().YesNoOptionsText.isDisplayed());
    }

    @Then("User then confirms that sees the Your address successfully updated notice")
    public void userThenConfirmsThatSeesTheYourAddressSuccessfullyUpdatedNotice() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(getAccountAddressPage().AlertYourAddresssuccessfullyUpdated.isDisplayed());
    }

    @When("User clicks on the edit button of the registered Address")
    public void user_clicks_on_the_edit_button_of_the_registered_address() {
        JSUtils.clickElementByJS(getAccountAddressPage().MySalesAddressEditBtn);
    }

    @When("Edits User Address details")
    public void edits_user_address_details() {
        getAccountAddressPage().sendKeysAddressTitle();
    }

    @When("User clicks on Submit button")
    public void user_clicks_on_submit_button() throws InterruptedException {
        ReusableMethods.hover(getAccountAddressPage().MySalesAddressSubmitBtn);
        getAccountAddressPage().MySalesAddressSubmitBtn.click();
      //JSUtils.clickElementByJS(getAccountAddressPage().MySalesAddressSubmitBtn);
    }
    @When("User clicks on Remove registered Address button")
    public void user_clicks_on_remove_registered_address_button() throws InterruptedException {
        JSUtils.clickElementByJS(getAccountAddressPage().MySalesAddressRemoveBtn);
        Thread.sleep(2000);
    }

    @And("Are you sure to delete the address? screen pops up")
    public void areYouSureToDeleteTheAddressScreenPopsUp() {
        Assert.assertTrue(getAccountAddressPage().YesNoOptionsText.isDisplayed());
    }

    @When("when the user clicks on the {string} button")
    public void when_the_user_clicks_on_the_button(String option) {
        getAccountAddressPage().areYouSureToDeleteYESorNO(option);
    }

    @Then("User cannot cancel the transaction and the visibility of the address is verified")
    public void user_cannot_cancel_the_transaction_and_the_visibility_of_the_address_is_verified() {
        Assert.assertTrue(getAccountAddressPage().MySalesAddressText.isDisplayed());
    }

    @And("User enter postal zip code")
    public void userEnterPostalZipCode() {
        getAccountAddressPage().sendKeysPostaZipCode();
    }

    @And("User clicks on Edit Submit button")
    public void userClicksOnEditSubmitButton() throws InterruptedException {
        Thread.sleep(2000);
        JSUtils.clickElementByJS(getAccountAddressPage().MySalesAddressEditSubmitBtn);
    }


}
