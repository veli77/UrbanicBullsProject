package stepDefinitions;

import enums.URL_LINKS;
import enums.USERCREDENTIAL;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Hooks extends CommonPage{


    public static WebDriver driver;
    public static CommonPage commonPage;
    public static Actions actions;
   // public static LoginPage loginPage;

    public static boolean isHeadless = false;
    public static String browserType = "chrome";

    public static boolean isFullScreen = true;
    public static int width;
    public static int height;



    @Before(value = "@headless", order = 0)
    public void setIsHeadless() {
        isHeadless = true;
    }

    @Before(value = "@firefox", order = 0)
    public void setIsFirefox() {
        browserType = "firefox";
    }


    @Before(value = "@iPhone12", order = 0)
    public void setiPhone12() {
        isFullScreen = false;
        width = 390;
        height = 844;
    }

    @Before(order = 1, value = "@UI")
    public void setup() {

        driver = Driver.getDriver();
        commonPage = new CommonPage() {
        };
        actions = new Actions(driver);
    }

    @Before(value = "@Login")
    public void login() {
        //loginPage=new LoginPage();

        driver.get(URL_LINKS.LOGIN_URL.getLink());
        getLoginPage().LoginEmail.sendKeys(USERCREDENTIAL.USER2.getUsername());
        getLoginPage().input_password.sendKeys(USERCREDENTIAL.USER2.getPassword());
        getLoginPage().submit_button.click();
        ReusableMethods.waitForPageToLoad(5);
        getAccountPage().zipCodeBoxCloseButton.click();



    }

    @After(value = "@UI")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }


        Driver.closeDriver();


    }


    @Before("@DB")
    public void setupDatabase() {
        //    DatabaseUtilities.createConnection();

    }

    @After("@DB")
    public void closeDatabase() {
        //   DatabaseUtilities.closeConnection();

    }

    @Before("@user1")
    public void denemeLogin() {
        System.out.println(
                "email : " + ConfigurationReader.getProperty("user1_email") +
                        " password : " + ConfigurationReader.getProperty("user1_password")
        );


    }


}