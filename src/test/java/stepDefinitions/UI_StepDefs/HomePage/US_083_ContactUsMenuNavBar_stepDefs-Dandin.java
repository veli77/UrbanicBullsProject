package stepDefinitions.UI_StepDefs.HomePage;


import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.CommonPage;
import pages.ContactUsPage;
import utilities.ReusableMethods;

import java.util.List;

import static stepDefinitions.Hooks.driver;


public class US_083_ContactUsMenuNavBar_stepDefs extends CommonPage {

    public Faker faker = new Faker();

    // NavBar daki butonlara isimlerini göndererek tıklamak mümkün oluyor
    @Given("User goes to homepage {string}")
    public void user_goes_to_homepage(String string) {
        driver.get(string);
        ReusableMethods.waitForPageToLoad(5);
    }

    @When("User click to Contact Us menu at the navbar")
    public void user_click_to_Contact_Us_menu_at_the_navbar() {
        ReusableMethods.waitForVisibility(getContactUsPage().contactUs, 5);
        getContactUsPage().contactUs.click();
    }

    @Then("User should be able to see Contact Us GET IN TOUCH text")
    public void user_should_be_able_to_see_Contact_Us_GET_IN_TOUCH_text() {
//        driver.get("https://test.urbanicfarm.com/contact-us");
        Assert.assertTrue(driver.getCurrentUrl().contains("https://test.urbanicfarm.com/contact-us"));
        ReusableMethods.waitForVisibility(getContactUsPage().getInTouchText, 5);
    }

    @Then("User click to {string}")
    public void user_click_to(String string) {
        ReusableMethods.waitForVisibility(getContactUsPage().sendMessageButton, 5);
        getContactUsPage().sendMessageButton.click();
    }

    @And("User should be able to see alert message name")
    public void user_should_be_able_to_see_alert_message_name() {
        Assert.assertEquals(getContactUsPage().alertMessages.get(0).getText(),"Please enter a valid name.");
    }
    @And("User should be able to see alert message email")
    public void user_should_be_able_to_see_alert_message_email() {
        Assert.assertEquals(getContactUsPage().alertMessages.get(1).getText(),"Please enter a valid email address.");
    }
    @And("User should be able to see alert message message area")
    public void user_should_be_able_to_see_alert_message_message_area() {
        Assert.assertEquals(getContactUsPage().alertMessages.get(2).getText(),"Please enter a message with at least 10 characters.");
    }

    @Then("User should be able to click after entering the required information {string}")
    public void user_should_be_able_to_click_after_entering_the_required_information(String string) {
        getContactUsPage().nameInput.sendKeys(faker.name().fullName());
        getContactUsPage().emailInput.sendKeys(faker.internet().emailAddress());
        getContactUsPage().subjectInput.sendKeys("Deneme Mesajı");
        getContactUsPage().messageTextArea.sendKeys("Deneme Mesajı");
        getContactUsPage().sendMessageButton.click();
        ReusableMethods.waitForVisibility(getContactUsPage().toastMessage, 5);
        Assert.assertEquals(getContactUsPage().toastMessage.getText(), "Thanks for your message! It has been sent to us.");
        getContactUsPage().toastMessage.click();

    }

//    @And("User should be able to see alert message {string}")
//    public void user_should_be_able_to_see_alert_message(String string) {
//        ReusableMethods.waitForVisibility(getContactUsPage().toastMessage, 5);
//        Assert.assertEquals(getContactUsPage().toastMessage.getText(), "Thanks for your message! It has been sent to us.");
//        getContactUsPage().toastMessage.click();
//
//    }


}
