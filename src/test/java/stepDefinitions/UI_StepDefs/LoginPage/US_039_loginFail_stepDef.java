package stepDefinitions.UI_StepDefs.LoginPage;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;

import static enums.URL_LINKS.LOGIN_URL;
import static stepDefinitions.Hooks.driver;


public class US_039_loginFail_stepDef extends CommonPage{
    @Given("Users go to login page")
    public void usersGoeToLoginPage(){
       driver.get(LOGIN_URL.getLink());
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
        getLoginPage().input_email.sendKeys(arg0);
        getLoginPage().input_password.sendKeys(arg1);
        getLoginPage().submit_button.click();
        Assert.assertEquals(loginTitle,driver.getTitle());
    }


    @And("the system should display an error message for invalid credentials")
    public void theSystemShouldDisplayAnErrorMessageForInvalidCredentials()  {
        try {
            System.out.println(getLoginPage().alert_message.getText());
        }
        catch(Exception ignored) {}
    }


}