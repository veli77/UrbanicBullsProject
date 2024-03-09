package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

import static utilities.ReusableMethods.waitForClickablility;

public class EventsPage extends CommonPage{
    @FindBy(xpath = "//*[text()='Events']")
    public WebElement EventsPage;
    @FindBy(xpath = "//button[text()='Scheduled Events']")
    public WebElement ScheduledEvents;

    @FindBy(xpath = ".ScheduledEvents_boxDiv__2ixVx")
    public List<WebElement> EventsList;

    @FindBy(xpath = "//button[text()='Register']")
    public List<WebElement> Register;

    @FindBy(xpath = "//h2[text()='Event Registration']")
    public WebElement EventsRegistration;

    @FindBy(css = "input[type='number']")
    public WebElement InputNumber;
    @FindBy(css = "input[type='checkbox']")
    public WebElement CheckboxImEvents;

    @FindBy(css = "button[type='submit']")
    public WebElement ApproveImEvents;
    @FindBy(xpath = "//div[@class='Toastify']//div//div//div")
    public WebElement ToastifyMessage;



    //ScheduledEvents butonuna tıklar
    public void clickScheduledEvents() {
        waitForClickablility(ScheduledEvents, 2);
        ScheduledEvents.click();
    }

    //eventlist i assert eder
    public void verifyToEventsList(){
        List<WebElement> element = new ArrayList<>(EventsList);
        Assert.assertFalse(element.isEmpty());
    }
    //eventlistde events ismini sorgulayip ceker
    public void clicksToEventsRegister(String str){
        List<WebElement> element = new ArrayList<>(EventsList);
        element.stream().filter(e->e.getText().equals(str)).findFirst().get().click();
    }

    //Events Registration yazisinin göründügünü assert eder
    public void verifyToEventRegistration() {
        waitForClickablility(EventsRegistration, 2);
    }

    public void EnterInvalidNumberToInput(List<List<String>> list) {

        ReusableMethods.sendText(InputNumber, list.get(0).get(1));
    }

    //Checkbox kutusuna tıklar
    public void clickCheckboxImEvents() {
        CheckboxImEvents.click();
    }

    //Approve butonuna tıklar
    public void clickApprroveInEvents() {
        ApproveImEvents.click();
    }

    public void verifyToToastifyMessage(String str) {
       Assert.assertEquals(str, ToastifyMessage.getText());
    }










}
