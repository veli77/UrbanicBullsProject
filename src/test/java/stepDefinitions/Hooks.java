package stepDefinitions;

import enums.URL_LINKS;
import enums.USERCREDENTIAL;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import utilities.*;

import static enums.USERCREDENTIAL.USER3;
import static io.restassured.RestAssured.given;


public class Hooks extends CommonPage{


    public static WebDriver driver;
    public static CommonPage commonPage;
    public static Actions actions;
    public static Response response;
    public static String token;


    public static boolean isHeadless = false;
    public static String browserType = "chrome";

    public static boolean isFullScreen = true;
    public static int width;
    public static int height;

@Before(value="@VideoRecorder")
public void recordStart(){

    System.out.println("Kayıt basladı");
    try {
        MyScreenRecorder.startRecording("VideoRecord");
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}


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

        System.out.println("Login metodu calıstı");
        driver.get(URL_LINKS.LOGIN_URL.getLink());
        getLoginPage().LoginEmail.sendKeys(USERCREDENTIAL.USER2.getUsername());
       // getHomePage().screenshotClick("C:\\Users\\ersin\\IdeaProjects\\UrbanicBullsProject\\src\\test\\java\\utilities\\sikuliX_ScreenShots\\loginEmailBox.jpg");
       // getHomePage().screenShotSendText("C:\\Users\\ersin\\IdeaProjects\\UrbanicBullsProject\\src\\test\\java\\utilities\\sikuliX_ScreenShots\\loginEmailBox.jpg");
        getLoginPage().input_password.sendKeys(USERCREDENTIAL.USER2.getPassword());
        getLoginPage().submit_button.click();
        ReusableMethods.waitForPageToLoad(5);
        getAccountHomePage().zipCodeBoxCloseButton.click();
    }

    @Before(value = "@Login2")
    public void login2() {
        //loginPage=new LoginPage();
        System.out.println("Login2 metodu calıstı");
        driver.get(URL_LINKS.LOGIN_URL.getLink());
        getLoginPage().LoginEmail.sendKeys(USER3.getUsername());
        getLoginPage().input_password.sendKeys(USER3.getPassword());
        getLoginPage().submit_button.click();
        ReusableMethods.waitForPageToLoad(5);
        getAccountHomePage().zipCodeBoxCloseButton.click();
    }
    @Before(value = "@Login3")
    public void login3() {
        //loginPage=new LoginPage();

        System.out.println("Login metodu calıstı");

        driver.get(URL_LINKS.LOGIN_URL.getLink());
       getLoginPage().LoginEmail.sendKeys(USERCREDENTIAL.USERVEDAT.getUsername());
        getLoginPage().input_password.sendKeys(USERCREDENTIAL.USERVEDAT.getPassword());
        getLoginPage().submit_button.click();
        ReusableMethods.waitForPageToLoad(5);
        getAccountHomePage().zipCodeBoxCloseButton.click();

    }
// Ana web sitesinden Test icin Login
    @Before(value = "@LoginBase")
    public void loginWithBaseWebsiteCredential() {
        //loginPage=new LoginPage();

        System.out.println("Login metodu calıstı");

        driver.get(URL_LINKS.BASEPAGELOGIN_URL.getLink());
        getLoginPage().LoginEmail.sendKeys(USERCREDENTIAL.USERBASEWEBSITE.getUsername());
        getLoginPage().input_password.sendKeys(USERCREDENTIAL.USERBASEWEBSITE.getPassword());
        getLoginPage().submit_button.click();
        ReusableMethods.waitForPageToLoad(5);
        getAccountHomePage().zipCodeBoxCloseButton.click();

    }

    @After(value = "@VideoRecorder")
    public void stopRecording() {

        //System.out.println("Kayıt bitti");

        try {
            MyScreenRecorder.stopRecording();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
            DBUtilities.createConnection();

    }

    @After("@DB")
    public void closeDatabase() {
         //  DatabaseUtilities.closeConnection();

    }

    @Before("@user1")
    public void denemeLogin() {
        System.out.println(
                "email : " + ConfigurationReader.getProperty("user1_email") +
                        " password : " + ConfigurationReader.getProperty("user1_password")
        );
    }

    public String getToken(USERCREDENTIAL usercredential){
    response = given()
            .contentType(ContentType.JSON)
            .body("{\"email\": \""+usercredential.getUsername()+"\",\"password\": \""+usercredential.getPassword()+"\"}")
            .when()
            .post("https://test.urbanicfarm.com/api/public/login");

        JsonPath jsonPath = response.jsonPath();
        token = jsonPath.getString("token");

        return token;
    }

    @Before("@user3token")
    public void user3Token(){
    getToken(USER3);

    }
}