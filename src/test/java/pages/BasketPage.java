package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class BasketPage extends CommonPage{
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
    @FindBy(css = "div[role='alert']")
    public WebElement afterPaymentCheckoutAlert;
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

}
