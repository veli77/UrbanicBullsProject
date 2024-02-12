package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;

public class US_025_PrivacyPolicyBtn_stepDefs extends CommonPage {
    @When("User click to Privacy Policy buton at the botton")
    public void userClickToPrivacyPolicyButonAtTheBotton() {
        getHomePage().clickPrivacyPolicyBtn();
    }

    @Then("User should be able to see Privacy Policy page")
    public void userShouldBeAbleToSeePrivacyPolicyPage() {
        getPrivacyPolicyPage().amIinPrivacyPolicyPage();
    }
}
