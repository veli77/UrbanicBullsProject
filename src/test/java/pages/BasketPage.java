package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class BasketPage extends CommonPage {

    // Us 072 ProceedToCheckout Page
    @FindBy(css = "div.proceed_circle__3NRN8")
    public List<WebElement> circleBoxUnderTagsInProceedToCheckoutPage;
    @FindBy(css = "button[class='proceed_btn__vZFGE']")
    public List<WebElement> buttonsPrevNextInProceedToCheckoutPage;
    @FindBy(css = "button[type='button']")
    public WebElement buttonNext;
    @FindBy(css = "button[class*='Toastify__close-button'] svg")
    public WebElement alertCloseIcon;
    @FindBy(css = "span.h6.text-white")
    public WebElement rateOurServiceButton;
    @FindBy(xpath = "(//div[@class='Notifications_notificationNumContainer__myxVE']/span)[1]")
    public WebElement notificationQuantity;
    @FindBy(className = "Navbar_cartText__1jkrK")
    public WebElement goToCartQuantity;
    @FindBy(id = "payment-submit-btn")
    public WebElement completePurchaseButton;
    @FindBy(id = "backToInputEmailLink")
    public WebElement changePayPalAccountButton;
    @FindBy(css = "div[role='alert']")
    public WebElement afterPaymentCheckoutAlert;
    @FindBy(css = "p.mt-2.font-weight-bold")
    public WebElement paymentSuccessfulMessage;
    @FindBy(className = "text-center h3")
    public WebElement rateFrameText;
    @FindBy(className = "close btn")
    public WebElement rateFrameCloseButton;
    @FindBy(className = "list-group-item list-group-item-action")
    public List<WebElement> orderStatus;
    @FindBy(css = "div[class*='active']")
    public List<WebElement> activeOrderStatus;
    @FindBy(xpath = "//div[contains(@class,'proceed_selected__1G-h5')]/p")
    public WebElement selectedPageInProceedToCheckoutPage;
    @FindBy(xpath = "//button[@class='collapsible_toggle__1oudq']")
    public WebElement enterPromocode;
    @FindBy(xpath = "//input[@type='text']")
    public WebElement promocodeGonder;
    @FindBy(xpath = "//button[@class='applyPromoCode_btn__2dNcS btn']")
    public WebElement applyButton;
    @FindBy(xpath = "//td[@class='text-end py-3'])[3]")
    public WebElement totalAmount;
    @FindBy(xpath = "//div[@class='Toastify__toast-body toastr_custom-toastr__iiU37']")
    public WebElement invalidPromocodeMessage;
    @FindBy(xpath = "...................................")
    public WebElement indirimliTotalHesap;
    @FindBy(xpath = "(//td[@class='text-end py-3'])[1]")
    public WebElement subTotal;
    @FindBy(xpath = "(//button[@class='btn btn-primary mr-4'])[1]")
    public WebElement yesButtonorderSilmekIcin;
    @FindBy(xpath = "(//p[@class='FeaturedProductCard_productTitle__2rzUT'])[19]")
    public WebElement redWorm;//5 e luk urun, promocode ile esitlemek icin, equals hatasi almak icin
    @FindBy(xpath = "(//button[@class='FeaturedProductCard_plus__3NnKq'])[19]")
    public WebElement redWormPlus;


}

