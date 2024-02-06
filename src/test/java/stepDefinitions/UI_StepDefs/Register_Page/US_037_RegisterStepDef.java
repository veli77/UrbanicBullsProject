package stepDefinitions.UI_StepDefs.Register_Page;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.RegisterPage;

import java.util.List;

public class US_037_RegisterStepDef {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @And("Click the {string} button on the main Page")
    public void clickTheButtonOnTheMainPage(String btnName) {
        homePage.clickMainButton(btnName);

    }

    @Then("Send valid information to register")
    public void sendValidInformationToRegister(DataTable dataTable) {
        List<List<String>> listItems = dataTable.asLists(String.class);
        registerPage.typeRegisterInf(listItems);
    }

    @Then("Verify registration completed successfully")
    public void verifyRegistrationCompletedSuccessfully() {
        registerPage.verifyAlertMessageIsAvailable();
    }
}
