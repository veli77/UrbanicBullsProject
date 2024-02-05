package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.JSUtils;

import static stepDefinitions.Hooks.driver;

public class US_012_RegisterNowButton extends CommonPage {
    @Then("Backyard gardeners and farmers join the Movement For Free! is visible")
    public void backyardGardenersAndFarmersJoinTheMovementForFreeIsVisible() {
        Assert.assertTrue(getHomePage().BackyardGardeners.isDisplayed());
    }
    @When("User clicks on the Register Now button")
    public void userClicksOnTheRegisterNowButton() {
        JSUtils.clickElementByJS(getHomePage().RegisterNowButton);
    }
    @Then("User is able to reach to relevant Register Now Page")
    public void userIsAbleToReachToRelevantRegisterNowPage() {
        Assert.assertEquals("https://test.urbanicfarm.com/auth/register", driver.getCurrentUrl());
    }
}
