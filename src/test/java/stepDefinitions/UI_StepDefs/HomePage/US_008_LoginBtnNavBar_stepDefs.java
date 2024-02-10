package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Then;
import pages.CommonPage;
import utilities.ReusableMethods;
import org.junit.Assert;

import static stepDefinitions.Hooks.driver;

public class US_008_LoginBtnNavBar_stepDefs extends CommonPage {




    @Then("User should be able to see Login page")
    public void userShouldBeAbleToSeeLoginPage() {
        ReusableMethods.waitForPageToLoad(5);
        Assert.assertEquals("https://test.urbanicfarm.com/auth/login",driver.getCurrentUrl());
        Assert.assertTrue(getLoginPage().submit_button.isDisplayed());
    }
}
