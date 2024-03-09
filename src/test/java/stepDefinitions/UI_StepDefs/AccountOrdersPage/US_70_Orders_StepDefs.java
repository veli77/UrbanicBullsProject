package stepDefinitions.UI_StepDefs.AccountOrdersPage;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;


import java.util.List;
import static org.junit.Assert.*;
import static stepDefinitions.Hooks.driver;


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

        Thread.sleep(3000);
        for (int i = 0; i < 3; i++) {
            getAccountOrdersPage().plus.click();
            Thread.sleep(3000);
        }
        getAccountOrdersPage().addToCardButtons.get(0).click();

    }
    @Given("User completes the purchase")
    public void user_completes_the_purchase() throws InterruptedException {
        Thread.sleep(3000);
        //getAccountOrdersPage().bosluk.click();
        getAccountOrdersPage().proceedToCheckout.click();
        Thread.sleep(2000);
        getAccountOrdersPage().nextButton.click();
        Thread.sleep(2000);
        getAccountOrdersPage().nextButton.click();
        getAccountOrdersPage().goToPayment.click();
        Thread.sleep(2000);

    }
    @Then("Order placed by the user is seen in the Orders section.")
    public void order_placed_by_the_user_is_seen_in_the_orders_section() throws InterruptedException {
        Thread.sleep(20000);
        //getAccountOrdersPage().loginPaypal1.click();
        //getAccountOrdersPage().email_PAypal.sendKeys(ConfigurationReader.getProperty("paypalEmail"));
        //getAccountOrdersPage().passwrd_Paypal.sendKeys(ConfigurationReader.getProperty("NvR29+Ww"));
        //getAccountOrdersPage().payPalSubmitBtn.click();
        Thread.sleep(12000);
        //assertTrue(getAccountOrdersPage().paymentSuccesfullyMetni.isDisplayed());

    }
    @Then("Buyer see order message")
    public void buyer_see_order_message() throws InterruptedException {
        getAccountOrdersPage().viewOrdersDetails.click();
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.xpath("//section[@class='d-flex flex-column mr-3']"));
        System.out.println(elements);
        getAccountOrdersPage().logOut.click();

    }

    @Then("Login as a seller")
    public void login_as_a_seller() throws InterruptedException {
        getLoginPage().loginButton.click();
        getLoginPage().LoginEmail.sendKeys("seller_urban2@yopmail.com");
        getLoginPage().input_password.sendKeys("Seller2/");
        getLoginPage().LoginSubmitButton.click();
        getAccountWeeklyOrderPage().zipCodeBoxCloseButton.click();
        Thread.sleep(2000);

    }
    @Then("Seller sees buyer's orders")
    public void seller_sees_buyer_s_orders() {
        getAccountOrdersPage().notification.click();
        getAccountOrdersPage().orderMessage.click();
        getAccountOrdersPage().orderDate.getText();

    }

    @Given("Login as a buyer")
    public void login_as_a_buyer() throws InterruptedException {
        getLoginPage().loginButton.click();
        getLoginPage().LoginEmail.sendKeys("buyer_urban@mailsac.com");
        getLoginPage().input_password.sendKeys("VHt*zzt*wQNu6XS");
        getLoginPage().LoginSubmitButton.click();
        getAccountWeeklyOrderPage().zipCodeBoxCloseButton.click();
        Thread.sleep(2000);
    }
    @Then("Orders can be changed \\(increased, decreased) in the cart section.")
    public void orders_can_be_changed_increased_decreased_in_the_cart_section() throws InterruptedException {
        getAccountOrdersPage().sepeteTikla.click();
        assertTrue(getAccountOrdersPage().plus.isEnabled());
        for (int i = 0; i < 7; i++) {
            getAccountOrdersPage().plus.click();
        }
        Thread.sleep(2000);
        assertTrue(getAccountOrdersPage().decrease.isEnabled());
        for (int i = 0; i < 3; i++) {
            getAccountOrdersPage().decrease.click();
        }
        Thread.sleep(2000);
        getAccountOrdersPage().addToCardButtons.get(0).click();


    }
    @Then("New orders can be added to the cart section.")
    public void new_orders_can_be_added_to_the_cart_section() throws InterruptedException {
        Thread.sleep(3000);
        //assertEquals("https://test.urbanicfarm.com/basket",driver.getTitle());
        assertTrue(getAccountOrdersPage().sepettekiUrun.isDisplayed());
    }

}
