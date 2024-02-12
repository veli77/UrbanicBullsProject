package stepDefinitions.UI_StepDefs.Register_Page;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import pages.RegisterPage;
import utilities.ReusableMethods;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US34_RegisterNameFunctionality_stepDefs extends RegisterPage {

    Faker faker = new Faker();
    @Then("First name information is entered as a letter")
    public void first_name_information_is_entered_as_a_letter() {
        getRegisterPage().nameForRegister.sendKeys(faker.name().firstName());
        ReusableMethods.waitFor(1);
    }
    @Then("Surname information is entered as letters")
    public void surname_information_is_entered_as_letters() {
        getRegisterPage().middlenameForRegister.sendKeys(faker.name().firstName());
        getRegisterPage().lastNameForRegister.sendKeys(faker.name().lastName());
        ReusableMethods.waitFor(1);
    }

    @Then("Valid email information is entered with the @, <something>.<something> sign.")
    public void valid_email_information_is_entered_with_the_something_something_sign() {
        getRegisterPage().emailForRegister.sendKeys(faker.internet().emailAddress());
        ReusableMethods.waitFor(1);
        getRegisterPage().passwordForRegister.sendKeys("1234A.a!");
        //getRegisterPage().passwordForRegister.sendKeys(faker.internet().password(8,12, true, true));
        ReusableMethods.waitFor(1);
        getRegisterPage().confirmePasswordForRegister.sendKeys("1234A.a!", Keys.ENTER);
        getRegisterPage().zipKodK.sendKeys(Keys.ENTER);

    }

    @Then("the message {string} appears.")
    public void the_message_appears(String string) {
      assertEquals(string, "Welcome");

    }
    RegisterPage rp = new RegisterPage();

   /* @And("Click the {string} button on the main Page")
    public void clickTheButtonOnTheMainPage(String text) {
        rp.clickMainButton(text);
    } */

    @Then("Verify that first name entries match the expected result")
    public void verifyThatFirstNameEntriesMatchTheExpectedResult(DataTable dataTable) {
        List<List<String>> listItems = dataTable.asLists(String.class);
        rp.verifyFirstNames(listItems);
    }

    @Then("Verify that middle name entries match the expected result")
    public void verifyThatMiddleNameEntriesMatchTheExpectedResult(DataTable dataTable) {
        List<List<String>> listItems = dataTable.asLists(String.class);
        rp.verifyMiddleNames(listItems);
    }

    @Then("verify that last name entries match the expected result")
    public void verifyThatLastNameEntriesMatchTheExpectedResult(DataTable dataTable) {
        List<List<String>> listItems = dataTable.asLists(String.class);
        rp.verifyLastNames(listItems);
    }

    @Then("Verify that email entries match the expected result")
    public void verifyThatEmailEntriesMatchTheExpectedResult(DataTable dataTable) {
        List<List<String>> listItems = dataTable.asLists(String.class);
        rp.verifyEmails(listItems);
    }

}
