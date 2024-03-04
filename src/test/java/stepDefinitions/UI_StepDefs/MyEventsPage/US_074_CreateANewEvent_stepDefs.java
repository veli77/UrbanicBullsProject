package stepDefinitions.UI_StepDefs.MyEventsPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import pages.MyEventsPage;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.List;

public class US_074_CreateANewEvent_stepDefs extends CommonPage {
    @Given("User goes to My Events Page")
    public void userGoesToMyEventsPage() {
        getMyEventsPage().MyEventsPageButton();

    }

    @When("User clicks the Create Event button")
    public void userClicksTheCreateEventButton() {
        getMyEventsPage().CreateNewEvent.click();
    }
    @And("User enters valid information to create a new event")
    public void userEntersValidInformationToCreateANewEvent(DataTable dataTable) {
        List<List<String>> listItems = dataTable.asLists(String.class);
        getMyEventsPage().EnterValidInformationForNewEvent(listItems);
    }

    @And("User adds an address for the event")
    public void userAddsAnAddressForTheEvent() {
        getMyEventsPage().AddNewEventAddress();
    }

    @Then("User clicks on the submit button")
    public void userClicksOnTheSubmitButton() {
        getMyEventsPage().UserSubmitsNewEvent();
    }

    @And("User verifies that a new event is created")
    public void userVerifiesThatANewEventIsCreated() {
        ReusableMethods.waitFor(5);
        getMyEventsPage().VerifyingNewEventIsCreated();
        getMyEventsPage().DeletingLastCreatedEvent();
    }
}
