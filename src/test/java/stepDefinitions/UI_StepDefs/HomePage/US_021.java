package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import pages.HomePage;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_021 extends CommonPage {
    @When("User clicks on the Features schedules delivery button")
    public void user_clicks_on_the_features_schedules_delivery_button() {
        ReusableMethods.hover(getHomePage().ScheduledDelivery);
        getHomePage().ScheduledDelivery.click();


    }
    @Then("User Verify that the Schedules Delivery page is displayed")
    public void user_verify_that_the_schedules_delivery_page_is_displayed() {
        Assert.assertTrue(driver.getCurrentUrl().contains("https://test.urbanicfarm.com/account/weekly-order"));
        }


}
