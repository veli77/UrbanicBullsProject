package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_014_RegisterNowButton_stepDefs extends CommonPage {
    @Then("The user goes to the register now button and checks the clickability of the button.")
    public void theUserGoesToTheRegisterNowButtonAndChecksTheClickabilityOfTheButton() {
        getHomePage().goToRegisterPage();
        getRegisterPage().registerPageCheck();
    }
}
