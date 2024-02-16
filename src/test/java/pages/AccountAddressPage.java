package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class AccountAddressPage extends CommonPage{

    @FindBy(xpath = "//button[@name='sales']")
    public WebElement MySalesAddressBtn;

    @FindBy(xpath = "//button[@class='btn btn-outline-success']")
    public WebElement AddNewAddressBtn;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement SearchPlacesInput;

    @FindBy(xpath = "//ul[@class='list-group mt-2 autocomplete-dropdown-container']")
    public WebElement SelectDropDownAddress;

    @FindBy(xpath = "(//input[@id='postal'])[2]")
    public WebElement PostaZipCodeInput;

    @FindBy(xpath = "(//input[@id='isSellerAddress'])[2]")
    public WebElement MarkAsASalerAddressInput;

    @FindBy(xpath = "(//button[@class='btn btn-outline-success ml-3'])[2]")
    public WebElement MySalesAddressSubmitBtn;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement AlertYourAddresssuccessfullyAdded;

    @FindBy(xpath = "//button[@class='mr-2 btn btn-outline-warning']")
    public WebElement MySalesAddressEditBtn;

    @FindBy(xpath = "//button[@class='btn btn-outline-danger']")
    public WebElement MySalesAddressRemoveBtn;

    @FindBy(xpath = "//h5[@class='text-center mb-4']")
    public WebElement AreYouSureToDeleteTheAddressMessage;

    @FindBy(xpath = "//div[@class='form-row']")
    public WebElement AddressDetailsPage;

    @FindBy(xpath = "//div[@class='text-center mb-2']")
    public WebElement YesNoOptionsText;

    @FindBy(xpath = "//div[@class='Toastify__toast-body toastr_custom-toastr__iiU37']")
    public WebElement AlertYourAddresssuccessfullyUpdated;

    @FindBy(xpath = "//input[@id='addressTitle']")
    public WebElement AddressTitleInput;

    @FindBy(xpath = "//div[@class='card']")
    public WebElement MySalesAddressText;

    public void sendKeysAddressTitle(){
        ReusableMethods.sendText(getAccountAddressPage().AddressTitleInput,"Home Office");
    }

    public void addressOptions() throws InterruptedException {
        //driver.switchTo().frame("frame1");
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//ul[@class='list-group mt-2 autocomplete-dropdown-container']")).getText());
        Thread.sleep(3000);
        WebElement dropdownElement = driver.findElement(By.xpath("//ul[@class='list-group mt-2 autocomplete-dropdown-container']"));
        Select dropDown=new Select(dropdownElement);
        Thread.sleep(3000);
        dropDown.selectByVisibleText("California, Pensilvanya, Amerika Birleşik Devletleri");
        Thread.sleep(3000);
        //dropDown.selectByIndex(3);
        //dropDown.selectByValue("California");
        //dropDown.getFirstSelectedOption();
        //dropDown.selectByVisibleText("California");

    }

    public void sendKeysAddress() throws InterruptedException {
        Thread.sleep(3000);
        JSUtils.clickElementByJS(getAccountAddressPage().SearchPlacesInput);
        //JSUtils.setValueByJS(getAccountAddressPage().SearchPlacesInput,"California");
        //ReusableMethods.waitForClickablility(getAccountAddressPage().SearchPlacesInput,2).click();
        ReusableMethods.sendText(getAccountAddressPage().SearchPlacesInput,"California, Amerika Birleşik Devletleri");
        getAccountAddressPage().SearchPlacesInput.click();
    }

    public void verifyPageUrl(String expectedUrl) {
        //String expectedUrl = "https://test.urbanicfarm.com/account/address";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actual="+actualUrl);
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    public void sendKeysPostaZipCode(){

        getAccountAddressPage().PostaZipCodeInput.sendKeys("95170");

    }



}
