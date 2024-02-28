package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.List;


import static utilities.ReusableMethods.waitForClickablility;
import static utilities.ReusableMethods.waitForVisibility;

public class MyEventsPage extends CommonPage{

    @FindBy(xpath = "//button[.='Create New Event']")
    public WebElement CreateNewEventBtn;
    @FindBy(xpath = "//button[@class='btn btn-outline-success mb-1'][.='Add']")
    public WebElement AddBtnAtCreateEventFrom;
    @FindBy(css = ".form-control.location-search-input")
    public WebElement SearchPlacesInput;
    @FindBy(css = ".autocomplete-dropdown-container>li")
    public List<WebElement> suggestedAddressList;
    @FindBy(xpath = "//input[@id='postal']")
    public WebElement PostalInput;
    @FindBy(xpath = "//input[@id='addressTitle']")
    public WebElement AddressTitleInput;
    @FindBy(xpath = "//input[@id='address']")
    public WebElement AddressInput; //Add yapıldıktan sonra gelen address Input'u
    @FindBy(css = ".btn.btn-outline-success.ml-3")
    public WebElement SubmitBtnAtAddAdress;
    @FindBy(xpath = "//div[@role='alert'][.='Your Address successfully added']")
    public WebElement ToastMessage;
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
    @FindBy(css = ".text-center.text-warning.mt-3")
    public List<WebElement> CreatedEventTitle;
    @FindBy(xpath = "//*[@name='delete']")
    public List<WebElement> DeleteEvent;
    @FindBy(css = "div[style='visibility: visible;'] .mr-4")
    public WebElement YestoDeleteEventButton;

    //Create new Event butonuna tıklar
    public void clickNewEvent(){
        waitForClickablility(CreateNewEventBtn,10);
        CreateNewEventBtn.click();
    }

    //Add butonuna tıklar yeni adress eklemek için
    public void clickAddBtn(){
        waitForClickablility(AddBtnAtCreateEventFrom,10);
        AddBtnAtCreateEventFrom.click();
    }

    //adres şablonu oluşturması için bir şehir adı yazar ve önerilerde ilk çıkanı seçer
    public void enterCityName(String city){
        waitForVisibility(SearchPlacesInput,10);
        SearchPlacesInput.sendKeys(city);
        suggestedAddressList.getFirst().click();
    }

    public void addAnAddress(String addressTitle,String address, String postal) {
        AddressTitleInput.clear();
        AddressTitleInput.sendKeys(addressTitle);
        AddressInput.clear();
        AddressInput.sendKeys(address);
        PostalInput.clear();
        PostalInput.sendKeys(postal);
        SubmitBtnAtAddAdress.click();
    }

    //Toast message kontrol eder
    public void checkAddedAddress(String toastMessage){
        waitForVisibility(ToastMessage,10);
        Assert.assertEquals(toastMessage,ToastMessage.getText());
    }
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
