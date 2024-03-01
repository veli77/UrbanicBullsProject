package pages;


import enums.USERCREDENTIAL;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static stepDefinitions.Hooks.driver;

public class AccountOrdersPage extends CommonPage{

    static int orderNo;
    static String sellerName;
    static String sellerMapText;
    static String largerMapText;
    static String currentHandle;

    @FindBy(xpath = "//article[@class='row']//a")
    public List<WebElement> viewOrderDetailsButtons;

    @FindBy(linkText = "View order details")
    public WebElement viewOrderDetailsLink;

    @FindBy(xpath = "//div[@class='mr-3']//span")
    public List<WebElement> orderSummaryList;

    @FindBy(xpath = "//span/a")
    public WebElement sellerPageButton;

    @FindBy(xpath = "(//tbody//span)[1]")
    public WebElement sellerNameText;

    @FindBy(xpath = "(//tbody//span)[2]")
    public WebElement sellerEmailText;

    @FindBy(xpath = "//a[.='rate the seller']")
    public WebElement rateTheSellerLinkText;

    @FindBy(linkText = "Call seller")
    public WebElement callSellerLinkText;

    @FindBy(linkText = "Seller page")
    public WebElement sellerPageLinkText;

    @FindBy(xpath = "//span[.='Seller address']")
    public WebElement sellerAddressText;

    @FindBy(xpath = "//span[@class='h6']")
    public WebElement sellerFirstName;

    @FindBy(xpath = "//iframe[@class='d-block']")
    public WebElement iFrame;

    @FindBy(css = "div[class='google-maps-link'] a")
    public WebElement largerMapButton;

    @FindBy(xpath="//div[@class='place-name']")
    public WebElement sellerMapCoordinate;

    @FindBy(xpath = "//span[@class='a5H0ec']/following-sibling::text()")
    public WebElement largerMapCoordinate;

    @FindBy(css = "iframe[class*='bg-white rounded']")
    public WebElement sellerMapFrame;

    @FindBy(css = "h3[class='text-capitalize']")
    public WebElement ordersPageText;

    @FindBy(xpath = "(//div[@class='VfPpkd-dgl2Hf-ppHlrf-sM5MNb']//button)[1]")
    public WebElement googleMapRejectButton;

    @FindBy(xpath = "(//div[@class='d-flex flex-column']//span[@class='text-muted'])[3]")
    public WebElement unitTotalPreis;

    @FindBy(id = "searchboxinput")
    public WebElement searchBoxInput;
  
    @FindBy(xpath = "(//div[@class='d-flex justify-content-center align-items-center'])[2]")
    public WebElement card;//buyer sepet secenegi

    @FindBy(xpath = "//div[@class='BasketDropdown_container__15BpD']")
    public WebElement sepeteTikla;
  
    @FindBy(xpath = "(//button[@class='FeaturedProductCard_plus__3NnKq'])[1]")
    public WebElement plus; //siparis sayfasinda urun sayisini artirmak icin
    @FindBy(xpath = "(//button[@class='FeaturedProductCard_plus__3NnKq'])[3]")
    public WebElement plus2; //siparis sayfasinda urun sayisini artirmak icin
    @FindBy(xpath = "(//button[@class='col-12 mt-2 w-75 btn btn-success FeaturedProductCard_addCartBtn__2QCpK'])[1]")
    public WebElement addToCard;
    @FindBy(xpath = "//button[@class='btn btn-block font-weight-bold Basket_checkOutBtn__1946L']")
    public WebElement proceedToCheckout;//alisverisi tamamla
    @FindBy(xpath = "//button[@type='button']")
    public WebElement nextButton;
    @FindBy(xpath = "(//button[@class='proceed_btn__vZFGE'])[2]")
    public WebElement goToPayment;
    @FindBy(xpath = "//td[@class='py-3 align-middle text-end']")
    public WebElement xIsareti;
    @FindBy(xpath = "//button[@class='btn btn-primary mr-4']")
    public WebElement yes;//orders i silmeye emin misiniz
    @FindBy(xpath = "//input[@id='email']")
    public WebElement email_PAypal;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwrd_Paypal;
    @FindBy(xpath = "//button[@id='btnLogin']")
    public WebElement loginPaypal;
    @FindBy(xpath = "//button[@id='payment-submit-btn']")
    public WebElement payPalSubmitBtn;
    @FindBy(xpath = "//p[@class='mt-2 font-weight-bold']")
    public WebElement paymentSuccesfullyMetni;
    @FindBy(xpath = "//button[text()='Log In']")
    public WebElement loginPaypal1;
    @FindBy(xpath = "//button[@class='css-ltr-1d5lazx-button-Button']")
    public WebElement loginPaypal2;
    @FindBy(xpath = "//button[@class='css-ltr-19jfsh6 css-ltr-11pvgxh-button_base-text_button_lg-btn_full_width']")
    public WebElement accountPourPaypal;// hesap olustur paypal icin
    @FindBy(xpath = "(//span[@class='Notifications_notificationIconContainer__2jS5E'])[1]")
    public WebElement notification;
    @FindBy(xpath = "(//a[@class='Notifications_infoCommonText__1SAdH'])[1]")
    public WebElement orderMessage;
    @FindBy(xpath = "(//span[@class='font-weight-bold'])[1]")
    public WebElement orderDate;
    @FindBy(xpath = "//a[@class='mt-2']")
    public WebElement viewOrdersDetails;
    @FindBy(xpath = "//a[@class='Navbar_textLink__f6_Al ml-2 mr-4']")
    public WebElement logOut;
    @FindBy(xpath = "(//th[@class='py-3 align-middle'])[2]")
    public WebElement sepettekiUrun;
    @FindBy(xpath = "(//button[@class='FeaturedProductCard_minus__3-VQa'])[1]")
    public WebElement decrease;//siprais sayisini azaltma eksi isareti


