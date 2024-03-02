package stepDefinitions.UI_StepDefs.AccountOrdersPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.ReusableMethods;

public class US_072_ProceedToCheckoutPage_stepDefs extends CommonPage {
    @Given("the user goes to the GoToChart page")
    public void theUserGoesToTheGoToChartPage() {

        getAccountOrdersPage().sepeteTikla.click();
        ReusableMethods.verifyURL("basket");
        getAccountOrdersPage().addToCardButtons.get(1).click();

    }

    @When("the user clicks on the ProceedToCheckout button, the user can reach the ProceedToCheckout page")
    public void theUserClicksOnTheProceedToCheckoutButtonTheUserCanReachTheProceedToCheckoutPage() {
        getAccountOrdersPage().proceedToCheckout.click();
        ReusableMethods.verifyURL("proceed");

    }

    @And("Next and Prev buttons should be functional")
    public void nextAndPrevButtonsShouldBeFunctional() {
    }

    @And("GoToPayment button should be functional")
    public void gotopaymentButtonShouldBeFunctional() {
    }

    @And("Payment should be success")
    public void paymentShouldBeSuccess() {
    }

    @Then("Rate button should be functional and give accurate results")
    public void rateButtonShouldBeFunctionalAndGiveAccurateResults() {
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
    }
}
