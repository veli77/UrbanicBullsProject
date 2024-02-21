package stepDefinitions.UI_StepDefs.AccountHubPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CommonPage;
import utilities.ReusableMethods;

public class US_065_OrdersPage_stepDefs extends CommonPage {
    @And("User can click the {string} button on the left side bar in Account Page and verify that user is in the Orders Page")
    public void userCanClickTheButtonOnTheLeftSideBarInAccountPageAndVerifyThatUserIsInTheOrdersPage(String btnName) {
        getAccountHubPage().verifyLeftPanelButton(btnName);
        getAccountHubPage().clickAButtonInLeftPanel(btnName);
        ReusableMethods.waitForPageToLoad(5);
        getAccountOrdersPage().verifyOrdersPage();
    }

    @And("User can select any order")
    public void userCanSelectAnyOrder() {
    getAccountOrdersPage().selectOrder();
    }

    @And("User can click View order details button for selected order")
    public void userCanClickButtonForSelectedOrder() {
        getAccountOrdersPage().verifyViewdetailsButton();
        getAccountOrdersPage().clickViewDetailsButton();

    }

    @And("User can see the order details page and order summary")
    public void userCanSeeTheOrderDetailsPageAndOrderSummary() {
        getAccountOrdersPage().verifyOrderDetailsPage();
        getAccountOrdersPage().verifyOrderSummary();
    }

    @And("User can click Seller Page button in Order Details page and can reach related page.")
    public void userCanClickSellerPageButtonInOrderDetailsPageAndCanReachRelatedPage() {
      getAccountOrdersPage().clickSellerPageButtonAndVerifySellerPage();

    }

    @And("User can navigate to previous page")
    public void userCanNavigateToPreviousPage() {
        getAccountHubPage().goToPreviousPage();
    }

    @And("User can click seller's address map")
    public void userCanClickSellerSAddressMap() {
        ReusableMethods.waitForPageToLoad(5);
        getAccountOrdersPage().verifyAddressMap();
        getAccountOrdersPage().clickMapButton();
        getAccountOrdersPage().getNewWindow();
    }


    @Then("Verify seller map matches with the larger map")
    public void verifySellerMapMatchesWithTheLargerMap() {
        getAccountOrdersPage().getSellerMapCoordinate();
        getAccountOrdersPage().verifyCoordinate();



    }
}
