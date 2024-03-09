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

    @Then("User clicks notification button")
    public void userClicksNotificationButton() {
        getNotificationPage().clickNotificationsButton();
    }

    @When("User should be able to see {}")
    public void userShouldBeAbleToSeeFilterByUnread(String message) {
        getNotificationPage().assertFilterByUnreadButton(message);
    }

    @And("User secondly should be able to see {}")
    public void userShouldBeAbleToSeeMarkAllAsRead(String message) {
        getNotificationPage().assertMarkAllAsRead(message);
    }

    @Then("User thirdly should be able to see {}")
    public void userShouldBeAbleToSeeViewAll(String message) {
        getNotificationPage().assertViewAll(message);
    }

    @And("After clicking View all button, user should be able to see {string}")
    public void userShouldBeAbleToSeeAfterClickingViewAllButton(String message) {
        getNotificationPage().assertNotificationsTitle(message);
    }

    @Then("User should be able to make notifications Unread")
    public void userShouldBeAbleToMakeNotificationsUnread() {
        getNotificationPage().unreadANotification();
    }


    @Then("User should be able to make notifications Read")
    public void userShouldBeAbleToMakeNotificationsRead() {
        getNotificationPage().readANotification();
    }

}
