package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.List;

public class MyEventsPage extends CommonPage {

    @FindBy(xpath = "//*[text()='My Events']")
    public WebElement MyEventsPage;
    @FindBy(css = "button.events-i-organize_btnCreate__2AWbt")
    public WebElement CreateNewEvent;
    @FindBy(css = "#title")
    public WebElement Eventtitle;
    @FindBy(css = ".btn.btn-outline-success.mb-1")
    public WebElement AddAddressButton;
    @FindBy(xpath = "//input[@type='search'][@role='combobox']")
    public WebElement SearchAddress;
    @FindBy(css = ".autocomplete-dropdown-container li")
    public List<WebElement> AddressSuggestions;
    @FindBy(css = "#addressTitle")
    public WebElement EventAddressTitle;
    @FindBy(css = "#postal")
    public WebElement ZipCode;
    @FindBy(css = ".btn-outline-success.ml-3")
    public WebElement SubmitAddressButton;
    @FindBy(css = "#date")
    public WebElement EventDate;
    @FindBy(css = "#time")
    public WebElement EventTime;
    @FindBy(css = "#fee")
    public WebElement EventFee;
    @FindBy(css = "#duration")
    public WebElement EventDuration;
    @FindBy(css = "#attendeeLimit")
    public WebElement EventAttendeeLimit;
    @FindBy(css = "#schedule")
    public WebElement EventSchedule;
    @FindBy(css = "#description")
    public WebElement EventDescription;
    @FindBy(css = "#tac")
    public WebElement EventTermsOfReference;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SubmitNewEventButton;
    @FindBy(css = "div[role='alert']")
    public WebElement AlertEventCreated;
    @FindBy(xpath = "//*[text()='NEW']")
    public WebElement NewEventSign;
    @FindBy(css = ".text-center.text-warning.mt-3")
    public List<WebElement> CreatedEventTitle;
    @FindBy(xpath = "//*[@name='delete']")
    public List<WebElement> DeleteEvent;
    @FindBy(css = "div[style='visibility: visible;'] .mr-4")
    public WebElement YestoDeleteEventButton;
    @FindBy(css = "[href='/account/address']")
    public WebElement AddressPageButton;
    @FindBy(xpath = "//*[text()='Remove']")
    public List<WebElement> RemoveAddressButton;
    @FindBy(xpath = "//*[text()='Yes']")
    public WebElement YestoDeleteAddressButton;

    public void MyEventsPageButton() {
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(MyEventsPage);
    }

    public void AddNewEventAddress() {
        JSUtils.clickElementByJS(AddAddressButton);
        JSUtils.clickElementByJS(SearchAddress);
        SearchAddress.sendKeys("San Jose");
        AddressSuggestions.getFirst().click();
        JSUtils.clickElementByJS(SubmitAddressButton);
        ReusableMethods.waitFor(5);
    }

    public void EnterValidInformationForNewEvent(List<List<String>> listItems) {

        ReusableMethods.sendText(Eventtitle, listItems.get(0).get(1));
        ReusableMethods.sendText(EventDate, listItems.get(1).get(1));
        ReusableMethods.sendText(EventTime, listItems.get(2).get(1));
        EventFee.clear();
        ReusableMethods.sendText(EventFee, listItems.get(3).get(1));
        ReusableMethods.sendText(EventDuration, listItems.get(4).get(1));
        ReusableMethods.sendText(EventAttendeeLimit, listItems.get(5).get(1));
        ReusableMethods.sendText(EventSchedule, listItems.get(6).get(1));
        ReusableMethods.sendText(EventDescription, listItems.get(7).get(1));
        ReusableMethods.sendText(EventTermsOfReference, listItems.get(8).get(1));
    }

    public void UserSubmitsNewEvent() {
        JSUtils.clickElementByJS(SubmitNewEventButton);
        JSUtils.clickElementByJS(SubmitNewEventButton);
    }

    public void VerifyingNewEventIsCreated() {
        AlertEventCreated.isDisplayed();
        Assert.assertEquals("New Event", CreatedEventTitle.getLast().getText());
    }
    public void DeletingLastCreatedEvent () {
        JSUtils.clickElementByJS(DeleteEvent.getLast());
        YestoDeleteEventButton.click();
    }
}
