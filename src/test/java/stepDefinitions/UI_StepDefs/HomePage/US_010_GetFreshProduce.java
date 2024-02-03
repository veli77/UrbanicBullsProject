package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_010_GetFreshProduce extends CommonPage {
    @When("User clicks on the Get Fresh Produce button")
    public void userClicksOnTheGetFreshProduceButton() {

        getHomePage().GetFreshProduce.click();
    }

    @Then("User is able to reach to relevant get Fresh Produce page")
    public void userIsAbleToReachToRelevantGetFreshProducePage() {
        Assert.assertEquals("https://test.urbanicfarm.com/account/weekly-order", driver.getCurrentUrl());
    }
}
