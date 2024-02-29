package stepDefinitions.UI_StepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;


public class US_077_CreateEvent_stepDefs extends CommonPage {


    @When("User click to My Events btn at the button")
    public void userClickToMyEventsBtnAtTheButton() {
        ReusableMethods.waitAndClickElement(getMyEventsPage().MyEventsUS_77Btn, 3);
    }
    @When("User click to Create New Event btn at the button")
    public void userClickToCreateNewEventBtnAtTheButton() {
        ReusableMethods.waitAndClickElement(getMyEventsPage().CreateNewEventUS_77Btn, 3);
    }
    @When("User enter blank title")
    public void user_enter_blank_title() {
        ReusableMethods.waitAndClickElement(getMyEventsPage().CreateEventTitleUS_77Btn, 2);
        getMyEventsPage().CreateEventTitleUS_77Btn.sendKeys("");
    }
    @When("User enter address")
    public void user_enter_address() {
        getMyEventsPage().CreateEventAddressUS_77Btn.sendKeys("California");
    }
    @When("User enter date")
    public void user_enter_date() {
        ReusableMethods.waitAndClickElement(getMyEventsPage().CreateEventDateUS_77Btn, 2);
        getMyEventsPage().CreateEventDateUS_77Btn.sendKeys("02/29/2024");
    }
    @When("User enter time")
    public void user_enter_time() {
        getMyEventsPage().CreateEventTimeUS_77Btn.sendKeys("17.00 PM");
    }
    @When("User enter title")
    public void user_enter_title() {
        ReusableMethods.waitAndClickElement(getMyEventsPage().CreateEventTitleUS_77Btn, 2);
        getMyEventsPage().CreateEventTitleUS_77Btn.sendKeys("Emily Shop");
    }
    @When("User enter blank address")
    public void user_enter_blank_address() {
        ReusableMethods.waitAndClickElement(getMyEventsPage().CreateEventAddressUS_77Btn, 2);
        getMyEventsPage().CreateEventAddressUS_77Btn.sendKeys("");

    }
    @When("User enter blank time")
    public void user_enter_blank_time() {
        ReusableMethods.waitAndClickElement(getMyEventsPage().CreateEventTimeUS_77Btn, 2);
        getMyEventsPage().CreateEventTimeUS_77Btn.sendKeys("");
    }
    @When("User enter blank date")
    public void user_enter_blank_date() {
       // ReusableMethods.waitAndClickElement(getMyEventsPage().CreateEventDateUS_77Btn, 2);
        getMyEventsPage().CreateEventDateUS_77Btn.sendKeys("");
    }
    @When("User enter Attendee, schedule , description and terms and conditions and click submit button")
    public void user_enter_attendee_schedule_description_and_terms_and_conditions_and_click_submit_button() {
      getMyEventsPage().enterOtherDatas();
    }
    @Then("User see Please enter a valid title message")
    public void user_see_please_enter_a_valid_title_message() {
      Assert.assertTrue(getMyEventsPage().CreateEventInvTitleMessageUS_77Btn.getText().contains("title"));
    }
    @Then("User see Please select an address message")
    public void user_see_please_select_an_address_message() {
        Assert.assertTrue(getMyEventsPage().CreateEventInvAddressMessageUS_77Btn.getText().contains("address"));
    }
    @Then("User see Please fill in this field message for date")
    public void user_see_please_fill_in_this_field_message_for_date() {
        Assert.assertTrue(getMyEventsPage().CreateEventDateInvMessageUS_77Btn.getText().contains("this field"));
    }
    @Then("User see Please fill in this field message for time")
    public void user_see_please_fill_in_this_field_message_for_time() {
       Assert.assertTrue(getMyEventsPage().CreateEventTimeInvUS_77Btn.getText().contains("this field"));
    }

}
