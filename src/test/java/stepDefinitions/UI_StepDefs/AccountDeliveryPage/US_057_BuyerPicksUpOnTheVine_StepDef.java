package stepDefinitions.UI_StepDefs.AccountDeliveryPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class US_057_BuyerPicksUpOnTheVine_StepDef extends CommonPage {
    @Given("User clicks on Delivery Page button")
    public void userClicksOnDeliveryPageButton() {
       getAccountDeliveryPage().DeliveryPageButton.click();
    }

    @Then("The Buyer picks up on the vine checkbox should be clickable")
    public void theBuyerPicksUpOnTheVineCheckboxShouldBeClickable() {
       getAccountDeliveryPage().BuyerPicksUpOnTheVineCheckBox.isEnabled();
    }

    @When("User clicks on the Buyer picks up on the vine checkbox")
    public void userClicksOnTheBuyerPicksUpOnTheVineCheckbox() {
        ReusableMethods.waitFor(3);
        ReusableMethods.selectCheckBox(getAccountDeliveryPage().BuyerPicksUpOnTheVineCheckBox,true);
    }

    @Then("Your available hours menu functional and visible")
    public void yourAvailableHoursMenuFunctionalAndVisible() {
        getAccountDeliveryPage().YourAvailableHoursText.isDisplayed();
    }

    @When("User chooses same hours")
    public void userChoosesSameHours() {
        getAccountDeliveryPage().StartTimeBuyerPicksUpOntheVine.clear();
        getAccountDeliveryPage().StartTimeBuyerPicksUpOntheVine.sendKeys("08:00");
        getAccountDeliveryPage().EndTimeBuyerPicksUpOntheVine.clear();
        getAccountDeliveryPage().EndTimeBuyerPicksUpOntheVine.sendKeys("08:00");
        getAccountDeliveryPage().UpdateButton.click();
    }

    @Then("Start and end time cannot be same at the Buyer picks up on the vine field alert appears")
    public void startAndEndTimeCannotBeSameAtTheBuyerPicksUpOnTheVineFieldAlertAppears() {
        ReusableMethods.waitFor(3);
        getAccountDeliveryPage().AlertText.isDisplayed();
        Assert.assertEquals("Start and end time cannot be same at the Buyer picks up on the vine field.",getAccountDeliveryPage().AlertText.getText());
    }

    @When("User chooses start time late than end time")
    public void userChoosesStartTimeLateThanEndTime() {
        ReusableMethods.waitFor(3);
        getAccountDeliveryPage().StartTimeBuyerPicksUpOntheVine.clear();
        getAccountDeliveryPage().StartTimeBuyerPicksUpOntheVine.sendKeys("08:01");
        getAccountDeliveryPage().EndTimeBuyerPicksUpOntheVine.clear();
        getAccountDeliveryPage().EndTimeBuyerPicksUpOntheVine.sendKeys("08:00");
        getAccountDeliveryPage().UpdateButton.click();
    }

    @Then("Start time cannot be greater than end time at the Buyer picks up on the vine field alert appears")
    public void startTimeCannotBeGreaterThanEndTimeAtTheBuyerPicksUpOnTheVineFieldAlertAppears() {
        ReusableMethods.waitFor(3);
        getAccountDeliveryPage().AlertText.isDisplayed();
        Assert.assertEquals("Start time cannot be greater than end time at the Buyer picks up on the vine field.",getAccountDeliveryPage().AlertText.getText());
    }

    @When("User selects suitable hours")
    public void userSelectsSuitableHours() {
        ReusableMethods.waitFor(3);
        getAccountDeliveryPage().StartTimeBuyerPicksUpOntheVine.clear();
        getAccountDeliveryPage().StartTimeBuyerPicksUpOntheVine.sendKeys("08:00");
        getAccountDeliveryPage().EndTimeBuyerPicksUpOntheVine.clear();
        getAccountDeliveryPage().EndTimeBuyerPicksUpOntheVine.sendKeys("08:01");
        getAccountDeliveryPage().UpdateButton.click();
    }

    @Then("Your delivery settings have been successfully updated alert appears")
    public void yourDeliverySettingsHaveBeenSuccessfullyUpdatedAlertAppears() {
        ReusableMethods.waitFor(3);
        getAccountDeliveryPage().AlertText.isDisplayed();
        Assert.assertEquals("Your delivery settings have been successfully updated",getAccountDeliveryPage().AlertText.getText());
        ReusableMethods.selectCheckBox(getAccountDeliveryPage().BuyerPicksUpOnTheVineCheckBox,false);
        getAccountDeliveryPage().UpdateButton.click();
    }
}
