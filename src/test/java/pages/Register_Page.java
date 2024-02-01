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

    @FindBy(xpath = "//input[@id='registration_form_firstname']")
    public WebElement nameForRegister;
    @FindBy(xpath = "//input[@id='registration_form_middlename']")
    public WebElement middlenameForRegister;
    @FindBy(xpath = "//input[@id='registration_form_lastname']")
    public WebElement lastNameForRegister;
    @FindBy(xpath = "//input[@id='registration_form_email']")
    public WebElement emailForRegister;

    @FindBy(xpath = "//input[@id='registration_form_plainPassword']")
    public WebElement passwordForRegister;
    @FindBy(xpath = "//input[@id='registration_form_confirmPassword']")
    public WebElement confirmePasswordForRegister;
    @FindBy(xpath = "//button[@class='btn alazea-btn']")
    public WebElement registerButtonK;
    @FindBy(xpath = "//div[@class='Toastify__toast-body toastr_custom-toastr__iiU37']")
    public WebElement welcomeYazisi;

    @FindBy(xpath ="//input[@name='zipCode']")
    public WebElement zipKodK;







}
