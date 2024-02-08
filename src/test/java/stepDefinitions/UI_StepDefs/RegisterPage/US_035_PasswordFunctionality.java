package stepDefinitions.UI_StepDefs.RegisterPage;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.CommonPage;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_035_PasswordFunctionality extends CommonPage {
    public Faker faker = new Faker();

    @Then("User goes to Register Page")
    public void userGoesToRegisterPage() {
    getHomePage().RegisterButton.click();
    }

    @Given("User enters a valid first name, last name, and email address")
    public void userEntersAValidFirstNameLastNameAndEmailAddress() {
        getRegisterPage().FirstName.sendKeys(faker.name().firstName());
        getRegisterPage().LastName.sendKeys(faker.name().lastName());
        getRegisterPage().Email.sendKeys(faker.internet().emailAddress());
    }

    @When("User leaves the password blank and submits the registration form")
    public void userLeftsThePasswordBlankAndSubmitsTheRegistrationForm() {
        JSUtils.clickElementByJS(getRegisterPage().RegisterButtonBottomofPage);
    }

    @Then("An alert appears to fill out the password section")
    public void anAlertAppearsToFillOutThePasswordSection() {
        // Validity değerini kontrol et
        Assert.assertFalse(getRegisterPage().validity);
    }

    @When("User enters an invalid password {string} which is not in line with requirements")
    public void userEntersAnInvalidPasswordWhichIsNotInLineWithRequirements(String password) {
        getRegisterPage().Password.sendKeys(password);
    }

    @Then("An alert which requires a relevant format should appear on the screen")
    public void anAlertWhichRequiresRelevantFormatShouldAppearOnTheScreen() {
        // Validity değerini kontrol et
        Assert.assertFalse(getRegisterPage().validity);
    }


    @When("User enters a confirm password which does not match the initial password")
    public void userEntersAConfirmPasswordWhichDoesNotMatchTheInitialPassword() {
        getRegisterPage().Password.sendKeys("1Abcdefg");
        getRegisterPage().ConfirmPassword.sendKeys("2Abcdefg");
    }
    @And("User submits the registration form")
    public void userSubmitsTheRegistrationForm() {
       JSUtils.clickElementByJS(getRegisterPage().RegisterButtonBottomofPage);
    }
    @Then("An alert appears to match the confirm password with the initial one")
    public void anAlertAppearsToMatchTheConfirmPasswordWithTheInitialOne() {
        Assert.assertFalse(getRegisterPage().validity2);
    }

    @When("User enters a confirm password which matches the initial password")
    public void userEntersAConfirmPasswordWhichMatchesTheInitialPassword() {
        getRegisterPage().Password.sendKeys("1Abcdefg");
        getRegisterPage().ConfirmPassword.sendKeys("1Abcdefg");
    }

    @Then("User successfully registers after valid information is entered")
    public void userSuccessfullyRegistersAfterValidInformationIsEntered() {
        ReusableMethods.waitForVisibility(getRegisterPage().WelcomeMessage,5);
        Assert.assertTrue(getRegisterPage().WelcomeMessage.isDisplayed());
    }
}