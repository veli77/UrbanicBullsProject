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
        if(getLoginPage().input_email.isEnabled()){
            Assert.assertTrue(getLoginPage().input_password.isEnabled());
        }
    }

    @Then("the user enters an invalid email as {string} and password as {string}")
    public void theUserEntersAnInvalidEmailAsAndPasswordAs(String arg0, String arg1){
        String loginTitle=driver.getTitle();
        ReusableMethods.waitFor(2000);
        //ReusableMethods.hover(getLoginPage().input_email);
        getLoginPage().input_email.sendKeys(arg0);
        //ReusableMethods.hover(getLoginPage().input_password);
        getLoginPage().input_password.sendKeys(arg1);
        //ReusableMethods.hover(getLoginPage().submit_button);
        getLoginPage().submit_button.click();
        ReusableMethods.waitForPageToLoad(2000);
        Assert.assertEquals(loginTitle,driver.getTitle());
    }


    @And("the system should display an error message for invalid credentials")
    public void theSystemShouldDisplayAnErrorMessageForInvalidCredentials() {
        /*
        try {
            System.out.println(getLoginPage().alert_message.getText());
        }
        catch(Exception e) {}
         */

    }
}
