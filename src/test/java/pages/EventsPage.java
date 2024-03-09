package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.ReusableMethods.waitForClickablility;

public class EventsPage extends CommonPage{
    //LOCATORS START
    @FindBy (xpath = "//span[@class='Event_eventBarText__2R8Yg']")
    WebElement eventsButton;
    @FindBy(xpath = "(//button[@class='Event_buttonRegister__1SHDV'])[1]")
    WebElement firstEventRegisterButton;


    //METODS START
    public void clickEventsButton(){
        waitForClickablility(eventsButton,10);
        eventsButton.click();
    }
    public void clickFirstEventRegisterButton(){
        waitForClickablility(firstEventRegisterButton,10);
        firstEventRegisterButton.click();
    }


}
