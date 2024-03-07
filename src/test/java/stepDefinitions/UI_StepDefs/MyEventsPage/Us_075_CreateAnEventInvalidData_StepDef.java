package stepDefinitions.UI_StepDefs.MyEventsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CommonPage;

public class Us_075_CreateAnEventInvalidData_StepDef extends CommonPage {

    @Then("User fills in the required fields with invalid data {string} {string} {string} {string} {string} {string} {string} {string}\"")
    public void user_fills_in_the_required_fields_with_invalid_data(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        getMyEventsPage().enterInvalidData3(string,string2,string3,string4,string5,string6,string7,string8);
    }

    @And("User verifies that a warning message {string}")
    public void userVerifiesThatAWarningMessage(String string9) {
        getMyEventsPage().verifyMessage(string9);
    }

    @Then("User clicks Go Back button")
    public void userClicksTheGoBackButton() {
        getMyEventsPage().clickGoBackButton();
    }

    @And("User verifies that  back to the previous page")
    public void userVerifiesThatBackToThePreviousPage() {
        getMyEventsPage().verifyBackToThePreviousPage();
    }
}
