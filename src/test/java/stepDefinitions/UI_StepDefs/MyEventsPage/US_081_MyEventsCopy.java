package stepDefinitions.UI_StepDefs.MyEventsPage;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

public class US_081_MyEventsCopy extends CommonPage {
    @Given("User login as USERBASEWEBSITE")
    public void userLoginAsUSERBASEWEBSITE() {
        getLoginPage().loginBase(USERCREDENTIAL.USERBASEWEBSITE);
    }

    @When("User clicks My Events menu")
    public void userClicksMyEventsMenu() {
        ReusableMethods.waitFor(3);
        getMyEventsPage().MyEventsButton.click();
    }

    @Then("User should be able to see Create New Event Button")
    public void userShouldBeAbleToSeeCreateNewEventButton() {
        getMyEventsPage().CreateNewEventBtn.isDisplayed();
        Assert.assertEquals("Create New Event", getMyEventsPage().CreateNewEventBtn.getText());
    }

    @When("User clicks My Completed Events")
    public void userClicksMyCompletedEvents() {
        getMyEventsPage().MyCompletedEventsButton.click();
    }

    @Then("User clicks the Copy Link button")
    public void userClicksTheCopyLinkButton() {
        getMyEventsPage().CopyLinkButton.click();
    }

    @And("User should see the message Event Link Copied to Clipboard")
    public void userShouldSeeTheMessage() {
        //ReusableMethods.waitFor(3);
        ReusableMethods.waitForVisibility(getMyEventsPage().CopyToastMessage, 10);
        Assert.assertEquals(getMyEventsPage().CopyToastMessage.getText(), "Event Link Copied to Clipboard");
        //getMyEventsPage().CopyToastMessage.isDisplayed();
        //Assert.assertEquals("Event Link Copied to Clipboard", getMyEventsPage().CopyToastMessage.getText());
    }
}
