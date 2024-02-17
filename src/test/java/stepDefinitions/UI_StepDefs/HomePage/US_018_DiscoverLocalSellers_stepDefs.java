package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.message.ReusableMessage;
import org.junit.Assert;
import pages.CommonPage;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_018_DiscoverLocalSellers_stepDefs extends CommonPage {
    @When("User clicks on the Discover Local Sellers Near You button")
    public void userClicksOnTheDiscoverLocalSellersNearYouButton() throws InterruptedException {
        //JSUtils.scrollDownByJS();
        //Thread.sleep(2000);
        ReusableMethods.hover(getHomePage().DiscoverLocalSellers);
        getHomePage().DiscoverLocalSellers.click();
    }

    @Then("User is able to reach to relevant page of Local Sellers")
    public void userIsAbleToReachToRelevantPageOfLocalSellers() {
        Assert.assertEquals("https://test.urbanicfarm.com/explore", driver.getCurrentUrl());
    }
}
