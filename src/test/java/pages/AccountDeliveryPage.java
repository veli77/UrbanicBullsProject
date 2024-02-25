package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDeliveryPage extends CommonPage{

    @FindBy(xpath = "//a[text()='Delivery & Pick up settings']")
    public WebElement DeliveryPageButton;
    @FindBy(xpath = "//input[@value='BUYER_PICKUP_FROM_BRANCH']")
    public WebElement BuyerPicksUpOnTheVineCheckBox;

    @FindBy(xpath = "//*[@id=\"availabilityBranch\"]/span")
    public WebElement YourAvailableHoursText;

    @FindBy(xpath = "//input[@name='startTime2']")
    public WebElement StartTimeBuyerPicksUpOntheVine;

    @FindBy(xpath = "//input[@name='endTime2']")
    public WebElement EndTimeBuyerPicksUpOntheVine;

    @FindBy(xpath = "//button[text()='Update']")
    public WebElement UpdateButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement AlertText;

    @FindBy(xpath = "//a[@href='/account/delivery']")
    public WebElement DeliveryPickUpMenu;
}
