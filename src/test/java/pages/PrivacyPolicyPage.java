package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class PrivacyPolicyPage extends CommonPage{

    @FindBy(css = ".mb-5")
    public WebElement onlinePrivacyPolicyText;


    //Privacy Policy Page de olduğunuzu kanıtlar
    public void amIinPrivacyPolicyPage(){
        ReusableMethods.waitForPageToLoad(5);
        Assert.assertEquals("https://test.urbanicfarm.com/privacy-policy",driver.getCurrentUrl());
        Assert.assertTrue(onlinePrivacyPolicyText.isDisplayed());
    }


}
