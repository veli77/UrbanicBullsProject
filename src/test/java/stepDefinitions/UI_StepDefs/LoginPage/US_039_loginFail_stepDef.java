package stepDefinitions.UI_StepDefs.LoginPage;


import enums.URLOGIN;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;


import java.lang.reflect.Type;
import java.util.List;

import static enums.URLOGIN.LOGIN_URL;
import static stepDefinitions.Hooks.driver;


public class US_039_loginFail_stepDef extends CommonPage{
    @Given("User goes to login page")
    public void user_goes_to_loginpage(){
//        driver.get("https://test.urbanicfarm.com/auth/login");
//        ReusableMethods.waitForPageToLoad(5);
       driver.get(LOGIN_URL.getLink());
    }

    @When("the Email address and password button is functional")
    public void theEmailAddressAndPasswordButtonIsFunctional() {
        if(getLoginPage().input_email.isEnabled()){
            Assert.assertTrue(getLoginPage().input_password.isEnabled());
        }
    }


    /*
    @Then("the user enters an invalid email and password")
    public void the_user_enters_an_invalid_email_and_password(String email,String password) throws InterruptedException {
//        List<List<String>> data = dataTable.asList((Type) String.class);
        String loginTitle=driver.getTitle();
//        for (List<String> data : dataTable) {
//        getLoginPage().input_email.sendKeys(arg1);
        getLoginPage().LoginEmail.sendKeys(email);
        getLoginPage().input_password.sendKeys(password);
        Thread.sleep(3000);
        getLoginPage().submit_button.click();
        Assert.assertEquals(loginTitle,driver.getTitle());
    }
*/
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
        catch(Exception e) {}
    }


}
