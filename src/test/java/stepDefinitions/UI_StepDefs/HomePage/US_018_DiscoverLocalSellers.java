package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.JSUtils;

import static stepDefinitions.Hooks.driver;

public class US_018_DiscoverLocalSellers extends CommonPage {
    @When("User clicks on the Discover Local Sellers Near You button")
    public void userClicksOnTheDiscoverLocalSellersNearYouButton() {
        JSUtils.scrollDownByJS();
        getHomePage().DiscoverLocalSellers.click();
    }

    @Then("User is able to reach to relevant page of Local Sellers")
    public void userIsAbleToReachToRelevantPageOfLocalSellers() {
        Assert.assertEquals("https://test.urbanicfarm.com/explore", driver.getCurrentUrl());
    }
}
