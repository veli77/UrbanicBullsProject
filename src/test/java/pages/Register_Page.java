package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register_Page extends CommonPage{

    @FindBy(xpath = "//a[@class='Navbar_textLink__f6_Al mr-2']")
    public WebElement registerButton;

    @FindBy(xpath = "//div[@class='SocialLogins_login_btn__2b3rz']")
    public WebElement registerByGoogleA;
    @FindBy(xpath = "//input[@id='identifierId']")
    public WebElement sendEmail;
    @FindBy(xpath = "(//span[@jsname='V67aGc'])[2]")
    public WebElement nextButton;//send email den sonra gelen

    @FindBy(xpath = "//div[@class='Toastify__toast-body toastr_custom-toastr__iiU37']")
    public WebElement sussecsfullyMessage;



}
