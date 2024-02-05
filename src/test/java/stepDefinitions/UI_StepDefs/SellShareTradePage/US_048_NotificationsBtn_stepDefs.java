package stepDefinitions.UI_StepDefs.SellShareTradePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.ReusableMethods;

public class US_048_NotificationsBtn_stepDefs extends CommonPage {


    @When("User clicks on Notification module")
    public void user_clicks_on_notification_module() {
        ReusableMethods.waitForClickablility(getSellShareTradePage().Notifications_SellShareTradePage,3).click();

    }


    @Then("User verifies that the Notification text has been opened")
    public void user_verifies_that_the_notification_text_has_been_opened() {
        getSellShareTradePage().verifyNotificationTextIsDisplayed();

    }

}
