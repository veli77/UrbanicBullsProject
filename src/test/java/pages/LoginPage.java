package pages;

import enums.USERCREDENTIAL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;

public class LoginPage extends CommonPage{

    @FindBy(xpath = "//input[@name='email']")
    public WebElement input_email;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement input_password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit_button;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alert_message;

    @FindBy(xpath = "(//input[@class='form-control mb-1 shadow-input validation_validation__iLr7O'])[1]")
    public WebElement LoginEmail;

    @FindBy(xpath = "//button[@class='btn alazea-btn']")
    public WebElement LoginSubmitButton;

    public void login(){

        ReusableMethods.waitForClickablility(LoginEmail,5).sendKeys("urbanicfarm2@yopmail.com");
        ReusableMethods.waitForClickablility(input_password,5).sendKeys("Urbanicfarm2/");
        ReusableMethods.waitForClickablility(LoginSubmitButton,7).click();

    }

    public void validCredential(){
        LoginEmail.sendKeys(USERCREDENTIAL.USER1.getUsername());
        input_password.sendKeys(USERCREDENTIAL.USER1.getPassword());
        submit_button.click();



    }


}
