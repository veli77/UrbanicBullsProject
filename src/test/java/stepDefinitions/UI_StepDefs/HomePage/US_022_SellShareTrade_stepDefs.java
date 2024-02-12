package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.*;

import org.junit.Assert;
import pages.HomePage;

import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_022_SellShareTrade_stepDefs extends HomePage {
    @When("User clicks on the Features Sell-Share-Trade button")
    public void userClicksOnTheFeaturesSellShareTradeButton() {
        ReusableMethods.hover(getHomePage().SellShareTradeBtnAtButon);
        getHomePage().SellShareTradeBtnAtButon.click();

    }

    @Then("User Verify that the Sell-Share-Trade page is displayed")
    public void userVerifyThatTheSellShareTradePageIsDisplayed() {
        Assert.assertTrue(driver.getTitle().contains("Get Your Locally Sourced Veggies&Fruits from neighbors"));

    }
}
