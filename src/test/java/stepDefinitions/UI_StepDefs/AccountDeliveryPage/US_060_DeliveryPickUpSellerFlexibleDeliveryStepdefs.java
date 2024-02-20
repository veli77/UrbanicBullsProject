package stepDefinitions.UI_StepDefs.AccountDeliveryPage;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.ReusableMethods;

public class US_060_DeliveryPickUpSellerFlexibleDeliveryStepdefs extends CommonPage {
    @Given("User logs in with Urbanic two credential")
    public void userLogsInWithUrbanicTwoCredential() {
        getLoginPage().login(USERCREDENTIAL.USER2);

    }

    @And("User click Delivery pick up settings menü")
    public void userClickDeliveryPickUpSettingsMenü() {
        ReusableMethods.clickElement(getAccountDeliveryPage().DeliveryPickUpMenu);
    }

    @And("User click Seller flexible delivery Checkbox")
    public void userClickSellerFlexibleDeliveryCheckbox() {
    }

    @Then("User should be able to see menus and inputs")
    public void userShouldBeAbleToSeeMenusAndInputs() {
    }

    @And("User should be see Free Delivery Range input mile should be zero between thousand")
    public void userShouldBeSeeFreeDeliveryRangeInputMileShouldBeZeroBetweenThousand() {
    }

    @And("User should be able to see Alert on different selections zero out of thousand")
    public void userShouldBeAbleToSeeAlertOnDifferentSelectionsZeroOutOfThousand() {
    }

    @And("User should be able to see Minimum Order Amount For Free Delivery input zero between ten thousand")
    public void userShouldBeAbleToSeeMinimumOrderAmountForFreeDeliveryInputZeroBetweenTenThousand() {
    }

    @Then("User should be able to see Alert on different selections zero out of ten thousand")
    public void userShouldBeAbleToSeeAlertOnDifferentSelectionsZeroOutOfTenThousand() {
    }

    @And("User should be able to see Per Mile Cost  should be zero between five")
    public void userShouldBeAbleToSeePerMileCostShouldBeZeroBetweenFive() {
    }

    @Then("User should be able to see Alert on different selections zero out of five")
    public void userShouldBeAbleToSeeAlertOnDifferentSelectionsZeroOutOfFive() {
    }

    @And("User should be able to see Maximum Delivery Range should be zero between thousand")
    public void userShouldBeAbleToSeeMaximumDeliveryRangeShouldBeZeroBetweenThousand() {
    }

    @And("User should be able to see Maximum Delivery Range input Alert on different selections zero between thousand")
    public void userShouldBeAbleToSeeMaximumDeliveryRangeInputAlertOnDifferentSelectionsZeroBetweenThousand() {
    }

    @Then("User should be able to see A suitable day selected for the Order Begin menu")
    public void userShouldBeAbleToSeeASuitableDaySelectedForTheOrderBeginMenu() {
    }

    @Then("User should be able to see Order Begin Time menu should work correctly")
    public void userShouldBeAbleToSeeOrderBeginTimeMenuShouldWorkCorrectly() {
    }

    @Then("User should be able to see A suitable day selected for the Order End menu")
    public void userShouldBeAbleToSeeASuitableDaySelectedForTheOrderEndMenu() {
    }

    @Then("User should be able to see Order End menu should work correctly")
    public void userShouldBeAbleToSeeOrderEndMenuShouldWorkCorrectly() {
    }

    @Then("User should be able to see A suitable day selected for the Deliver By menu")
    public void userShouldBeAbleToSeeASuitableDaySelectedForTheDeliverByMenu() {
    }

    @Then("User should be able to see Deliver By menu should work correctly")
    public void userShouldBeAbleToSeeDeliverByMenuShouldWorkCorrectly() {
    }

    @When("User click Update button")
    public void userClickUpdateButton() {
    }

    @Then("User should be able to see {string} alert should appear")
    public void userShouldBeAbleToSeeAlertShouldAppear(String arg0) {
    }
}
