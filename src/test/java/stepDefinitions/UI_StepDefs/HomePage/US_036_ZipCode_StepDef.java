package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CommonPage;

import java.util.List;

public class US_036_ZipCode_StepDef extends CommonPage {

    @And("Login with credential as")
    public void loginWithCredentialAs(DataTable dataTable) {
        List<List<String>> listItems = dataTable.asLists(String.class);
        getLoginPage().loginWithCredentials(listItems.get(0).get(0), listItems.get(0).get(1));
    }

    @Then("Verify that zipCode entries match the expected result")
    public void verifyThatZipCodeEntriesMatchTheExpectedResult(DataTable dataTable) {
        List<List<String>> listItems = dataTable.asLists(String.class);
        getLoginPage().verifyZipCodeEntry(listItems);
   }
}
