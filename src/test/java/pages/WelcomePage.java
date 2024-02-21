package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JSUtils;

import java.util.List;
import java.util.Random;

public class WelcomePage extends CommonPage{

    int randomIndex;
    String targetText;

    @FindBy(css = "[class='Navbar_textLink__f6_Al cursor-pointer']")
    public WebElement WelcomePage;

    @FindBy(css = "[class*='p-1'] p")
    public List<WebElement> ProductsList;

    @FindBy(css = "[class*='ProductCard_userName']")
    public List<WebElement> SellersList;

    @FindBy(css = "[class*='p-1'] [class*='ProductCard_plus']")
    public List<WebElement> IncreaseQuantityOfTheProductButton;

    @FindBy(css = "[class*='p-1'] [class*='ProductCard_minus']")
    public List<WebElement> DecreaseQuantityOfTheProductButton;

    @FindBy(css = "[class*='col-12 mt-2']")
    public List<WebElement> AddToCartButton;

    @FindBy(css = "div[role='alert']")
    public WebElement AddedToYourBasketAlert;

    @FindBy(css = "[class*='Basket']")
    public WebElement BasketIcon;

    @FindBy(css = "[class*='py-3 align-middle']")
    public List<WebElement> ProductsNamesInTheBasketList;

    @FindBy(css = "[class*='text-end'] svg")
    public WebElement RemoveProductFromBasketButton;
    //  //*[@style='cursor: pointer;']

    @FindBy(css = "[class='btn btn-primary mr-4']")
    public WebElement YesToRemoveProductFromBasketButton;


public void ClickWelcomePage(){
    WelcomePage.click();
}
public void ProductListAppears(){
    Assert.assertFalse(ProductsList.isEmpty());
    ProductsList.getFirst().isDisplayed();
}
public void ListOfSellersAppears(){
    Assert.assertFalse(SellersList.isEmpty());
    SellersList.getFirst().isDisplayed();
}
public void RandomSellerIsSelected(){
    // Rasgele bir indeks oluştur
    Random rand = new Random();
    randomIndex = rand.nextInt(SellersList.size());
    System.out.println(randomIndex);
    targetText = ProductsList.get(randomIndex).getText();
    System.out.println(targetText);
}
public void QuantityIconsFunctional(){
    JSUtils.clickElementByJS(IncreaseQuantityOfTheProductButton.get(randomIndex));
    JSUtils.clickElementByJS(IncreaseQuantityOfTheProductButton.get(randomIndex));
    JSUtils.clickElementByJS(IncreaseQuantityOfTheProductButton.get(randomIndex));
    JSUtils.clickElementByJS(DecreaseQuantityOfTheProductButton.get(randomIndex));
}
public void AddToCartButtonFunctional(){
    AddToCartButton.get(randomIndex).isEnabled();
    }
public void RandomProductIsClicked(){
    // Rasgele seçilen indeksteki öğeyi tıkla
    AddToCartButton.get(randomIndex).click();
}
public void ProductAddedAlert(){
    AddedToYourBasketAlert.isDisplayed();
}
public boolean isProductAddedToTheBasket() {
    BasketIcon.click();
        return ProductsNamesInTheBasketList.stream()
                .map(WebElement::getText)
                .anyMatch(text -> text.contains(targetText));
    }
public void VerifyProductIsInTHeList(){
        Assert.assertTrue(isProductAddedToTheBasket());
    }
public void RemoveProductsFromTheBasket(){
    getWelcomePage().RemoveProductFromBasketButton.click();
    getWelcomePage().YesToRemoveProductFromBasketButton.click();
    }
}