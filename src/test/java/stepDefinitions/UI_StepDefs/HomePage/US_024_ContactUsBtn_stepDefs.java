package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_024_ContactUsBtn_stepDefs extends CommonPage {
    @Given("User goes to homepage")
    public void userGoesToHomepage() {
        driver.get("https://test.urbanicfarm.com/");
        ReusableMethods.waitForPageToLoad(5);
    }

    @When("User click to Contact US btn at the botton")
    public void userClickToContactUSBtnAtTheBotton() {
        ReusableMethods.hover(getHomePage().ContactUsBtnAtBotton);
        ReusableMethods.staleElementSolution(getHomePage().ContactUsBtnAtBotton);
        getHomePage().ContactUsBtnAtBotton.click();
    }

    @Then("User should be able to see Contact Us page")
    public void userShouldBeAbleToSeeContactUsPage() {
        ReusableMethods.waitForPageToLoad(5);
        Assert.assertEquals("https://test.urbanicfarm.com/contact-us", driver.getCurrentUrl());
        Assert.assertTrue(getContactUsPage().getInTouchText.isDisplayed());
    }

}
