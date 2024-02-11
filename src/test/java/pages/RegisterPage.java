package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.driver;


import java.util.ArrayList;
import java.util.List;

import static stepDefinitions.Hooks.driver;

public class RegisterPage extends CommonPage{


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
    @FindBy(xpath = "//button[contains(text(), 'Register')]")
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
            JSUtils.clickElementByJS(registerBtn);  //her saniye click denemesi yapılması için eklendi

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
            JSUtils.clickElementByJS(registerBtn);  // her saniye click denemesi yapılması için eklendi

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
            JSUtils.clickElementByJS(registerBtn);  // her saniye click denemesi yapılması için eklendi

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
        for (int i = 0; i < listItems.size(); i++) {
//          gelen bilgi "empty" String değeri ise text="" olarak değişsin
//          text = ((listItems.get(i).get(0)).equals("empty")) ? text : listItems.get(i).get(0);
            text = ((listItems.get(i).get(0)) == null) ? text : listItems.get(i).get(0); // gelen bilgi null ise text="" olarak değişsin
            isTrue = listItems.get(i).get(1);

            emailForRegister.clear();
            ReusableMethods.sendText(emailForRegister, text);   // elemente scroll yapılma ihtiyacı için ara metod eklendi
            JSUtils.clickElementByJS(registerBtn);   // her saniye click denemesi yapılması için eklendi

            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            isValid = (Boolean) js.executeScript("return arguments[0].validity.valid", emailForRegister);
            assertEquals(Boolean.parseBoolean(isTrue), isValid);
        }
    }

    // Register sayfasinda olundugunun kontrolü
    public void registerPageCheck() {
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
        assertEquals(alertMessage, ReusableMethods.getElementText(registerApproveMsg));
    }
    //US_035 Gokhan
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
    //JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    //public boolean validity2 = (boolean) jsExecutor.executeScript("var element = document.querySelector(\"input[name='plainPassword']\");" +
      //      "return element.validity.valid;");

    // JavaScript kodunu çalıştır
    //JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
    //public boolean validity3 = (boolean) jsExecutor2.executeScript("var element = document.querySelector(\"input[name='confirmPassword']\");" +
      //      "return element.validity.valid;");

    //Gecersiz renk, first name, last name, password vs icin
    public String expectedInvalidColor = "rgba(245, 110, 105, 1)";

    }

