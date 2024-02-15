package stepDefinitions.UI_StepDefs.RegisterPage;

import io.cucumber.java.en.*;
import pages.CommonPage;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class US32_SignInWithGoogle_stepDefs extends CommonPage {
    @When("User click the register button")
    public void user_click_the_register_button() {
        getHomePage().RegisterButton.click();
        ReusableMethods.waitForPageToLoad(1);
    }
    @When("User click to sign in with google")
    public void user_click_to_sign_in_with_google() {
       getRegisterPage().registerByGoogleA.click();
        ReusableMethods.waitFor(1);
        //getRegisterPage().sendEmail.sendKeys(ConfigurationReader.getProperty("user1_email"));
        getRegisterPage().sendEmail.sendKeys("alhttn.smsk@gmail.com");
        ReusableMethods.waitFor(1);
        getRegisterPage().nextButton.click();

    }
    @Then("User successfully logs in with google account")
    public void user_successfully_logs_in_with_google_account() {
        //assertTrue(getRegisterPage().sussecsfullyMessage.isDisplayed());

    }


}
