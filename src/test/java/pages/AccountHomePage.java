package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountHomePage extends CommonPage{
    @FindBy(css = "div[class*='px-0 m-0 mt-2'] a")
    public List<WebElement> accountPageLeftsidesTabs;

    @FindBy(css = "div[class='CheckDistrictModal_x-btn__sVOij']")
    public WebElement zipCodeBoxCloseButton;

    @FindBy(css = "a[class*='Sidebar_active__1HCV5']")
    public WebElement addressButton;

    @FindBy(xpath = "(//div[@class='col-12 col-sm-2 col-md-2 col-lg-2 col-xl-1 px-0 m-0 mt-2']//a)[5]")
    public WebElement leftSideOrdersButton;



}
