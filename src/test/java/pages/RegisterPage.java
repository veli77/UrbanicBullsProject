package pages;

import groovy.xml.dom.DOMCategory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
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

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement FirstName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement LastName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement Email;

    @FindBy(xpath = "//input[@name='plainPassword']")
    public WebElement Password;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    public WebElement ConfirmPassword;

    @FindBy(xpath = "//div[text()='Welcome!']")
    public WebElement WelcomeMessage;

    @FindBy(xpath = "//button[@class='btn alazea-btn']")
    public WebElement RegisterButtonBottomofPage;


    // JavaScript kodunu çalıştır
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    public boolean validity = (boolean) jsExecutor.executeScript("var element = document.querySelector(\"input[name='plainPassword']\");" +
            "return element.validity.valid;");

    // JavaScript kodunu çalıştır
    JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
    public boolean validity2 = (boolean) jsExecutor2.executeScript("var element = document.querySelector(\"input[name='confirmPassword']\");" +
            "return element.validity.valid;");

    }

