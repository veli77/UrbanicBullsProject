package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static stepDefinitions.Hooks.driver;

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

    @FindBy(id = "SELLER_FLEXIBLE")
    public WebElement seller_flexible;

    @FindBy(css = "#freeFlexibleDeliveryRange")
    public WebElement freeFlexibleDeliveryRange;

    @FindBy(css = "#minFreeFlexibleDeliveryOrder")
    public WebElement minFreeFlexibleDeliveryOrder;

    @FindBy(css = "#perMileCostFlex")
    public WebElement perMileCostFlex;

    @FindBy(css = "#maxFlexibleDeliveryRange")
    public WebElement maxFlexibleDeliveryRange;

    @FindBy(css = "[type='submit']")
    public WebElement update;

    @FindBy(css = "#_deliveryBeginDay")
    public WebElement deliveryBeginDay;
    @FindBy(css = "#_deliveryBeginTime")
    public WebElement deliveryBeginTime;
    @FindBy(css = "#_deliveryEndDay")
    public WebElement deliveryEndDay;
    @FindBy(css = "#_deliveryEndTime")
    public WebElement deliveryEndTime;
    @FindBy(css = "#_orderByDay")
    public WebElement orderByDay;
    @FindBy(css = "#_orderByTime")
    public WebElement orderByTime;
    @FindBy(css = ".custom-checkbox input[type='checkbox']")
    public List<WebElement> checkBoxList;


    public void assertLabelWithWebelement(String expectedLabel, String webElementFor) {
        String actualLabel = driver.findElement(By.xpath("//label[@for='" + webElementFor + "']")).getText();
        Assert.assertTrue("actual : " + actualLabel + " , expected " + expectedLabel, actualLabel.contains(expectedLabel));
    }

    public void assertInputWithWebelement(String webElementId) {
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='" + webElementId + "']")).isDisplayed());

    }

    public void unCheckDeliverySettings() {
        checkBoxList
                .stream()
                .forEach(t -> {
                    if (t.isSelected()) {
                        t.click();
                    }
                });
    }



}
