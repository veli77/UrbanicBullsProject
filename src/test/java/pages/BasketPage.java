package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends CommonPage{
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
