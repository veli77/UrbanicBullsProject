package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class AccountHubPage extends CommonPage{

    public void VerifyYourProducts_ServicesPageUrl() throws InterruptedException {
        Thread.sleep(3000);
        String expectedUrl = "https://test.urbanicfarm.com/account/hub";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actual="+actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    public void goToPreviousPage()  {
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        //https://test.urbanicfarm.com/account/weekly-order   dönmeli
        ReusableMethods.waitForPageToLoad(5);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().back();
    }

    public void goToAddressPage(){


        ReusableMethods.hover(getAccountHomePage().accountPageLeftsidesTabs.get(1));
        JSUtils.clickElementByJS(getAccountHomePage().accountPageLeftsidesTabs.get(1));



    //    for (WebElement element : getAccountHomePage().accountPageLeftsidesTabs){
//
    //        if (element.getText().contains("Address")){
    //            ReusableMethods.hover(element);
    //            element.click();
    //        }
    //    }
    }

    public By getByPanelButton(String btnName){
        return By.xpath("//div/a[.='" + btnName + "']");
    }

    public void verifyLeftPanelButton(String btn){
        WebElement element=driver.findElement(getByPanelButton(btn));
        Assert.assertTrue(element.isEnabled());

    }

    public void clickAButtonInLeftPanel(String btnName){
        WebElement element= driver.findElement(getByPanelButton(btnName));
        ReusableMethods.hover(element);
       // element= driver.findElement(getByPanelButton(btnName));
       // JSUtils.scrollIntoViewJS(element);
        JSUtils.clickElementByJS(element);
    }

}
