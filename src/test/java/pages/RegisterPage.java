package pages;

import io.cucumber.messages.types.Scenario;
import io.cucumber.plugin.event.Node;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;
import utilities.ReusableMethods;


import java.util.List;

import static org.junit.Assert.*;

public class RegisterPage extends CommonPage {

    @FindBy(xpath = "//button[contains(text(), 'Register')]")
    public WebElement registerBtn;

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

    @FindBy(xpath = "//input[@name='zipCode']")
    public WebElement zipKodK;

    public void clickMainButton(String btnName){
        WebElement element = Driver.getDriver().findElement(By.xpath("//div/a[contains(text(), '" +
                btnName + "')]"));
        element.click();
    }

    public void verifyFirstNames(List<List<String>> listItems){
        String text="";
        String isTrue;
        Boolean isValid;
        for(int i=0; i<listItems.size(); i++){
//          gelen bilgi "empty" String değeri ise text="" olarak değişsin
//          text = ((listItems.get(i).get(0)).equals("empty")) ? text : listItems.get(i).get(0);
            text = ((listItems.get(i).get(0)) == null) ? text : listItems.get(i).get(0); // gelen bilgi null ise text="" olarak değişsin
            isTrue = listItems.get(i).get(1);

            nameForRegister.clear();
            nameForRegister.sendKeys(text);   //elemente scroll yapılma ihtiyacı için ara metod eklendi
            registerBtn.click();  //her saniye click denemesi yapılması için eklendi

            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            isValid = (Boolean) js.executeScript("return arguments[0].validity.valid", nameForRegister);
            assertEquals(Boolean.parseBoolean(isTrue), isValid);
        }
    }

    public void verifyMiddleNames(List<List<String>> listItems){
        String text="";
        String isTrue;
        Boolean isValid;
        for(int i=0; i<listItems.size(); i++){
//          gelen bilgi "empty" String değeri ise text="" olarak değişsin
//          text = ((listItems.get(i).get(0)).equals("empty")) ? text : listItems.get(i).get(0);
            text = ((listItems.get(i).get(0)) == null) ? text : listItems.get(i).get(0); // gelen bilgi null ise text="" olarak değişsin
            isTrue = listItems.get(i).get(1);

            middlenameForRegister.clear();
            middlenameForRegister.sendKeys(text);  // elemente scroll yapılma ihtiyacı için eklendi
            registerBtn.click();  // her saniye click denemesi yapılması için eklendi

            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            isValid = (Boolean) js.executeScript("return arguments[0].validity.valid", middlenameForRegister);
            assertEquals(Boolean.parseBoolean(isTrue), isValid);
        }
    }

    public void verifyLastNames(List<List<String>> listItems){
        String text="";
        String isTrue;
        Boolean isValid;
        for (int i=0; i<listItems.size(); i++) {
//          gelen bilgi "empty" String değeri ise text="" olarak değişsin
//          text = ((listItems.get(i).get(0)).equals("empty")) ? text : listItems.get(i).get(0);
            text = ((listItems.get(i).get(0)) == null) ? text : listItems.get(i).get(0); // gelen bilgi null ise text="" olarak değişsin
            isTrue = listItems.get(i).get(1);

            lastNameForRegister.clear();
            ReusableMethods.sendText(lastNameForRegister,text);   // elemente scroll yapılma ihtiyacı için eklendi
            registerBtn.click();  // her saniye click denemesi yapılması için eklendi

            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            isValid = (Boolean) js.executeScript("return arguments[0].validity.valid", lastNameForRegister);
            assertEquals(Boolean.parseBoolean(isTrue), isValid);
        }
    }

    public void verifyEmails(List<List<String>> listItems){
        String text="";
        String isTrue;
        Boolean isValid;
        String message;
        for(int i=0; i<listItems.size(); i++){
//          gelen bilgi "empty" String değeri ise text="" olarak değişsin
//          text = ((listItems.get(i).get(0)).equals("empty")) ? text : listItems.get(i).get(0);
            text = ((listItems.get(i).get(0)) == null) ? text : listItems.get(i).get(0); // gelen bilgi null ise text="" olarak değişsin
            isTrue = listItems.get(i).get(1);

            emailForRegister.clear();
            ReusableMethods.sendText(emailForRegister,text);   // elemente scroll yapılma ihtiyacı için ara metod eklendi
            registerBtn.click();   // her saniye click denemesi yapılması için eklendi

            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            isValid = (Boolean) js.executeScript("return arguments[0].validity.valid", emailForRegister);
            assertEquals(Boolean.parseBoolean(isTrue), isValid);

            message = (String) js.executeScript("return arguments[0].validationMessage", emailForRegister);
            verifyMessage(text, message);
        }
    }

    public void verifyMessage(String email, String message){
        if ((!email.contains("@")) && (!email.isEmpty())){
            assertTrue(message.contains("@"));
        }
    }

}
