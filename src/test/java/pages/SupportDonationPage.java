package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class SupportDonationPage extends CommonPage{
    @FindBy(css = "[href='https://wefunder.com/urbanicfarm'].Navbar_navbar-anchor__2WQhH.text-white")
    public WebElement SupportButton;

    @FindBy(css = "[id='perks-display]")
    public WebElement DonationBox;

    @FindBy(css = "[id=\"2021-invest-button\"]")
    public WebElement ReserveButton;

    @FindBy(css = ".rounded-none.w-64.pl-7")
    public WebElement DonationReserve;



    public void clickDonationSupportButton(){
        //ReusableMethods.waitForClickablility(getSupportDonationPage().SupportButton, 10);
        ReusableMethods.waitFor(2);
        ReusableMethods.hover(getSupportDonationPage().SupportButton);
        getSupportDonationPage().SupportButton.click();
    }

    public void sendDonation(String donationAmount){
        ReusableMethods.waitForClickablility(getSupportDonationPage().ReserveButton,10);
        getSupportDonationPage().DonationBox.click();
        getSupportDonationPage().DonationBox.sendKeys(donationAmount);
        getSupportDonationPage().ReserveButton.click();

    }

    public void controlDonationAmount(String donationAmount){
        ReusableMethods.waitForPageToLoad(5);
        String actualAmount = getSupportDonationPage().DonationReserve.getText();
        Assert.assertEquals(donationAmount,actualAmount);

    }
    public void controlDonationPage(String expectedUrl){
        ReusableMethods.waitForPageToLoad(5);
        ReusableMethods.switchToWindow(1);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl);

    }
}
