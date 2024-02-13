package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountWeeklyOrderPage extends CommonPage{


    @FindBy (css="[href='/account/home'].align-items-center[title=\"My Account\"]")
    public WebElement profil_img_Account;



}
