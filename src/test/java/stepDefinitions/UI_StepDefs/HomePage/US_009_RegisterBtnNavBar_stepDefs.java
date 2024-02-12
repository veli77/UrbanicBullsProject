package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_009_RegisterBtnNavBar_stepDefs extends CommonPage {


    @Then("User should be able to see Register page")
    public void userShouldBeAbleToSeeRegisterPage() {
        ReusableMethods.waitForPageToLoad(5);
        Assert.assertEquals("https://test.urbanicfarm.com/auth/register",driver.getCurrentUrl());




    }
}
