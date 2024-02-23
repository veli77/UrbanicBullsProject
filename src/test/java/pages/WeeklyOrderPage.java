package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.actions;

public class WeeklyOrderPage extends CommonPage {
    @FindBy(css = "[name='zipcode']")
    public WebElement zipCode;

    public void sendZipcode(String zipcode) {
        ReusableMethods.verifyElementDisplayed(zipCode);
        zipCode.sendKeys(zipcode);
        actions.sendKeys(Keys.ENTER).perform();
    }
}
