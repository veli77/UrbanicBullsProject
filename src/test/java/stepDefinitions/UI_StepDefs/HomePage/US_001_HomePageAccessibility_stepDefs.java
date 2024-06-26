package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CommonPage;
import utilities.ReusableMethods;

public class US_001_HomePageAccessibility_stepDefs extends CommonPage {
    @Then("home page should load successfully without errors")
    public void homePageShouldLoadSuccessfullyWithoutErrors() {
        ReusableMethods.verifyTitle("Get Your Locally Sourced Veggies&Fruits from neighbors | Urbanic Farm");
    }

    @And("user should see the main content of the home page")
    public void userShouldSeeTheMainContentOfTheHomePage() {

        ReusableMethods.verifyElementDisplayed(getHomePage().JoinTheMovementText);

    }
}
