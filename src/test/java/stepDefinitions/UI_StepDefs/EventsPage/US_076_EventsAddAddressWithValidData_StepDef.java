package stepDefinitions.UI_StepDefs.EventsPage;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;

public class US_076_EventsAddAddressWithValidData_StepDef extends CommonPage {


    @Given("User login as User Erdal")
    public void userLoginAsUserErdal() {
        getLoginPage().login(USERCREDENTIAL.USERERDAL);
    }

    @And("User goes to MyEvents Page")
    public void userGoesToMyEventsPage() {
        getWelcomePage().clickMyEvents();
    }

    @And("User clicks Create New Event")
    public void userClicksCreateNewEvent() {
        getMyEventsPage().clickNewEvent();
    }

    @And("User click Add Button for new Address adding")
    public void userClickAddButtonForNewAddressAdding() {
        getMyEventsPage().clickAddBtn();
    }

    @And("User enter {string} as a city name")
    public void userEnterAsACityName(String city) {
        getMyEventsPage().enterCityName(city);
    }

    @When("user enters the informations in relateds input {string} {string} {string} and click Submit")
    public void userEntersTheInformationsInRelatedsInputAndClickSubmit(String addressTitle,String address, String postal) {
        getMyEventsPage().addAnAddress(addressTitle,address,postal);
    }

    @Then("user should be able to see added address {string}")
    public void userShouldBeAbleToSeeAddedAddress(String toastMessage) {
        getMyEventsPage().checkAddedAddress(toastMessage);
    }
}
