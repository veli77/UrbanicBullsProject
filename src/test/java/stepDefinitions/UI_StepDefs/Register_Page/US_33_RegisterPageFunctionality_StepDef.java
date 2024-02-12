package stepDefinitions.UI_StepDefs.Register_Page;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;

import java.util.List;

public class US_33_RegisterPageFunctionality_StepDef extends CommonPage {
    @Then("Verify that Name, Surname, Email, Password fields are enabled")
    public void verifyThatNameSurnameEmailPasswordFieldsAreEnabled(List<String> partialNames) {
        for(String each : partialNames){
            Assert.assertTrue(getRegisterPage().isEnabled(each));
        }
    }

    @Then("Verify that Name should not be able to left blank")
    public void verifyThatNameShouldNotBeAbleToLeftBlank(List<String> credList) {
        Assert.assertTrue(getRegisterPage().isNameBlankTestPass(credList));
    }

    @Then("Verify that surname should not be able to left blank")
    public void verifyThatSurnameShouldNotBeAbleToLeftBlank(List<String> credList) {
        Assert.assertTrue(getRegisterPage().isLastNameBlankTestPass(credList));
    }

    @Then("Verify that email should not be able to left blank")
    public void verifyThatEmailShouldNotBeAbleToLeftBlank(List<String> credList) {
        Assert.assertTrue(getRegisterPage().isEmailBlankTestPass(credList));

    }

    @Then("Verify that password should not be able to left blank")
    public void verifyThatPasswordShouldNotBeAbleToLeftBlank(List<String> credList) {
        Assert.assertTrue(getRegisterPage().isPasswordBlankTestPass(credList));

    }

    @Then("Verify that verifypassword should not be able to left blank")
    public void verifyThatVerifypasswordShouldNotBeAbleToLeftBlank(List<String> credList) {
        Assert.assertTrue(getRegisterPage().isConfirmePasswordBlankTestPass(credList));
    }

}
