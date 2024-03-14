package stepDefinitions.UI_StepDefs.AccountOrdersPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.JSUtils;
import utilities.ReusableMethods;
import java.util.ArrayList;


import static stepDefinitions.Hooks.driver;

public class US_072_ProceedToCheckoutPage_stepDefs extends CommonPage {
    int notificationFirstQuantity;
    @Given("the user goes to the GoToChart page")
    public void theUserGoesToTheGoToChartPage() {

        ReusableMethods.waitForPageToLoad(10);
        ReusableMethods.hover(getAccountOrdersPage().sepeteTikla);
        getAccountOrdersPage().sepeteTikla.click();
        ReusableMethods.waitForPageToLoad(10);
        ReusableMethods.waitFor(5);
        ReusableMethods.verifyURL("basket");
        ReusableMethods.hover(getAccountOrdersPage().addToCardButtons.get(0));
        getAccountOrdersPage().addToCardButtons.get(0).click();


        ReusableMethods.waitFor(5);


      // ReusableMethods.hover(getBasketPage().goToCartQuantity);
      // ReusableMethods.waitForVisibility(getBasketPage().goToCartQuantity,5);
       System.out.println("goToCart quantity= "+getBasketPage().goToCartQuantity.getAttribute("textContent"));
       notificationFirstQuantity=Integer.parseInt(getBasketPage().goToCartQuantity.getText());
    }



    @When("the user clicks on the ProceedToCheckout button, the user can reach the ProceedToCheckout page")
    public void theUserClicksOnTheProceedToCheckoutButtonTheUserCanReachTheProceedToCheckoutPage() {
        ReusableMethods.hover(getAccountOrdersPage().proceedToCheckout);
        getAccountOrdersPage().proceedToCheckout.click();
        ReusableMethods.waitForPageToLoad(5);
        ReusableMethods.verifyURL("proceed");

    }

    @And("Next and Prev buttons should be functional")
    public void nextAndPrevButtonsShouldBeFunctional() {



      // getHomePage().screenshotClick("C:\\Users\\ersin\\IdeaProjects\\UrbanicBullsProject\\src\\test\\java\\utilities\\sikuliX_ScreenShots\\alertCloseIconjpg.jpg");

        JSUtils.clickElementByJS(getBasketPage().buttonsPrevNextInProceedToCheckoutPage.get(1));
        Assert.assertTrue(getBasketPage().selectedPageInProceedToCheckoutPage.getText().contains("Address"));
        getBasketPage().buttonsPrevNextInProceedToCheckoutPage.getFirst().click();
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
        ReusableMethods.switchToWindow(1);
        getBasketPage().completePurchaseButton.click();
        System.out.println(getHomePage().alert.getText());
        ReusableMethods.waitForVisibility(getBasketPage().paymentSuccessfulMessage,10);
        Assert.assertTrue(getBasketPage().paymentSuccessfulMessage.getText().toLowerCase().contains("successful"));




    }

    @Then("Rate button should be functional and give accurate results")
    public void rateButtonShouldBeFunctionalAndGiveAccurateResults() {
        getBasketPage().rateOurServiceButton.click();
        Assert.assertTrue(getBasketPage().rateFrameText.getText().toLowerCase().contains("rate"));
        getBasketPage().rateFrameCloseButton.click();

    }

    @And("Order detail button should be functional and correct result should be obtained")
    public void orderDetailButtonShouldBeFunctionalAndCorrectResultShouldBeObtained() {

        getAccountOrdersPage().viewOrdersDetails.click();
        ReusableMethods.waitForPageToLoad(10);
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("order"));


    }

    @And("The status of the orders should be visible.")
    public void theStatusOfTheOrdersShouldBeVisible(DataTable dataTable) {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            arrayList.add(getBasketPage().orderStatus.get(i).getText());
        }
        int j=0;
        for (String status:arrayList){

            if(dataTable.row(j).getFirst().contains(status)){
                continue;
            }
            else {
                System.out.println("Order Status is not correct");
                break;
            }
        }





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
