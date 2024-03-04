package stepDefinitions.UI_StepDefs.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

import static enums.URL_LINKS.LOGIN_URL;
import static stepDefinitions.Hooks.driver;

public class US_039_loginFail_stepDef extends CommonPage{
    @Given("Users go to login page")
    public void usersGoeToLoginPage(){
       driver.get(LOGIN_URL.getLink());
        ReusableMethods.waitForPageToLoad(2000);
    }

    @When("the Email address and password button is functional")
    public void theEmailAddressAndPasswordButtonIsFunctional() {
            Assert.assertTrue("Password Input'u functional değil!!",getLoginPage().input_password.isEnabled());
            Assert.assertTrue("Email Input'u functional değil!!",getLoginPage().input_email.isEnabled());
    }

    @Then("the user enters an invalid email as {string} and password as {string}")
    public void theUserEntersAnInvalidEmailAsAndPasswordAs(String arg0, String arg1){

        String loginTitle="Login and start selling your produce! | Urbanic Farm";
        getLoginPage().input_email.sendKeys(arg0);
        getLoginPage().input_password.sendKeys(arg1);
        getLoginPage().submit_button.click();
        ReusableMethods.waitForPageToLoad(2000);
        Assert.assertEquals(loginTitle,driver.getTitle());
    }

    @And("the system should display an error message for invalid credentials")
    public void theSystemShouldDisplayAnErrorMessageForInvalidCredentials() {
    }
}
