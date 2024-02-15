package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;

public class US_031_LinkedInBtn_stepDefs extends CommonPage {
    @When("User click the LinkedIn")
    public void userClickTheLinkedIn() {
        getHomePage().clickLinkedInIcon();
    }

    @Then("User should be able to click LinkedIn button")
    public void userShouldBeAbleToClickLinkedInButton() {
        Assert.assertTrue(getHomePage().amIinRightPage("LinkedIn"));
    }
}
