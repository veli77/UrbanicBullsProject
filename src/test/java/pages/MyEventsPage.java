package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//a[text()='My Events']")
    public WebElement MyEventsButton;

    @FindBy(xpath = "//button[.='My Completed Events']")
    public WebElement MyCompletedEventsButton;

    @FindBy(xpath = "//button[.='Copy Link']")
    public WebElement CopyLinkButton;

    @FindBy(xpath = "//div[@role='alert'][.='Event Link Copied to Clipboard']")
    public WebElement CopyToastMessage;




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

    //
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

}
