package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountPage extends CommonPage{


    @FindBy (css="[href='/account/home'].align-items-center[title=\"My Account\"]")
    public WebElement profil_img_Account;



}
