package pages;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static stepDefinitions.Hooks.driver;

public class ContactUsPage extends CommonPage {
    @FindBy(css = "div>[href='/contact-us']")
    public WebElement contactUs;
    @FindBy(xpath = "//h2[@class='ContactUs_title__elsQ3']")
    public WebElement getInTouchText;
    @FindBy(css = "input[placeholder='Your Name']")
    public WebElement nameInput;
    @FindBy(css = "input[placeholder='Your Email']")
    public WebElement emailInput;
    @FindBy(css = "input[placeholder='Subject']")
    public WebElement subjectInput;
    @FindBy(css = "textarea[placeholder='Message']")
    public WebElement messageTextArea;
    @FindBy(css = "button[class='ContactUs_alazeaBtn__1JQKf mb-5']")
    public WebElement sendMessageButton;
    @FindBy(css = "div.ContactUs_inlineErrormsg__2kD8_")
    public List<WebElement> alertMessages;
    @FindBy(css = ".Toastify__toast-body.toastr_custom-toastr__iiU37")
    public WebElement toastMessage;





}
