package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class AccountWeeklyOrderPage extends CommonPage{


    @FindBy (css="[href='/account/home'].align-items-center[title=\"My Account\"]")
    public WebElement profil_img_Account;

    @FindBy(xpath = "(//a[@class='Sidebar_smFont__16-hW Sidebar_section_btn__1sp6i h6 '])[3]")
    public WebElement YourProducts_Services;

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




}
