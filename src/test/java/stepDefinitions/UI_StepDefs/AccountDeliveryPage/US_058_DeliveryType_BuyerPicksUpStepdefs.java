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
        getAccountDeliveryPage().deliveryPickupSettings.click();
    }

    @And("Deselect all checkboxes in the Delivery Type")
    public void deselectAllCheckboxesInTheDeliveryType() {
        getAccountDeliveryPage().unCheckDeliverySettings();
    }


    @And("User clicks Buyer picks up")
    public void userClicksBuyerPicksUp() {
        getAccountDeliveryPage().buyerPicksUp.click();

    }

    @Then("User should see that the Your Available Hours menu is functional")
    public void userShouldSeeThatTheYourAvailableHoursMenuIsFunctional() {
        getAccountDeliveryPage().YourAvailableHours_BuyerPicksUp.isDisplayed();
    }


    @When("User selects suitable hours from the Your available hours menu")
    public void userSelectsSuitableHoursFromTheYourAvailableHoursMenu() {
        getAccountDeliveryPage().StartTimeBuyerPicksUp.clear();
        getAccountDeliveryPage().StartTimeBuyerPicksUp.sendKeys("10:00");
        getAccountDeliveryPage().EndTimeBuyerPicksUp.clear();
        getAccountDeliveryPage().EndTimeBuyerPicksUp.sendKeys("12:00");
    }


    @And("User clicks Update button")
    public void userClicksUpdateButton() {
        getAccountDeliveryPage().update.click();
    }


    @Then("User should see the alert that Your delivery settings have been successfully updated")
    public void UserShouldSeeTheAlertThatYourDeliverySettingsHaveBeenSuccessfullyUpdated() {
        ReusableMethods.waitFor(3);
        getAccountDeliveryPage().AlertText.isDisplayed();
        Assert.assertEquals("Your delivery settings have been successfully updated", getAccountDeliveryPage().AlertText.getText());
    }

    @When("User selects start time later than end time")
    public void userSelectsStartTimeLaterThanEndTime() {
        ReusableMethods.waitFor(3);
        getAccountDeliveryPage().buyerPicksUp.click();
        getAccountDeliveryPage().StartTimeBuyerPicksUp.clear();
        getAccountDeliveryPage().StartTimeBuyerPicksUp.sendKeys("11:00");
        getAccountDeliveryPage().EndTimeBuyerPicksUp.clear();
        getAccountDeliveryPage().EndTimeBuyerPicksUp.sendKeys("07:00");
    }


    @Then("User should see the alert Start time cannot be greater than end time at the Buyer picks up field")
    public void userShouldSeeTheAlertStartTimeCannotBeGreaterThanEndTimeAtTheBuyerPicksUpField() {
        ReusableMethods.waitFor(3);
        getAccountDeliveryPage().AlertText.isDisplayed();
        Assert.assertEquals("Start time cannot be greater than end time at the Buyer picks up field.", getAccountDeliveryPage().AlertText.getText());
    }
}
