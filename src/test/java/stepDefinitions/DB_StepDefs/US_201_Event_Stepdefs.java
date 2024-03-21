package stepDefinitions.DB_StepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DBUtilities;

import java.sql.SQLException;

public class US_201_Event_Stepdefs {
    @When("User create an event")
    public void userCreateAnEvent() {
        DBUtilities.createEvent("Turgut", 100);
    }

    @Then("User should be able to reach event")
    public void userShouldBeAbleToReachEvent() throws SQLException {
        DBUtilities.verifyEvent();
    }

    @When("User update an event")
    public void userUpdateAnEvent() throws SQLException {
        DBUtilities.updateEvent("Turgut updated");
    }

    @Then("User should be able to reach updated event")
    public void userShouldBeAbleToReachUpdatedEvent() throws SQLException {
        DBUtilities.verifyUpdateEvent();
    }

    @When("User delete an event")
    public void userDeleteAnEvent() throws SQLException {
        DBUtilities.deleteEvent();
    }

    @Then("User should be able to reach deleted event")
    public void userShouldBeAbleToReachDeletedEvent() throws SQLException {
        DBUtilities.verifyDeleteEvent();
    }
}
