package stepDefinitions.UI_StepDefs.AccountOrdersPage;

import io.cucumber.java.en.*;
import pages.CommonPage;
import utilities.ConfigurationReader;

public class US_70_Orders_StepDefs extends CommonPage {
    @Given("User logs in as buyer")
    public void user_logs_in_as_buyer() {
        getLoginPage().loginWithCredentials(ConfigurationReader.getProperty("buyerEmail"), ConfigurationReader.getProperty("buyerPassword"));
    }
    @Given("User enters cart")
    public void user_enters_cart() throws InterruptedException {
        getAccountOrdersPage().card.click();
        Thread.sleep(2);

    }
    @Given("User adds order on cart page")
    public void user_adds_order_on_cart_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("User completes the purchase")
    public void user_completes_the_purchase() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Order placed by the user is seen in the Orders section.")
    public void order_placed_by_the_user_is_seen_in_the_orders_section() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Login as a seller")
    public void login_as_a_seller() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Seller sees buyer's orders")
    public void seller_sees_buyer_s_orders() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Seller sees the buyer's orders in the Notifications section")
    public void seller_sees_the_buyer_s_orders_in_the_notifications_section() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
