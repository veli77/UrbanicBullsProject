package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventsPage extends CommonPage{
    @FindBy(xpath = "//a[text()='Events']")
    public WebElement Events;
    @FindBy(xpath = "//a[text()='My Events']")
    public WebElement MyEvents;
    @FindBy(xpath = "//button[text()='Create New Event']")
    public WebElement CreatNewEvents;
    @FindBy(xpath = "//p[text()='CREATE EVENT']")
    public WebElement CreatEvent;
    @FindBy(css = "input#title")
    public WebElement title;




}
