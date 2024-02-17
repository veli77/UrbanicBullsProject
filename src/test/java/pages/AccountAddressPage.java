package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.List;

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

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement MySalesAddressSubmitBtn;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement MySalesAddressEditSubmitBtn;

    @FindBy(xpath = "//div[@class='Toastify__toast-body toastr_custom-toastr__iiU37']")
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

    @FindBy(xpath = "//button[@class='address_accordionTab__116wZ address_accordionActive__2fQgS']")
    public WebElement MySalesAddressText;

    @FindBy(xpath = "//button[@class='btn btn-primary mr-4']")
    public List<WebElement> Yes_No_Btn;

    public void areYouSureToDeleteYESorNO(String option){
     WebElement element=driver.findElement(By.xpath("//button[text()='"+option+"']"));
     JSUtils.clickElementByJS(element);
    }

    public void sendKeysAddressTitle(){
        getAccountAddressPage().AddressTitleInput.clear();
        ReusableMethods.sendText(getAccountAddressPage().AddressTitleInput,"Emily's Home Office");
    }

    public void addressOptions() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//ul[@class='list-group mt-2 autocomplete-dropdown-container']")).getText());
        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='list-group mt-2 autocomplete-dropdown-container']")).stream().toList();
        list.getFirst().click();
        Thread.sleep(3000);
    }

    public void sendKeysAddress() throws InterruptedException {
        Thread.sleep(3000);
        JSUtils.clickElementByJS(getAccountAddressPage().SearchPlacesInput);
        //JSUtils.setValueByJS(getAccountAddressPage().SearchPlacesInput,"California");
        //ReusableMethods.waitForClickablility(getAccountAddressPage().SearchPlacesInput,2).click();
        ReusableMethods.sendText(getAccountAddressPage().SearchPlacesInput,"California");
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
