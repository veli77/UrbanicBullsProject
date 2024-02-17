package pages;

import org.junit.Assert;

import static stepDefinitions.Hooks.driver;

public class AccountHubPage extends CommonPage{

    public void VerifyYourProducts_ServicesPageUrl() throws InterruptedException {
        Thread.sleep(3000);
        String expectedUrl = "https://test.urbanicfarm.com/account/hub";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actual="+actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    public void goToPreviousPage() throws InterruptedException {
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());   //https://test.urbanicfarm.com/account/weekly-order   dönmeli
        Thread.sleep(5000);
        driver.navigate().back();
    }



}
