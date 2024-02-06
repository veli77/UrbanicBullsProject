package pages;

import enums.URLOGIN;
import enums.USERCREDENTIAL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;

import static enums.URLOGIN.LOGIN_URL;

import static stepDefinitions.Hooks.driver;

public class LoginPage extends CommonPage{

    @FindBy(xpath = "//input[@name='email']")
    public WebElement input_email;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement input_password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit_button;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement LoginEmail;

    @FindBy(xpath = "//button[@class='btn alazea-btn']")
    public WebElement LoginSubmitButton;

    public void login(){

        ReusableMethods.waitForClickablility(LoginEmail,5).sendKeys("urbanicfarm2@yopmail.com");
        ReusableMethods.waitForClickablility(input_password,5).sendKeys("Urbanicfarm2/");
        ReusableMethods.waitForClickablility(LoginSubmitButton,7).click();

    }

    public void validCredential(){
        driver.get(LOGIN_URL.getLink());
        LoginEmail.sendKeys(USERCREDENTIAL.USER1.getUsername());
        input_password.sendKeys(USERCREDENTIAL.USER1.getPassword());
        submit_button.click();

    }


}
