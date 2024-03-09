package stepDefinitions.UI_StepDefs.EventsPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.driver;


public class US_079_NotAbleToAttendTheSomeonesEvents_StepDefs extends CommonPage{
    @Then("User goes to Events Page")
    public void userGoesToEventsPage() {
        getWelcomePage().clickEvents();
    }

    @And("User see CurrentUrl {string}")
    public void userSeeCurrentUrl(String url) {
        assertEquals(driver.getCurrentUrl(), url);
    }

    @When("User clicks Scheduled Events")
    public void userClicksScheduledEvents() {

        getEventsPage().clickScheduledEvents();

    }
    @And("User see Events list")
    public void userSeeEventsList() {

        getEventsPage().verifyToEventsList();
    }

    @Then("user clicks on the Register button of the {string} events")
    public void userClicksOnTheRegisterButtonOfTheEvents(String str) {

        getEventsPage().clicksToEventsRegister(str);

    }

    @And("user see Event Registration")
    public void userSeeEventRegistration() {
        getEventsPage().verifyToEventRegistration();

    }

    @Given("user enters the number of participants blank")
    public void userEntersTheNumberOfParticipantsBlank(DataTable table) {
        List<List<String>>list = table.asLists(String.class);
        getEventsPage().EnterInvalidNumberToInput(list);

    }

    @And("user see so box will be red")
    public void userSeeSoBoxWillBeRed() {


    }

    @When("user checked check box of terms")
    public void userCheckedCheckBoxOfTerms() {
        getEventsPage().clickCheckboxImEvents();
    }

    @Then("user click on the approve button")
    public void userClickOnTheApproveButton() {

        getEventsPage().clickApprroveInEvents();

    }

    @And("user see the message {string}")
    public void userSeeTheMessage(String str) {

        getEventsPage().verifyToToastifyMessage(str);
    }

    @Given("user enters negativ number participant quantity")
    public void userEntersNegativNumberParticipantQuantity(DataTable table) {
        List<List<String>>list = table.asLists(String.class);
        getEventsPage().EnterInvalidNumberToInput(list);
    }

    @Given("user enters zero participant quantity")
    public void userEntersZeroParticipantQuantity(DataTable table) {
        List<List<String>>list = table.asLists(String.class);
        getEventsPage().EnterInvalidNumberToInput(list);
    }

    @Given("user enters the number of participants over the participant limits")
    public void userEntersTheNumberOfParticipantsOverTheParticipantLimits(DataTable table) {
        List<List<String>>list = table.asLists(String.class);
        getEventsPage().EnterInvalidNumberToInput(list);
    }

    @And("user see the message {string}Attendee Limit:{string}")
    public void userSeeTheMessageAttendeeLimit(String arg0, String arg1) {
    }

    @Given("user participant enters the number of valid participants")
    public void userParticipantEntersTheNumberOfValidParticipants(DataTable table) {
        List<List<String>>list = table.asLists(String.class);
        getEventsPage().EnterInvalidNumberToInput(list);
    }

    @When("user leaves the conditions box blank")
    public void userLeavesTheConditionsBoxBlank() {
    }

    @And("user see the checkout page")
    public void userSeeTheCheckoutPage(){

    }
    @And("user see the Checkbox message {string}")
    public void userSeeTheCheckboxMessage(String str){

    }
}
