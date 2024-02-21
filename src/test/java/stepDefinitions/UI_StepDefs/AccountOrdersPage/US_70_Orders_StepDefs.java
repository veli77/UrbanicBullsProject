package stepDefinitions.UI_StepDefs.AccountOrdersPage;

import io.cucumber.java.en.*;
import pages.CommonPage;
import utilities.ReusableMethods;


public class US_70_Orders_StepDefs extends CommonPage {

    @Given("User logs in as buyer")
    public void user_logs_in_as_buyer() throws InterruptedException {
        getLoginPage().loginButton.click();
        getLoginPage().LoginEmail.sendKeys("urbanicfarm1@yopmail.com");
        getLoginPage().input_password.sendKeys("Urbanicfarm1/");
        getLoginPage().LoginSubmitButton.click();
        getAccountWeeklyOrderPage().zipCodeBoxCloseButton.click();
        Thread.sleep(2000);

    }
    @Given("User enters cart")
    public void user_enters_cart() throws InterruptedException {
        Thread.sleep(2000);
        getAccountOrdersPage().sepeteTikla.click();

    }
    @Given("User adds order on cart page")
    public void user_adds_order_on_cart_page() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            getAccountOrdersPage().plus.click();
            Thread.sleep(2000);
        }

        /*
        for (int i = 0; i < 3; i++) {
            getAccountOrdersPage().plus2.click();
            Thread.sleep(3000);
        }

        for (int i = 0; i < 3; i++) {
            ReusableMethods.waitForVisibility(getAccountOrdersPage().plus3, 5);
            //Thread.sleep(2000);
            getAccountOrdersPage().plus3.sendKeys("3");

        }

         */
        getAccountOrdersPage().addToCard.click();

    }
    @Given("User completes the purchase")
    public void user_completes_the_purchase() throws InterruptedException {
        Thread.sleep(3000);
        //getAccountOrdersPage().bosluk.click();
        getAccountOrdersPage().proceedToCheckout.click();
        Thread.sleep(2000);
        getAccountOrdersPage().nextButton.click();
        Thread.sleep(1000);
        getAccountOrdersPage().goToPayment.click();
        Thread.sleep(3000);
        getAccountOrdersPage().nextButton.click();
        getAccountOrdersPage().goToPayment.click();

    }
    @Then("Order placed by the user is seen in the Orders section.")
    public void order_placed_by_the_user_is_seen_in_the_orders_section() {

    }
    @Then("Login as a seller")
    public void login_as_a_seller() {

    }
    @Then("Seller sees buyer's orders")
    public void seller_sees_buyer_s_orders() {

    }
    @Then("Seller sees the buyer's orders in the Notifications section")
    public void seller_sees_the_buyer_s_orders_in_the_notifications_section() {

    }

    @Given("Login as a buyer")
    public void login_as_a_buyer() throws InterruptedException {
        getLoginPage().loginButton.click();
        getLoginPage().LoginEmail.sendKeys("seller_urban@mailsac.com");
        getLoginPage().input_password.sendKeys("VHt*zzt*wQNu6XS");
        getLoginPage().LoginSubmitButton.click();
        getAccountWeeklyOrderPage().zipCodeBoxCloseButton.click();
        Thread.sleep(2000);
    }
    @Then("Orders can be changed \\(increased, decreased) in the cart section.")
    public void orders_can_be_changed_increased_decreased_in_the_cart_section() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("New orders can be added to the cart section.")
    public void new_orders_can_be_added_to_the_cart_section() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
