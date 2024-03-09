package stepDefinitions.UI_StepDefs.BasketPage;

import io.cucumber.java.en.*;
import pages.CommonPage;

import static org.junit.Assert.*;

public class US71_StepDefs extends CommonPage {
    @Then("Promocode menu should be clickable")
    public void promocode_menu_should_be_clickable() {
        assertTrue(getBasketPage().enterPromocode.isDisplayed());
        assertTrue(getBasketPage().enterPromocode.isEnabled());
    }

    @Then("User should be enter promocode")
    public void user_should_be_enter_promocode() throws InterruptedException {

        String subtotalSansProcode = getBasketPage().subTotal.getText();
        Thread.sleep(1000);
     getBasketPage().enterPromocode.click();
        Thread.sleep(1000);
     getBasketPage().promocodeGonder.sendKeys("dolar10");
        Thread.sleep(1000);
     getBasketPage().applyButton.click();
        Thread.sleep(2000);
    }

    @Then("After entering the Promo Code, you should receive the same {string} discount")
    public void after_entering_the_promo_code_you_should_receive_the_same_discount(String indirimTutari) {
        String text = getBasketPage().subTotal.getText();
        String[] amounts = text.split(" ");
// İlk elemanı alalım ve başındaki $ işaretini atlayarak kalan kısmı alalım
        String firstAmount = amounts[0].startsWith("$") ? amounts[0].substring(1,7) : amounts[0];
        String secondAmount =  amounts[0].startsWith("$") ? amounts[0].substring(8) : amounts[0];
        System.out.println("İlk tutar: " + firstAmount);
        System.out.println("İkinci tutar: " + secondAmount);
        double topTutar = Double.parseDouble(firstAmount);
        double indrimliTutar = Double.parseDouble(secondAmount);
        double indirimMiktari = Double.parseDouble(indirimTutari);
        assertEquals(indirimMiktari, (topTutar-indrimliTutar), 0.001);
    }

    @Then("Promocode is entered greater than the total amount and an error message is expected.")
    public void promocode_is_entered_greater_than_the_total_amount_and_an_error_message_is_expected() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            getAccountOrdersPage().plus.click();
            Thread.sleep(2000);
            getAccountOrdersPage().addToCard.click();
        }
        String subtotalSansProcode = getBasketPage().subTotal.getText();
        Thread.sleep(1000);
        getBasketPage().enterPromocode.click();
        Thread.sleep(1000);
        getBasketPage().promocodeGonder.sendKeys("dolar10");
        Thread.sleep(1000);
        getBasketPage().applyButton.click();
        Thread.sleep(2000);
        Thread.sleep(3000);
        assertTrue(getBasketPage().invalidPromocodeMessage.isDisplayed());
    }
    @Given("User adds order on cart page for order")
    public void user_adds_order_on_cart_page_for_order() throws InterruptedException {
        if (getAccountOrdersPage().xIsareti.isDisplayed()) {
            Thread.sleep(2000);
         getAccountOrdersPage().xIsareti.click();
         if (getBasketPage().yesButtonorderSilmekIcin.isSelected()){
             getBasketPage().yesButtonorderSilmekIcin.click();
         }
        }else {
            for (int i = 0; i < 3; i++) {
                getAccountOrdersPage().plus.click();
                Thread.sleep(2000);
                getAccountOrdersPage().addToCard.click();
            }
        }
        Thread.sleep(2000);
    }

    @Then("Promocode is entered equal to the total amount and an error message is expected.")
    public void promocode_is_entered_equal_to_the_total_amount_and_an_error_message_is_expected() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            getAccountOrdersPage().plus.click();
            Thread.sleep(2000);
            getAccountOrdersPage().addToCard.click();
        }
        String subtotalSansProcode = getBasketPage().subTotal.getText();
        Thread.sleep(1000);
        getBasketPage().enterPromocode.click();
        Thread.sleep(1000);
        getBasketPage().promocodeGonder.sendKeys("dolar10");
        Thread.sleep(1000);
        getBasketPage().applyButton.click();
        Thread.sleep(3000);
        assertTrue(getBasketPage().invalidPromocodeMessage.isDisplayed());
    }

    @Then("Undefined promocode is entered and an error message is expected.")
    public void undefined_promocode_is_entered_and_an_error_message_is_expected() {
       getBasketPage().enterPromocode.sendKeys("jfjfjfj");
        assertTrue(getBasketPage().invalidPromocodeMessage.isDisplayed());
    }

    @Then("Promocode is entered less than the total amount and the same discount will be seen on the total amount.")
    public void promocode_is_entered_less_than_the_total_amount_and_the_same_discount_will_be_seen_on_the_total_amount() {
        String totalAmount = getBasketPage().totalAmount.getText();
        getBasketPage().promocodeGonder.sendKeys("dolar10");
        getBasketPage().applyButton.click();
       String indirimliTotal = getBasketPage().indirimliTotalHesap.getText();
       assertTrue(totalAmount>indirimliTotal);
    }

}
