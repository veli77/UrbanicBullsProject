package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.ReusableMethods.waitForClickablility;
import static utilities.ReusableMethods.waitForVisibility;

public class NotificationPage extends CommonPage{

    //LOCATORS START

    //@FindBy(xpath = "//span[@class='Notifications_notificationIconContainer__2jS5E']")
    //public WebElement notificationsButton;

    @FindBy(xpath = "//div[@class='Notifications_notificationNavContent__2SCct']")
    public WebElement notificationsButton;
    @FindBy(xpath = "//span[@class='Notifications_filterButton__3COw5' and text()='Filter by unread']")
    public WebElement filterByUnreadButton;
    @FindBy(xpath = "//span[@class='Notifications_filterButton__3COw5' and text()='Mark all as read']")
    public WebElement markAllAsReadButton;
    @FindBy(xpath = "//span[@class='Notifications_filterButton__3COw5' and text()='View all']")
    public WebElement viewAllButton;
    @FindBy(xpath = "//p[@class='Notifications_notificationDownContentTitle__25VyP']")
    public WebElement notificationsTitle;
    @FindBy(xpath = "//span[@class='Notifications_sliderNone__31Amf']")
    public WebElement notificationsOptionButton;

    //LOCATORS END

    //*****//

    //METHODS START

    // notifications buttonuna tiklar

    public void clickNotificationsButton(){
        waitForClickablility(notificationsButton,10);
        notificationsButton.click();
    }
    // filter by unread butonu oldugunu bu butonun tiklanabilir oldugunu ve yazan ifadenin Filter by unread oldugunu teyit eder
    public void assertFilterByUnreadButton(String message){
        waitForClickablility(filterByUnreadButton,10);
        String actualTextFilterByUnreadButton = filterByUnreadButton.getText();
        Assert.assertEquals("Non matched text",message,actualTextFilterByUnreadButton);
    }
    // mark all as read butonu oldugunu bu butonun tiklanabilir oldugunu ve yazan ifadenin Mark all as read oldugunu teyit eder
    public void assertMarkAllAsRead(String message){

        try {

            waitForClickablility(markAllAsReadButton,10);
            String actualTextMarkAllAsReadButton = markAllAsReadButton.getText();
            Assert.assertEquals("Non matched text",message,actualTextMarkAllAsReadButton);


        } catch (Exception e){
            waitForClickablility(notificationsOptionButton,10);
            notificationsOptionButton.click();

            waitForClickablility(markAllAsReadButton,10);
            String actualTextMarkAllAsReadButton = markAllAsReadButton.getText();
            Assert.assertEquals("Non matched text",message,actualTextMarkAllAsReadButton);
        }

        /*
        waitForClickablility(markAllAsReadButton,10);
        String actualTextMarkAllAsReadButton = markAllAsReadButton.getText();
        Assert.assertEquals("Non matched text",message,actualTextMarkAllAsReadButton);
         */
    }
    // view all mesajinin teyidi (filterByUnreadButton tiklanmali öncelikle)
    public void assertViewAll(String message){
        waitForClickablility(filterByUnreadButton,10); //view all butonunun görünebilmesi icin öncelikle filterByUnreadButton tiklanmasi gerekiyor
        filterByUnreadButton.click();
        String actualTextViewAllButton = viewAllButton.getText();
        Assert.assertEquals("Non matched text",message,actualTextViewAllButton);
    }
    // view all butonuna tiklandiktan sonra üst baslik olan Notifications'i teyit eder
    public void assertNotificationsTitle(String message){
        waitForClickablility(viewAllButton,10);
        viewAllButton.click();
        waitForVisibility(notificationsTitle,10);
    }
    // notifications unread yapma

    public void unreadANotification(){


        try {
            waitForClickablility(notificationsOptionButton,10);
            notificationsOptionButton.click();
        }catch (Exception e){
            waitForClickablility(notificationsOptionButton,10);
            notificationsOptionButton.click();

            waitForClickablility(notificationsOptionButton,10);
            notificationsOptionButton.click();
        }

        /*
        waitForClickablility(notificationsOptionButton,10);
        notificationsOptionButton.click();

         */




    }
    // notifications read yapma
    public void readANotification(){
        try {
            waitForClickablility(notificationsOptionButton,10);
            notificationsOptionButton.click();
        }catch (Exception e){
            waitForClickablility(notificationsOptionButton,10);
            notificationsOptionButton.click();

            waitForClickablility(notificationsOptionButton,10);
            notificationsOptionButton.click();
        }
    }




}
