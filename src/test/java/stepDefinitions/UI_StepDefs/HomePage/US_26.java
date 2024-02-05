package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_26 extends CommonPage {



    public void userClickToTermsOfService() {
        JSUtils.scrollDownByJS();
        getHomePage().TermOfService.isDisplayed();
        ReusableMethods.waitFor(5);
        getHomePage().TermOfService.click();
    }

//    @Then("User should be able to see relevant page")
//    public void userShouldBeAbleToSeeRelevantPage() throws InterruptedException {
//        Thread.sleep(3);
//        Assert.assertEquals("https://test.urbanicfarm.com/terms-of-service",driver.getCurrentUrl());
//        Assert.assertTrue(getHomePage().TermOfServiceIsDiplayed.isDisplayed());
//    }
}
