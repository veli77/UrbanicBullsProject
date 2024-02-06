package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static stepDefinitions.Hooks.driver;

public class RegisterPage extends CommonPage{

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


// Register sayfasinda olundugunun kontrolü
    public void registerPageCheck(){
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("register"));
    }

    // US_037 sukru

    @FindBy (id ="registration_form_firstname")
    private WebElement firstNameInput;

    @FindBy (id ="registration_form_middlename")
    private WebElement middleNameInput;

    @FindBy(id="registration_form_lastname")
    private WebElement lastNameInput;

    @FindBy (id ="registration_form_email")
    private WebElement eMailInput;

    @FindBy (id ="registration_form_plainPassword")
    private WebElement passwordInput;

    @FindBy (id ="registration_form_confirmPassword")
    private WebElement passwordConfirmInput;

    @FindBy (xpath = "//button[contains(text(), 'Register')]")
    private WebElement registerBtn;

    @FindBy (xpath = "//div[@role='alert'][contains(text(), 'Welcome!')]")
    private WebElement registerApproveMsg;

    public void typeRegisterInf(List<List<String>> listItems){
        ReusableMethods.sendText(firstNameInput, listItems.get(0).get(0));
        ReusableMethods.sendText(lastNameInput, listItems.get(0).get(1));
        ReusableMethods.sendText(eMailInput, listItems.get(0).get(2));
        ReusableMethods.sendText(passwordInput, listItems.get(0).get(3));
        ReusableMethods.sendText(passwordConfirmInput, listItems.get(0).get(3));
        ReusableMethods.waitAndClickElement(registerBtn, 2);
    }

    public void verifyAlertMessageIsAvailable(){
        String alertMessage = "Welcome!";
        Assert.assertEquals(alertMessage, ReusableMethods.getElementText(registerApproveMsg));
    }


}
