package stepDefinitions.UI_StepDefs.MyEventsPage;

import io.cucumber.java.en.And;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_080_EventsDeleteFunction_stepDefs extends CommonPage {
    @And("User sets the fee")
    public void userSetsTheFee() {
        getMyEventsPage().feeInput.sendKeys(Keys.BACK_SPACE);
        getMyEventsPage().feeInput.sendKeys("5");
    }
    @And("user enters the information in related input Address, Title, Address, Postal and click Submit")
    public void userEntersTheInformationInRelatedInputAddressTitleAddressPostalAndClickSubmit() {
        getMyEventsPage().addAddressSearchPlacesInput.sendKeys("California"+ Keys.ENTER);
        getMyEventsPage().PostalInput.sendKeys("94601");
        getMyEventsPage().SubmitBtnAtAddAdress.click();
    }

    @And("User enters the date")
    public void userEntersTheDate() {
        getMyEventsPage().CreateEventDateUS_77Btn.sendKeys("12/12/2024");
    }

    @And("User enters the time")
    public void userEntersTheTime() {
        getMyEventsPage().CreateEventTimeUS_77Btn.sendKeys("1800");
    }

    @And("User selects the address")
    public void userSelectsTheAddress() {
        getMyEventsPage().createEventAddressInput.click();
        ReusableMethods.waitForPageToLoad(5);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        Actions actions2 = new Actions(Driver.getDriver());
        actions2.sendKeys(Keys.ENTER).perform();

        ReusableMethods.waitFor(10);


    }

    @And("User enters title")
    public void userEntersTitle() {
        ReusableMethods.waitForPageToLoad(5);
        getMyEventsPage().CreateEventTitleUS_77Btn.sendKeys("Emily Shop");
    }

    @And("User verifies that a new event is created and deleted")
    public void userVerifiesThatANewEventIsCreatedAndDeleted() {
        ReusableMethods.waitForPageToLoad(5);
        getMyEventsPage().VerifyingNewEventIsCreated();
        getMyEventsPage().DeletingLastCreatedEvent();
    }
}
