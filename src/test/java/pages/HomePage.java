package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage {


    @FindBy(xpath = "//input[@name='selamlar']" )
    public WebElement firstDeneme;
}
