package stepDefinitions.UI_StepDefs.AccountOrdersPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

public class US_072_ProceedToCheckoutPage_stepDefs extends CommonPage {
    @Given("the user goes to the GoToChart page")
    public void theUserGoesToTheGoToChartPage() {

        getAccountOrdersPage().sepeteTikla.click();
        ReusableMethods.verifyURL("basket");
        getAccountOrdersPage().addToCardButtons.get(1).click();

    }
    int notificationFirstQuantity=Integer.parseInt(getBasketPage().notificationQuantity.getText());

    @When("the user clicks on the ProceedToCheckout button, the user can reach the ProceedToCheckout page")
    public void theUserClicksOnTheProceedToCheckoutButtonTheUserCanReachTheProceedToCheckoutPage() {
        getAccountOrdersPage().proceedToCheckout.click();
        ReusableMethods.verifyURL("proceed");

    }

    @And("Next and Prev buttons should be functional")
    public void nextAndPrevButtonsShouldBeFunctional() {
        getBasketPage().buttonsPrevNextInProceedToCheckoutPage.get(1).click();
        Assert.assertTrue(getBasketPage().selectedPageInProceedToCheckoutPage.getText().contains("Address"));
        getBasketPage().buttonsPrevNextInProceedToCheckoutPage.get(0).click();
        Assert.assertTrue(getBasketPage().selectedPageInProceedToCheckoutPage.getText().contains("Information"));
    }


    @And("GoToPayment button should be functional")
    public void gotopaymentButtonShouldBeFunctional() {
        do {
            getBasketPage().buttonsPrevNextInProceedToCheckoutPage.get(1).click();
        }
        while (!getAccountOrdersPage().goToPayment.isDisplayed());

        getAccountOrdersPage().goToPayment.click();


    }

    @And("the user can enter Payment information. After Complete Purchase, Payment should be success")
    public void theUserCanEnterPaymentInformationAfterCompletePurchasePaymentShouldBeSuccess() {



    }

    @Then("Rate button should be functional and give accurate results")
    public void rateButtonShouldBeFunctionalAndGiveAccurateResults() {
        getBasketPage().rateOurServiceButton.click();

    }

    @And("Order detail button should be functional and correct result should be obtained")
    public void orderDetailButtonShouldBeFunctionalAndCorrectResultShouldBeObtained() {
    }

    @And("The status of the orders should be visible.")
    public void theStatusOfTheOrdersShouldBeVisible() {
    }

    @And("Order statuses must be seen in mutual buyer-seller accounts")
    public void orderStatusesMustBeSeenInMutualBuyerSellerAccounts() {
    }

    @Then("As a result of orders, the number in the notifications button should increase")
    public void asAResultOfOrdersTheNumberInTheNotificationsButtonShouldIncrease() {
        int currentNotificationQuantity=Integer.parseInt(getBasketPage().notificationQuantity.getText());

        Assert.assertTrue(currentNotificationQuantity>notificationFirstQuantity);

    }


}
