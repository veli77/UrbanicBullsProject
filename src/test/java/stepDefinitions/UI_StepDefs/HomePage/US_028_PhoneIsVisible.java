package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;

public class US_028_PhoneIsVisible extends CommonPage {
    @Given("User goes to HomePage")
    public void userGoesToHomePage() {
        getHomePage().goesToTestUrbanicFarmHomePage();
    }


    @When("User scroll down the page")
    public void userScrollDownThePage() {
       getHomePage().goesToDeepAtTheHomePage();
    }

    @Then("User should be able to see phone number")
    public void userShouldBeAbleToSeePhoneNumber() {
        Assert.assertTrue(getHomePage().PhoneNumber.isDisplayed());
    }
}