    @FindBy(xpath = "//div[@class='d-flex flex-column']")
    public List<WebElement> quickOverviewContents;

    @FindBy(xpath = "//img[@class='rounded']")
    public List<WebElement> quickOverviewContentsPictures;

    @FindBy(xpath = "//span[.='Rate the product']")
    public List<WebElement> rateTheProductLinks;

    @FindBy(xpath = "//span[.='How would you rate this product ?']")
    public WebElement howWouldYouRateThisProductText;

    /**
     * rate the seller howWouldYouRateThisProductText
     */
    @FindBy(xpath = "//span[@class='text-center h4']")
    public WebElement rateTheSellerHowWouldYouRateThisProductText;

    @FindBy(xpath = "//div[@class='bg-info p-1 rounded mb-3']")
    public WebElement ratingStars;

    @FindBy(xpath = "//textarea[@placeholder='Your Comments']")
    public WebElement commentArea;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "(//div[@class='modal-content']//span)[1]")
    public WebElement closeTheRatingWindow;

    // Us 072 ProceedToCheckout Page
    @FindBy(css = "div.proceed_circle__3NRN8")
    public List<WebElement> circleBoxUnderTagsInProceedToCheckoutPage;
    @FindBy(css = "button.proceed_btn__vZFGE")
    public List<WebElement> buttonsPrevNextInProceedToCheckoutPage;
    @FindBy(css = "span.h6.text-white")
    public WebElement rateOurServiceButton;
    @FindBy(xpath = "(//div[@class='Notifications_notificationNumContainer__myxVE']/span)[1]")
    public WebElement notificationQuantity;
    @FindBy(id = "payment-submit-btn")
    public WebElement completePurchaseButton;
    @FindBy(id = "backToInputEmailLink")
    public WebElement changePayPalAccountButton;







public void verifyOrdersPage(){
    //String currentUrl=driver.getCurrentUrl();
    //System.out.println(currentUrl);
    //Assert.assertTrue(currentUrl.toLowerCase().contains("orders"));

    Assert.assertTrue(ordersPageText.getText().toLowerCase().contains("orders"));

}

public void selectOrder(){
    int ordersListSize=viewOrderDetailsButtons.size();
    Random random =new Random();
    orderNo= random.nextInt(ordersListSize);

}

public void verifyViewdetailsButton(){

    Assert.assertTrue(viewOrderDetailsButtons.get(orderNo).isEnabled());
}

public void clickViewDetailsButton(){
    viewOrderDetailsButtons.get(orderNo).click();
}

public void verifyOrderDetailsPage(){
    String currentUrl=driver.getCurrentUrl();
    Assert.assertTrue(currentUrl.contains("order-details"));

}

public void verifyOrderSummary(){

    List<String> expectedSummary=List.of("Items total","Shipping total","Applied promotion","Grand total");
    expectedSummary.stream().forEach(t->Assert.assertTrue(verifySummaryText(t)));
}

public boolean verifySummaryText(String text){
    return orderSummaryList.stream()
            .map(WebElement::getText)
            .anyMatch(t->t.contains(text));
}

public void clickSellerPageButtonAndVerifySellerPage(){

    ReusableMethods.waitForPageToLoad(5);
    ReusableMethods.hover(sellerNameText);
    sellerName=sellerNameText.getAttribute("textContent");
    ReusableMethods.waitForPageToLoad(5);
    ReusableMethods.hover(sellerPageButton);
    sellerPageButton.click();
    ReusableMethods.waitForPageToLoad(5);
    String currentUrl= driver.getCurrentUrl();
    Assert.assertTrue(sellerName.contains(sellerFirstName.getText()));
   // ReusableMethods.hover(sellerMapCoordinate);
   // sellerMapText=sellerMapCoordinate.getText();
   // System.out.println(sellerMapText);

}

public void verifyAddressMap(){
   // ReusableMethods.hover(iFrame);
    ReusableMethods.waitForPageToLoad(5);
    ReusableMethods.hover(unitTotalPreis);
    driver.switchTo().frame(iFrame);
    Assert.assertTrue(largerMapButton.isEnabled());
}


public void clickMapButton(){
    JSUtils.scrollIntoViewJS(largerMapButton);
    JSUtils.clickElementByJS(largerMapButton);
    ReusableMethods.waitForPageToLoad(5);

    Set<String> windowsList=driver.getWindowHandles();
    for (String window : windowsList){
        driver.switchTo().window(window);
    }

    ReusableMethods.waitForPageToLoad(5);
    ReusableMethods.hover(googleMapRejectButton);
    JSUtils.clickElementByJS(googleMapRejectButton);

}

public void getSellerMapCoordinate(){
    ReusableMethods.waitForPageToLoad(5);
    largerMapText=searchBoxInput.getAttribute("value");



    }
public void getNewWindow(){

 currentHandle=driver.getWindowHandle();
    Set<String> handles= driver.getWindowHandles();
    for (String handle : handles){
        if (handle.equals(currentHandle)){
            driver.switchTo().window(handle);
            break;
        }
    }


}

public void verifyCoordinate(){
  //  Assert.assertEquals(sellerMapText,largerMapText);
    String currentURL=driver.getCurrentUrl();

    Assert.assertTrue(currentURL.toLowerCase().contains("maps"));

}

public void enterPayPalAccount(){
    ReusableMethods.sendText(email_PAypal, USERCREDENTIAL.PAYPALACCOUNT.getUsername());
    ReusableMethods.sendText(passwrd_Paypal, USERCREDENTIAL.PAYPALACCOUNT.getPassword());

}


}
