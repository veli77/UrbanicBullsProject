package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;

public class AccountWeeklyOrderPage extends CommonPage{


    @FindBy (css="[href='/account/home'].align-items-center[title=\"My Account\"]")
    public WebElement profil_img_Account;
    @FindBy(xpath = "(//a[@class='Sidebar_smFont__16-hW Sidebar_section_btn__1sp6i h6 '])[3]")
    public WebElement YourProducts_Services;
    @FindBy(css = "[href='/account/address']")
    public WebElement accountAddressBtnAtTheLeftBar;
    @FindBy(css = "div[class='CheckDistrictModal_x-btn__sVOij']")
    public WebElement zipCodeBoxCloseButton;
    @FindBy(css = "[name='zipcode']")
    public WebElement zipCode;

    //Sayfanın sag tafında bulunan ADDRESS btn'a tıklar, öncesinde implicit wait yapar
    public void clickAddressBtnAtTheLeftBar(){
        ReusableMethods.staleElementSolution(accountAddressBtnAtTheLeftBar);
        JSUtils.clickElementByJS(accountAddressBtnAtTheLeftBar);
    }

    @FindBy(xpath = "//a[@href='/account/address']")
    public WebElement AddressBtn;

    public void setYourProducts_ServicesBtnClick() throws InterruptedException {
        JSUtils.clickElementByJS(getAccountWeeklyOrderPage().YourProducts_Services);
        Thread.sleep(3000);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

    }

    public void verifyGoToPreviousPage() {
        String expectedUrl = "https://test.urbanicfarm.com/account/weekly-order";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actual="+actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);
    }


    public void sendZipcode(String zipcode) {
        ReusableMethods.verifyElementDisplayed(zipCode);
        zipCode.sendKeys(zipcode);
        actions.sendKeys(Keys.ENTER).perform();
    }

}
