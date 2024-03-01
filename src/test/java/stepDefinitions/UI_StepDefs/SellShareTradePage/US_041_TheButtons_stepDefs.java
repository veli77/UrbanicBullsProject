package stepDefinitions.UI_StepDefs.SellShareTradePage;

import freemarker.cache.WebappTemplateLoader;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.ReusableMethods;


import static org.junit.Assert.*;
import static stepDefinitions.Hooks.driver;

public class US_041_TheButtons_stepDefs extends CommonPage {

    @Given("User logs in")
    public void user_logs_in() {
        getLoginPage().loginButton.click();
        getLoginPage().LoginEmail.sendKeys("urbanicfarm2@yopmail.com");
        getLoginPage().input_password.sendKeys("Urbanicfarm2/");
        getLoginPage().LoginSubmitButton.click();

    }
    @Then("The Contact Us button appears and is clicked and the page opens.")
    public void the_contact_us_button_appears_and_is_clicked_and_the_page_opens() {
        ReusableMethods.waitFor(2);
        assertTrue(getSellShareTradePage().ContactUsBtn_SellShareTread.isDisplayed());
        assertTrue(getSellShareTradePage().ContactUsBtn_SellShareTread.isEnabled());
    }
    @Then("The User button appears and is clicked and the page opens.")
    public void the_user_button_appears_and_is_clicked_and_the_page_opens() {
        ReusableMethods.waitFor(2);
        assertTrue(getSellShareTradePage().usernameBtn.isDisplayed());
        assertTrue(getSellShareTradePage().usernameBtn.isEnabled());
    }
    @Then("Logout Button appears and is clicked and the page opens")
    public void logout_button_appears_and_is_clicked_and_the_page_opens() {
        ReusableMethods.waitFor(2);
        assertTrue(getSellShareTradePage().LogoutBtn_SellShareTradePage.isDisplayed());
        assertTrue(getSellShareTradePage().LogoutBtn_SellShareTradePage.isEnabled());
    }
    @Then("The notification button appears and is clicked and the page opens.")
    public void the_notification_button_appears_and_is_clicked_and_the_page_opens() {
        ReusableMethods.waitFor(2);
        assertTrue(getSellShareTradePage().Notifications_SellShareTradePage.isDisplayed());
        assertTrue(getSellShareTradePage().Notifications_SellShareTradePage.isEnabled());
    }
    @Then("The card appears and is clicked and the page opens.")
    public void the_card_appears_and_is_clicked_and_the_page_opens() {
        ReusableMethods.waitFor(2);
       assertTrue(getSellShareTradePage().Cart_SellShareTradePage.isDisplayed());
        assertTrue(getSellShareTradePage().Cart_SellShareTradePage.isEnabled());
    }

}
