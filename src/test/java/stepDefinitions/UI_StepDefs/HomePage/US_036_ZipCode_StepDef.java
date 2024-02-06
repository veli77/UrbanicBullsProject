package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.util.List;

public class US_036_ZipCode_StepDef {
    RegisterPage registerPage = new RegisterPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @And("Login with credentials")
    public void loginWithCredentials(DataTable dataTable) {
        List<List<String>> listItems = dataTable.asLists(String.class);
        loginPage.loginWithCredentials(listItems.get(0).get(0), listItems.get(0).get(1));

    }

    @Then("Verify that zipCode entries match the expected result")
    public void verifyThatZipCodeEntriesMatchTheExpectedResult(DataTable dataTable) {
        List<List<String>> listItems = dataTable.asLists(String.class);
        loginPage.verifyZipCodeEntry(listItems);
   }
}
