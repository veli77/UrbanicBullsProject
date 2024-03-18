package stepDefinitions.UI_StepDefs.MyEventsPage;

import enums.USERCREDENTIAL;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

import java.util.List;

public class us_081_Copy_Cancel_Completed_Function extends CommonPage {
    @Given("Useraa login as USERBASEWEBSITE")
    public void useraaLoginAsUSERBASEWEBSITE() {
        getLoginPage().login(USERCREDENTIAL.USER2);
    }

    @Given("Useraa goes to My Events Page")
    public void useraaGoesToMyEventsPage() {
        ReusableMethods.waitFor(3);
        getMyEventsPage().MyEventsButton.click();
    }

    @When("Useraa clicks the Create Event button")
    public void useraaClicksTheCreateEventButton() {
        getMyEventsPage().clickNewEvent();
    }

    @And("Useraa adds an address for the event")
    public void useraaAddsAnAddressForTheEvent() {
        getMyEventsPage().AddNewEventAddress();
    }

    @And("Useraa enters valid information to create a new event")
    public void useraaEntersValidInformationToCreateANewEvent(DataTable datatable) {
        List<List<String>> listItems = datatable.asLists(String.class);
        getMyEventsPage().EnterValidInformationForNewEvent(listItems);
    }

    @When("Useraa clicks on the submit button")
    public void useraaClicksOnTheSubmitButton() {
        getMyEventsPage().UserSubmitsNewEvent();
    }

    @And("Useraa verifies that a new event is created")
    public void useraaVerifiesThatANewEventIsCreated() {
        getMyEventsPage().VerifyingNewMYEventIsCreated();
    }

    @Then("Useraa clicks the Copy Link button")
    public void useraaClicksTheCopyLinkButton() {
        getMyEventsPage().CopyLinkButton.click();
    }

    @And("Useraa should see the message Event Link Copied to Clipboard")
    public void useraaShouldSeeTheMessageEventLinkCopiedToClipboard() {
        ReusableMethods.waitForVisibility(getMyEventsPage().CopyToastMessage, 10);
        Assert.assertEquals(getMyEventsPage().CopyToastMessage.getText(), "Event Link Copied to Clipboard");
    }

    @When("Useraa clicks the Cancel button")
    public void useraaClicksTheCancelButton() {
        ReusableMethods.waitForVisibility(getMyEventsPage().LastCancelButton,5).click();
        //getMyEventsPage().LastCancelButton.click();
    }

    @Then("Useraa should see the message {string}")
    public void useraaShouldSeeTheMessage(String arg0) {
    }

    @And("There should be a {string} sign displayed when the event is cancelled")
    public void thereShouldBeASignDisplayedWhenTheEventIsCancelled(String arg0) {
    }

    @When("Useraa clicks My Completed Events")
    public void useraaClicksMyCompletedEvents() {
    }

    @And("there should be a {string} sign displayed when the event is completed")
    public void thereShouldBeASignDisplayedWhenTheEventIsCompleted(String arg0) {
    }

}
