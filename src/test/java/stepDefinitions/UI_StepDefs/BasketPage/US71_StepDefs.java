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
     Thread.sleep(2000);
     getBasketPage().enterPromocode.click();
     getBasketPage().promocodeGonder.sendKeys("dolar10");
     getBasketPage().applyButton.click();
    }

    @Then("After entering the Promo Code, you should receive the same discount")
    public void after_entering_the_promo_code_you_should_receive_the_same_discount() {
        String totalAmount = getBasketPage().totalAmount.getText();
    }

    @Then("Promocode is entered greater than the total amount and an error message is expected.")
    public void promocode_is_entered_greater_than_the_total_amount_and_an_error_message_is_expected() {
        assertEquals(getBasketPage().totalAmount.getText(), getBasketPage().enterPromocode.getText());
        assertTrue(getBasketPage().invalidPromocodeMessage.isDisplayed());
    }

    @Then("Promocode is entered equal to the total amount and an error message is expected.")
    public void promocode_is_entered_equal_to_the_total_amount_and_an_error_message_is_expected() {
        assertEquals(getBasketPage().totalAmount.getText(), "dolar10");
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
