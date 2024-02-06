package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static stepDefinitions.Hooks.driver;

public class HomePage extends CommonPage {

    @FindBy(xpath = "//a[text()='Discover Local Sellers Near You']")
    public WebElement DiscoverLocalSellers;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[4]/div[4]/div/div[1]/div[1]/ul/li[3]/a")
    public WebElement GetTheApp;

    @FindBy(xpath = "//p[text()='Sell Your Products']")
    public WebElement SellYourProducts;

    @FindBy(xpath = "//button[text()='sell']")
    public WebElement SellButton;

    @FindBy(xpath = "//button[text()='share']")
    public WebElement Sharebutton;

    @FindBy(xpath = "//button[text()='trade']")
    public WebElement TradeButton;

    @FindBy(xpath = "//*[@id='Urban\\u0131cFarm']")
    public WebElement UrbanicFarmLink;

    @FindBy(xpath = "//p[text()='Backyard ']")
    public WebElement BackyardGardeners;

    @FindBy(xpath = "//button[@class='Section11_shopButton__WbZY9']")
    public WebElement RegisterNowButton;

    @FindBy(xpath = "//button[@class='section-2_shopButton__17T04']")
    public WebElement GetFreshProduce;

    @FindBy(xpath = "//li/a[.='contact us'][@href='/contact-us']")
    public WebElement ContactUsBtnAtBotton;

    @FindBy(css = ".mr-4+[href='/auth/login']")
    public WebElement loginSegment;

    @FindBy(css = ".section-7_right__16a5T button")
    public List<WebElement> reduceWasteStrengthYourCommunityTab;

    @FindBy(xpath = "//div[@class='section-7_right__16a5T']/p")
    public WebElement reduceWasteStrength;

    @FindBy(css = ".section-7_btn1__YvVpM")
    public WebElement Whats_Near_YouButton;

    @FindBy(css = ".section-7_btn2__2lv_r")
    public WebElement Post_Your_GoodsButton;

    @FindBy(css = "[href='/terms-of-service']" )
    public WebElement TermOfService;

    @FindBy(xpath = "//*[@class='text-center mb-5']" )
    public WebElement TermOfServiceIsDiplayed;

    @FindBy(xpath = "//div/a[@href='/account/weekly-order']")
    public WebElement FarmerMarketBtnAtButton;

    @FindBy(xpath = "//div/a[@href='/explore']")
    public WebElement ExploreBtnAtButton;

    @FindBy(xpath = "//div/a[@href='/about']")
    public WebElement AboutUsBtnAtButton;
   @FindBy(xpath = "//a[@class='d-block']")
    public WebElement AdressButton27;

    @FindBy(xpath = "//button[@class='section-9_gofunderButton__32gaj']")
    public WebElement GoWefunder;

    @FindBy(xpath = "//div/a[@href='/auth/login']")
    public WebElement LoginBtnAtButton;

    @FindBy(xpath = "//span[.='+1 (669) 696-5906']")
    public WebElement PhoneNumber;

    @FindBy(css = "[d='M0 6.658h4.448v13.676H0zM16.565 6.818c-.047-.015-.092-.031-.142-.045s-.119-.025-.18-.035a3.986 3.986 0 00-.8-.081 6.181 6.181 0 00-4.78 2.615V6.658H6.216v13.676h4.448v-7.459s3.362-4.682 4.78-1.243v8.7h4.447v-9.229a4.435 4.435 0 00-3.326-4.285z']")
    public WebElement LinkedInBtn;


    @FindBy(css = "[d='M6.194 6.813V4.336A1.239 1.239 0 017.432 3.1h1.239V0H6.194a3.716 3.716 0 00-3.716 3.716v3.1H0v3.1h2.477v9.91h3.716V9.91H8.67l1.239-3.1z']")
    public WebElement FacebookBtn;

    @FindBy(xpath = "//li/a[.='Privacy policy'][@href='/privacy-policy']")
    public WebElement PrivacyPolicyBtnAtBotton;



    //Test Urbanic Farm sitesine gider ve sayfa yüklenene kadar bekler.
    public void goesToTestUrbanicFarmHomePage(){
        driver.get("https://test.urbanicfarm.com/");
        ReusableMethods.waitForPageToLoad(5);
    }

    //HomePage sayfasındaysanız Facebook iconuna tıklamak için kullanabilirsiniz
    public void clickFaceebookIcon() {
        ReusableMethods.hover(FacebookBtn);
        FacebookBtn.click();
    }

    //HomePage sayfasındaysanız LinkedIn iconuna tıklamak için kullanabilirsiniz
    public void clickLinkedInIcon() {
        ReusableMethods.hover(LinkedInBtn);
        LinkedInBtn.click();
    }


    //Butona tıkladıktan sonra gelen sayfanın title ile doğrulanmasını (contains) sağlar, T yada F döner
    public boolean amIinRightPage(String title){
        ReusableMethods.switchToWindow(1);
        return driver.getTitle().contains(title);
    }

    //HomePage de iken sayfanın en altına gidersiniz action classlarla,
    // Böylece Thread.sleep kullanmanıza gerek kalmaz
    public void goesToDeepAtTheHomePage() {
        ReusableMethods.hover(LinkedInBtn);
    }



// US_036 sukru
    @FindBy(css="input[type='text']")
    private WebElement inputZipCode;

    @FindBy(xpath = "//button[contains(text(), 'go')]")
    private WebElement zipCodeButton;

    @FindBy (xpath = "//button[contains(text(), 'Register')]")
    private WebElement registerBtn;

    public void clickMainButton(String btnName){
        WebElement element = Driver.getDriver().findElement(By.xpath("//div/a[contains(text(), '" +
                btnName + "')]"));
        element.click();
    }



    //HomePage sayfasının en altına gidip Privacy_policy butonuna tıklar
    public void clickPrivacyPolicyBtn(){
        ReusableMethods.hover(PrivacyPolicyBtnAtBotton);
        PrivacyPolicyBtnAtBotton.click();
    }


}
