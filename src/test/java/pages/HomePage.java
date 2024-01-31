package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage {

    @FindBy(xpath = "//button[@class='abcde']")
    public WebElement denemeElement;




    @FindBy(xpath = "//input[@name='selamlar']" )
    public WebElement firstDeneme;


    @FindBy(css = "[href='/terms-of-service']" )
    public WebElement TermOfService;
@FindBy(xpath = "//*[@class='text-center mb-5']" )
    public WebElement TermOfServiceIsDiplayed;





}
