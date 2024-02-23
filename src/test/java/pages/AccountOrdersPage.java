package pages;


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

    @FindBy(xpath = "//div[@class='mr-3']//span")
    public List<WebElement> orderSummaryList;

    @FindBy(xpath = "//span/a")
    public WebElement sellerPageButton;

    @FindBy(xpath = "(//tbody//span)[1]")
    public WebElement sellerNameText;

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
    public WebElement proceedToCheckout;//alisverise tamamla
    @FindBy(xpath = "//button[@type='button']")
    public WebElement nextButton;
    @FindBy(xpath = "(//button[@class='proceed_btn__vZFGE'])[2]")
    public WebElement goToPayment;
    @FindBy(xpath = "//div[@class='col-lg-1 col-0']")
    public WebElement bosluk;
    @FindBy(xpath = "(//input[@class='FeaturedProductCard_number__16S1m'])[5]")
    public WebElement plus3; //siparis sayfasinda urun sayisini artirmak icin

    @FindBy(xpath = "//div[@class='d-flex flex-column']")
    public List<WebElement> quickOverviewContents;

    @FindBy(xpath = "//img[@class='rounded']")
    public List<WebElement> quickOverviewContentsPictures;

    @FindBy(xpath = "//span[.='Rate the product']")
    public List<WebElement> rateTheProductLinks;

    @FindBy(xpath = "//span[.='How would you rate this product ?']")
    public WebElement howWouldYouRateThisProductText;

    @FindBy(xpath = "//div[@class='bg-info p-1 rounded mb-3']")
    public WebElement ratingStars;

    @FindBy(xpath = "//textarea[@placeholder='Your Comments']")
    public WebElement commentArea;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;


    @FindBy(xpath = "(//div[@class='modal-content']//span)[1]")
    public WebElement closeTheRatingWindow;




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


}
