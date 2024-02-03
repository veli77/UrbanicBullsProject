package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;

import java.util.List;

import static stepDefinitions.Hooks.driver;

public class HomePage extends CommonPage {

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

    @FindBy(xpath = "//span[.='+1 (669) 696-5906']")
    public WebElement PhoneNumber;

    @FindBy(css = "[d='M0 6.658h4.448v13.676H0zM16.565 6.818c-.047-.015-.092-.031-.142-.045s-.119-.025-.18-.035a3.986 3.986 0 00-.8-.081 6.181 6.181 0 00-4.78 2.615V6.658H6.216v13.676h4.448v-7.459s3.362-4.682 4.78-1.243v8.7h4.447v-9.229a4.435 4.435 0 00-3.326-4.285z']")
    public WebElement LinkedInBtn;


    @FindBy(css = "[d='M6.194 6.813V4.336A1.239 1.239 0 017.432 3.1h1.239V0H6.194a3.716 3.716 0 00-3.716 3.716v3.1H0v3.1h2.477v9.91h3.716V9.91H8.67l1.239-3.1z']")
    public WebElement FacebookBtn;




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

}
