package stepDefinitions.UI_StepDefs.Register_Page;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CommonPage;
import pages.HomePage;
import pages.RegisterPage;

import java.util.List;

public class US_037_RegisterStepDef extends CommonPage {

    @And("Click the {string} button on the main Page")
    public void clickTheButtonOnTheMainPage(String btnName) {
        getHomePage().clickMainButton(btnName);

    }

    @Then("Send valid information to register")
    public void sendValidInformationToRegister(DataTable dataTable) {
        List<List<String>> listItems = dataTable.asLists(String.class);
        getRegisterPage().typeRegisterInf(listItems);
    }

    @Then("Verify registration completed successfully")
    public void verifyRegistrationCompletedSuccessfully() {
        getRegisterPage().verifyAlertMessageIsAvailable();
    }
}
