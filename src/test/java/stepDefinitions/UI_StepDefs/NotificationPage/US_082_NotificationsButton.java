package stepDefinitions.UI_StepDefs.NotificationPage;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;

public class US_082_NotificationsButton extends CommonPage {

    @Given("User logins the page")
    public void userLoginsThePage() {
        getLoginPage().login(USERCREDENTIAL.USER2);
    }

    /*@Then("User clicks notification button")
    public void userClicksNotificationButton() {
    }

    @When("User should be able to see {string}")
    public void userShouldBeAbleToSee(String arg0) {
    }

    @And("User should be able to see {string} after clicking View all button")
    public void userShouldBeAbleToSeeAfterClickingViewAllButton(String arg0) {
    }

    @Then("User should be able to make notifications Unread")
    public void userShouldBeAbleToMakeNotificationsUnread() {
    }

    @Then("User should be able to make notifications Read")
    public void userShouldBeAbleToMakeNotificationsRead() {
    }

     */
}
