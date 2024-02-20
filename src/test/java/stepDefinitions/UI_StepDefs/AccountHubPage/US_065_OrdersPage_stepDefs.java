package stepDefinitions.UI_StepDefs.AccountHubPage;

import io.cucumber.java.en.And;
import pages.CommonPage;

public class US_065_OrdersPage_stepDefs extends CommonPage {
    @And("User can click the {string} button on the left side bar in Account Page and verify that user is in the Orders Page")
    public void userCanClickTheButtonOnTheLeftSideBarInAccountPageAndVerifyThatUserIsInTheOrdersPage(String btnName) {
        getAccountHubPage().verifyLeftPanelButton(btnName);
        getAccountHubPage().clickAButtonInLeftPanel(btnName);
        getAccountOrdersPage().verifyOrdersPage();
    }

    @And("User can select any order")
    public void userCanSelectAnyOrder() {
        getAccountOrdersPage().verifyViewdetailsButton();
        getAccountOrdersPage().clickViewDetailsButton();
    }

    @And("User can see the order details page and order summary")
    public void userCanSeeTheOrderDetailsPageAndOrderSummary() {
        getAccountOrdersPage().verifyOrderDetailsPage();
        getAccountOrdersPage().verifyOrderSummary();
    }

    @And("User can click {string} button in Order Details page and can reach related page.")
    public void userCanClickButtonInOrderDetailsPageAndCanReachRelatedPage(String arg0) {
    }

    @And("User can navigate to previous page")
    public void userCanNavigateToPreviousPage() {
    }

    @And("User can click seller's address map")
    public void userCanClickSellerSAddressMap() {
    }

    @And("User can click {string} button for selected order")
    public void userCanClickButtonForSelectedOrder(String arg0) {
    }
}
