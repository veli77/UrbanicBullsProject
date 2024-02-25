package stepDefinitions.UI_StepDefs.AccountDeliveryPage;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

public class US_058_DeliveryType_BuyerPicksUpStepdefs extends CommonPage {

    @Given("User logs in with valid Credential Two")
    public void userLogsInWithValidCredentialTwo() {
        getLoginPage().login(USERCREDENTIAL.USER2);
    }

    @When("User clicks Delivery Pick up settings menu")
    public void userClicksDeliveryPickUpSettingsMenu() {
        ReusableMethods.waitFor(2);
        getHomePage().deliveryPickupSettings.click();
    }

    @And("Deselect all checkboxes in the Delivery Type")
    public void deselectAllCheckboxesInTheDeliveryType() {
        getDeliveryAndPickupSettings().unCheckDeliverySettings();
    }


    @And("User clicks Buyer picks up")
    public void userClicksBuyerPicksUp() {
        getDeliveryAndPickupSettings().buyerPicksUp.click();

    }

    @Then("User should see that the Your Available Hours menu is functional")
    public void userShouldSeeThatTheYourAvailableHoursMenuIsFunctional() {
        getDeliveryAndPickupSettings().YourAvailableHours_BuyerPicksUp.isDisplayed();
    }


    @When("User selects suitable hours from the Your available hours menu")
    public void userSelectsSuitableHoursFromTheYourAvailableHoursMenu() {
        getDeliveryAndPickupSettings().StartTimeBuyerPicksUp.clear();
        getDeliveryAndPickupSettings().StartTimeBuyerPicksUp.sendKeys("10:00");
        getDeliveryAndPickupSettings().EndTimeBuyerPicksUp.clear();
        getDeliveryAndPickupSettings().EndTimeBuyerPicksUp.sendKeys("12:00");
    }


    @And("User clicks Update button")
    public void userClicksUpdateButton() {
        getDeliveryAndPickupSettings().update.click();
    }


    @Then("User should see the alert that Your delivery settings have been successfully updated")
    public void UserShouldSeeTheAlertThatYourDeliverySettingsHaveBeenSuccessfullyUpdated() {
        ReusableMethods.waitFor(3);
        getDeliveryAndPickupSettings().AlertText.isDisplayed();
        Assert.assertEquals("Your delivery settings have been successfully updated", getAccountDeliveryPage().AlertText.getText());
    }

    @When("User selects start time later than end time")
    public void userSelectsStartTimeLaterThanEndTime() {
        ReusableMethods.waitFor(3);
        getDeliveryAndPickupSettings().buyerPicksUp.click();
        getDeliveryAndPickupSettings().StartTimeBuyerPicksUp.clear();
        getDeliveryAndPickupSettings().StartTimeBuyerPicksUp.sendKeys("11:00");
        getDeliveryAndPickupSettings().EndTimeBuyerPicksUp.clear();
        getDeliveryAndPickupSettings().EndTimeBuyerPicksUp.sendKeys("07:00");
    }


    @Then("User should see the alert Start time cannot be greater than end time at the Buyer picks up field")
    public void userShouldSeeTheAlertStartTimeCannotBeGreaterThanEndTimeAtTheBuyerPicksUpField() {
        ReusableMethods.waitFor(3);
        getDeliveryAndPickupSettings().AlertText.isDisplayed();
        Assert.assertEquals("Start time cannot be greater than end time at the Buyer picks up field.", getAccountDeliveryPage().AlertText.getText());
    }
}
