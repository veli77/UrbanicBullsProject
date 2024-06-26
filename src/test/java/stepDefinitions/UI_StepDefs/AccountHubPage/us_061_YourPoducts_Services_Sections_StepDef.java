package stepDefinitions.UI_StepDefs.AccountHubPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.CommonPage;


public class us_061_YourPoducts_Services_Sections_StepDef extends CommonPage {

    @Then("various products should be visible")
    public void variousProductsShouldBeVisible() {
      getAccountHubPage().assertProductGroup();
    }

    @Given("the user clicks on  any group")
    public void theUserClicksOnAnyGroup() {
        getAccountHubPage().allhubs.getFirst().click();
    }

    @When("each product should display Product Name, Price and Stock information")
    public void eachProductShouldDisplayProductNamePriceAndStockInformation() {
         getAccountHubPage().assertProductInformation();
    }

    @Then("options for Approved, Review, and Rejected should be visible for each product")
    public void optionsForApprovedReviewAndRejectedShouldBeVisibleForEachProduct() {
        getAccountHubPage().assertProductStatus();
    }

    @When("the user click on the product name to view details")
    public void theUserClickOnTheProductNameToViewDetails() {

        getAccountHubPage().productName.getFirst().click();
    }

    @Then("the user should be able to change product information on this page")
    public void theUserShouldBeAbleToChangeProductInformationOnThisPage() {
        getAccountHubPage().productStockUpdate();
    }

    @Then("the organic and Trade buttons should be functional")
    public void theOrganicAndTradeButtonsShouldBeFunctional() {
     getAccountHubPage().tradeButtonIsFuntional();
    }


    @And("the Update buttons should be visible")
    public void theUpdateButtonsShouldBeVisible() {
        getAccountHubPage().updateButtonVisible();
    }
    @And("the Delete buttons should be visible")
    public void theDeleteButtonsShouldBeVisible() {
        getAccountHubPage().deleteButtonVisible();
    }
    @Given("the user is viewing product information")
    public void theUserIsViewingProductInformation() {
    }

    @When("the user clicks the Trade button If the trade description entry is not visible")
    public void theUserClicksTheTradeButton() {
        getAccountHubPage().clicksTradeButton();
    }

    @Then("the Trade description input should be visible")
    public void theTradeDescriptionInputShouldBeVisible() {
        getAccountHubPage().tradeDescriptionVisible();
    }

    @When("the user makes necessary corrections and clicks the Update button")
    public void theUserMakesNecessaryCorrectionsAndClicksTheUpdateButton() {
        getAccountHubPage().clicksUpdateButton();
    }

    @Then("an alert should display confirming the update")
    public void anAlertShouldDisplayConfirmingTheUpdate() {
        getAccountHubPage().verifyUpdateMesage();
    }
}
