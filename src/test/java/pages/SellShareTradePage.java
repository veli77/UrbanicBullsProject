package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class SellShareTradePage extends CommonPage{

     @FindBy(xpath = "//div[*='Sell-Share-Trade']")
    public WebElement Sell_Share_TradeBtn;

     @FindBy(xpath = "//a[@class='Navbar_textLink__f6_Al ml-2 mr-4']")
    public WebElement LogoutBtn_SellShareTradePage;

     @FindBy(xpath = "(//div/span[@class='Notifications_notificationIconContainer__2jS5E'])[1]")
    public WebElement Notifications_SellShareTradePage;

     @FindBy(xpath = "//div[@class='Notifications_notificationDownEmpty__JLqO3']")
    public WebElement Notifications_SellShareTradePage_text;

    @FindBy(xpath = "//div[@class='BasketDropdown_container__15BpD']")
    public WebElement Cart_SellShareTradePage;

    @FindBy(xpath = "//a[@class='Navbar_textLink__f6_Al mr-4 ml-1']")
    public WebElement ContactUsBtn_SellShareTread;

    @FindBy(className ="Event_eventBarText__2R8Yg")
    public WebElement eventsBtn;

    @FindBy(xpath = "//a[@title='My Account']")
    public WebElement usernameBtn;

    @FindBy (xpath = "//a[.='Scheduled Delivery']")
    private WebElement scheduled_Delivery_Btn;

    @FindBy (xpath = "//p[contains(text(), 'Locally grown, finest varieties of vegetables and microgreens delivered')]")
    private WebElement scheduled_Delivery_Page_Title;

    @FindBy(xpath = "//span[.='Sell-Share-Trade']")
    private WebElement sellShareTradeBtn;

    public void verifyHomePage() {
        String expectedUrl = "https://test.urbanicfarm.com/";
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    public void verifyNotificationTextIsDisplayed(){
        Assert.assertTrue(getSellShareTradePage().Notifications_SellShareTradePage_text.getText().contains("Notifications"));
    }

    public void verifyCartPage(){
        String expectedUrl = "https://test.urbanicfarm.com/account/hub";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actual="+actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    public void userNameBtnClick(){
        usernameBtn.click();
    }

    public void clickSellShareTradeBtn(){
        sellShareTradeBtn.click();
        ReusableMethods.waitForPageToLoad(10);
    }

    public void verifyScheduledDeliveryLink(){
        verifyScheduledDeliveryBtn();
        verifyScheduledDeliveryPage();


    }

    public void verifyScheduledDeliveryBtn(){
        Assert.assertTrue(scheduled_Delivery_Btn.isEnabled());
        scheduled_Delivery_Btn.click();
    }

    public void verifyScheduledDeliveryPage(){
        Assert.assertTrue(scheduled_Delivery_Page_Title.isEnabled());
    }



    public void eventsBtnClik(){
        eventsBtn.click();
    }


}
