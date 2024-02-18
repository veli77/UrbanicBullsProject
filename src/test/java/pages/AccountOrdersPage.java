package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountOrdersPage extends CommonPage{
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
    public WebElement proceedToCheckout;//alisverise tamamla
    @FindBy(xpath = "//button[@type='button']")
    public WebElement nextButton;
    @FindBy(xpath = "(//button[@class='proceed_btn__vZFGE'])[2]")
    public WebElement goToPayment;





}
