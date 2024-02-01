package stepDefinitions.UI_StepDefs.LoginPage;


import enums.URLOGIN;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;


import static enums.URLOGIN.LOGIN_URL;
import static stepDefinitions.Hooks.driver;


public class US_039_loginFail_stepDef extends CommonPage{
    @Given("User goes to login page")
    public void user_goes_to_loginpage(){
        driver.get("https://test.urbanicfarm.com/auth/login");
        ReusableMethods.waitForPageToLoad(5);
     //  driver.get(LOGIN_URL.getLink());
    }

    @When("the Email address and password button is functional")
    public void theEmailAddressAndPasswordButtonIsFunctional() {
        if(getLoginPage().input_email.isDisplayed()){
            Assert.assertTrue(getLoginPage().input_password.isEnabled());
        }
    }


    @Then("the user enters an invalid email and password")
    public void theUserEntersAnInvalidEmailAndPassword() {
    }

    @Then("the login should fail")
    public void theLoginShouldFail() {
    }

    @And("the system should display an error message for invalid credentials")
    public void theSystemShouldDisplayAnErrorMessageForInvalidCredentials() {
    }
}
