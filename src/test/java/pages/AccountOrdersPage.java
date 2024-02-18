package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountOrdersPage extends CommonPage{
    @FindBy(xpath = "//div[@class='d-inline-flex justify-content-center align-items-center Navbar_cartCountContainer__1x0_c']")
    public WebElement card;//buyer sepet secenegi


}
