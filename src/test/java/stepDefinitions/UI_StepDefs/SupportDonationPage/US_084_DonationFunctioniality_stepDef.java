package stepDefinitions.UI_StepDefs.SupportDonationPage;

import enums.URL_LINKS;
import enums.USERCREDENTIAL;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;

public class US_084_DonationFunctioniality_stepDef extends CommonPage {
    @Given("User login product environment")
    public void userLoginProductEnvironment() {
    getLoginPage().login(USERCREDENTIAL.REALUSER, URL_LINKS.REAL_LOGIN_URL);
    }

    @When("User goes to support page")
    public void userGoesToSupportPage() {
        getSupportDonationPage().clickDonationSupportButton();
    }

    @Then("User should be able to reach {string}")
    public void userShouldBeAbleToReach(String expectedUrl) {
        getSupportDonationPage().controlDonationPage(expectedUrl);
    }

    @When("User makes {string} $ donation")
    public void userMakes$Donation(String donationAmount) {
        getSupportDonationPage().sendDonation(donationAmount);
    }

    @Then("User should be able to make donation {string}")
    public void userShouldBeAbleToMakeDonation(String donationAmount) {
        getSupportDonationPage().controlDonationAmount(donationAmount);
    }


    @Then("User should not be able to make donation")
    public void userShouldNotBeAbleToMakeDonation() {
    }
}
