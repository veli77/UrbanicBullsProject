package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;

import static stepDefinitions.Hooks.driver;
import static utilities.ConfigurationReader.properties;

public class US_038_UserLoginsWithValidInformation extends CommonPage {
    @Then("User goes to login page")
    public void userGoesToLoginPage() {
        getHomePage().LoginBtnAtButton.click();
    }

    @Given("Email address and password buttons are functional")
    public void emailAddressAndPasswordButtonsAreFunctional() {
        Assert.assertTrue(getLoginPage().input_email.isEnabled());
        Assert.assertTrue(getLoginPage().input_password.isEnabled());
    }

    @Then("User enters valid email and password")
    public void userEntersValidEmailAndPassword() {
        getLoginPage().input_email.sendKeys(properties.getProperty("user5_email"));
        getLoginPage().input_password.sendKeys(properties.getProperty("user5_password"));
        getLoginPage().submit_button.click();
    }

    @Then("User successfully logs in after valid information is entered")
    public void userSuccessfullyLogsInAfterValidInformationIsEntered() {
        Assert.assertTrue(getSellShareTradePage().LogoutBtn_SellShareTradePage.isDisplayed());
    }
}
