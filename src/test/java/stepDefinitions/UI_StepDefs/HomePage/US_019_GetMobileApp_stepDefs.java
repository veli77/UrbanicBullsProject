package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_019_GetMobileApp_stepDefs extends CommonPage {
    @When("User clicks on the Get The App button")
    public void userClicksOnTheGetTheAppButton() {
        //JSUtils.scrollDownByJS();
        ReusableMethods.hover(getHomePage().GetTheApp);
        getHomePage().GetTheApp.click();
    }

    @Then("User is able to reach to the relevant page of Mobile App")
    public void userIsAbleToReachToTheRelevantPageOfMobileApp() {
        Assert.assertEquals("https://test.urbanicfarm.com/mobile", driver.getCurrentUrl());
    }
}
