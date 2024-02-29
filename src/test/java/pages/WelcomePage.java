package pages;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.JSUtils;
import utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static stepDefinitions.Hooks.driver;

public class WelcomePage extends CommonPage {

    int randomIndex;
    String targetText;

    @FindBy(css = "[class='Navbar_textLink__f6_Al cursor-pointer']")
    public WebElement WelcomePage;

    @FindBy(xpath = "//*[@id=\"Urban\\u0131cFarm\"][1]")
    public WebElement Logo;

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

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement SearchButton;

    @FindBy(xpath = "//input[@id='mapSearchBox']")
    public WebElement SearchByProductName;

    @FindBy(css = "[id='mapSearchBoxProducts'] option")
    public List<WebElement> ProductNameList;

    @FindBy(css = ".col-11 [class*=\"ProductCard_productTitle\"]")
    public List<WebElement> ResultsProductList;

    @FindBy(xpath = "//*[text()='There are no hubs in this view.']")
    public WebElement NoHubsAlert;

    @FindBy(css = "div.text-center h3")
    public WebElement NoProductMessage;

    @FindBy(css = ".col-11 [class*=\"ProductCard_productTitle\"]")
    public WebElement ResultsList;

    @FindBy(xpath = "//div[@class='py-1 d-flex flex-column']//span[@class='ProductCard_distanceSpan__M5brr']")
    public List<WebElement> ResultsDistance;

    @FindBy(css = "#location option")
    public List<WebElement> SearchByDistanceOptions;

    @FindBy(css = "#allCategories option")
    public List<WebElement> SearchByCategoriesOptions;

    @FindBy(css = "#allCategories")
    public WebElement SearchByCategories;

    @FindBy(css = ".mt-1.mb-1.ProductCard_hub__33MeH")
    public List<WebElement> ResultCategoriesList;

    @FindBy(css = ".SearchBarOptions_switch__7G2lt span")
    public WebElement SearchForOnlyOrganicProducts;

    @FindBy(xpath = "//span[text()='Organic']")
    public WebElement OrganicProductMarker;

    @FindBy(css = ".ProductCard_productTitle__3K4rg")
    public WebElement ProductListLastTest;

    @FindBy(xpath = "//span[@aria-hidden='true']")
    public WebElement WelcomeToUrbanicFarmCloseBtn;

    @FindBy(css = ".col-11.col-sm-8.text-center")
    public WebElement WelcomeToUrbanicFarm;

    @FindBy(xpath = "//button[@class='btn p-0 SearchBarOptions_sliderButton__1oak8']")
    public WebElement FilterButton;

    @FindBy(css = "#priceFilter")
    public WebElement PriceFilter;

    @FindBy(xpath = "//input[@name='deliveryFilter']")
    public List<WebElement> DeliveryTypeFilter;

    @FindBy(xpath = "//input[@id='BUYER_PICKUP_FROM_BRANCH']")
    public WebElement DeliveryTypeBuyerPickupOnTheVine;

    @FindBy(xpath = "//input[@id='BUYER_PICKUP']")
    public WebElement DeliveryTypeBuyerPickup;

    @FindBy(xpath = "//input[@id='SELLER_DELIVERY']")
    public WebElement DeliveryTypeSellerDelivery;

    @FindBy(xpath = "//input[@id='SELLER_FLEXIBLE']")
    public WebElement DeliveryTypeSellerFlexible;

    @FindBy(xpath = "//input[@name='unitTypeFilter']")
    public List<WebElement> UnitTypeFilter;

    @FindBy(xpath = "//option[@value='Expensive']")
    public WebElement SortByExpensive;

    @FindBy(xpath = "//p[@class='m-0 text-white']")
    public List<WebElement> ResultsByPriceMarker;

    @FindBy(xpath = "//span[@class='ProductCard_distanceSpan__M5brr']")
    public List<WebElement> ResultsByDistanceMarker;

    @FindBy(xpath = "//p[@class='ProductCard_userName__MaY5h']")
    public List<WebElement> ResultsNameList;

    @FindBy(xpath = "//span[text()='Seller flexible delivery']")
    public WebElement ResultsByDeliveryTypeFlexibleDelivery;

    @FindBy(xpath = "//span[contains(text(), 'Buyer picks up  (')]")
    public WebElement ResultsByDeliveryTypeBuyersPickUp;

    @FindBy(xpath = "//span[contains(text(), 'Buyer picks up on the vine')]")
    public WebElement ResultsByDeliveryTypeBuyersPickUpOnTheVine;

    @FindBy(xpath = "//span[contains(text(), 'Seller delivers the products')]")
    public WebElement ResultsByDeliveryTypeSellerDelivers;

    @FindBy(xpath = "//*[text()='There is no local grower in this view.']")
    public WebElement NoResults;
    @FindBy(css = "select[id='sellerRate']")
    public WebElement sellerRateDropdown;
    @FindBy(css = "select[id='productRate']")
    public WebElement productRateDropdown;
    @FindBy(css ="[href='/account/events-i-organize']")
    public WebElement MyEventsBtnAtSideBar;


    //Sağ barda bulunan My Events butonuna click yapar.
    public void clickMyEvents() {
        ReusableMethods.clickWithTimeOut(getWelcomePage().MyEventsBtnAtSideBar,10);
    }

    public void SellerRatingClickableCheck() {
        ReusableMethods.waitForClickablility(sellerRateDropdown,5);
        Assert.assertTrue(sellerRateDropdown.isDisplayed() && sellerRateDropdown.isEnabled());
    }
    public void SellerRatingSelectAnOption() {
        Select select = new Select(sellerRateDropdown);
        select.selectByIndex(2);
        ReusableMethods.waitFor(1);
        Assert.assertEquals("3", select.getFirstSelectedOption().getText());
    }
    public void ProductRatingClickableCheck() {
        ReusableMethods.waitForClickablility(productRateDropdown,5);
        Assert.assertTrue(productRateDropdown.isDisplayed() && productRateDropdown.isEnabled());
    }
    public void ProductRatingSelectAnOption() {
        Select select = new Select(productRateDropdown);
        select.selectByVisibleText("2");
        ReusableMethods.waitFor(1);
        Assert.assertEquals("2", select.getFirstSelectedOption().getText());
    }
    public void ClickWelcomePage() {
        ReusableMethods.waitForPageToLoad(10);
        ReusableMethods.waitForClickablility(WelcomePage,10);
        WelcomePage.click();

        //Welcome to the UrbanicFarm pop-up inin engellenmesi icin
        ReusableMethods.waitFor(3);
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        localStorage.setItem("welcome-modal-shown", "false");
    }
    public void ProductListAppears() {
        Assert.assertFalse(ProductsList.isEmpty());
        ProductsList.getFirst().isDisplayed();
    }
    public void ListOfSellersAppears() {
        Assert.assertFalse(SellersList.isEmpty());
        SellersList.getFirst().isDisplayed();
    }
    public void RandomSellerIsSelected() {
        // Rasgele bir indeks oluştur
        Random rand = new Random();
        randomIndex = rand.nextInt(SellersList.size());
        System.out.println(randomIndex);
        targetText = ProductsList.get(randomIndex).getText();
        System.out.println(targetText);
    }
    public void QuantityIconsFunctional() {
        JSUtils.clickElementByJS(IncreaseQuantityOfTheProductButton.get(randomIndex));
        JSUtils.clickElementByJS(IncreaseQuantityOfTheProductButton.get(randomIndex));
        JSUtils.clickElementByJS(IncreaseQuantityOfTheProductButton.get(randomIndex));
        JSUtils.clickElementByJS(DecreaseQuantityOfTheProductButton.get(randomIndex));
    }
    public void AddToCartButtonFunctional() {
        AddToCartButton.get(randomIndex).isEnabled();
    }
    public void RandomProductIsClicked() {
        // Rasgele seçilen indeksteki öğeyi tıkla
        AddToCartButton.get(randomIndex).click();
    }
    public void ProductAddedAlert() {
        AddedToYourBasketAlert.isDisplayed();
    }
    public boolean isProductAddedToTheBasket() {
        BasketIcon.click();
        return ProductsNamesInTheBasketList.stream()
                .map(WebElement::getText)
                .anyMatch(text -> text.contains(targetText));
    }
    public void VerifyProductIsInTHeList() {
        Assert.assertTrue(isProductAddedToTheBasket());
    }
    public void RemoveProductsFromTheBasket() {
        getWelcomePage().RemoveProductFromBasketButton.click();
        getWelcomePage().YesToRemoveProductFromBasketButton.click();
    }
    public void searchAndVerifyProductInResults() {
        // Selecting a random product from the search list
        int randomIndex = new Random().nextInt(ProductNameList.size());
        String targetProductName = ProductNameList.get(randomIndex).getAttribute("value");
        System.out.println("Selected product: " + targetProductName);

        // Search for the product
        SearchByProductName.sendKeys(targetProductName);
        SearchButton.click();
        ReusableMethods.waitFor(3);
        // Assert.assertTrue(NoHubsAlert.isDisplayed());

        //  Testing if the selected product is among the result list
        try {
            boolean isProductFound = ResultsProductList.stream()
                    .map(WebElement::getText)
                    .anyMatch(text -> text.contains(targetProductName));
            Assert.assertTrue(isProductFound);
        } catch (AssertionError e) {
            Assert.assertTrue(NoProductMessage.isDisplayed());
            System.out.println("No product found alert: " + NoProductMessage.getText());
        }
        SearchByProductName.clear();
    }
    public void selectProductByDistance(DataTable dataTable) {
        List<String> distances = dataTable.column(0);

        for (String distance : distances) {
            WebElement selectedOption = SearchByDistanceOptions.stream()
                    .filter(option -> option.getText().equals(distance)).findAny().get();
            selectedOption.click();
            SearchButton.click();
        }
    }
    public void SelectDistanceOptions() {
        for (int i = 0; i < SearchByDistanceOptions.size(); i++) {
            SearchByDistanceOptions.get(i).click();
            System.out.println(SearchByDistanceOptions.get(i).getText());
            SearchButton.click();
        }
    }
    public void searchProductByDistance(DataTable dataTable) {
        List<String> distances = dataTable.column(1);
        List<Integer> integerList = new ArrayList<>();

        for (String str : distances) {
            integerList.add(Integer.parseInt(str));
        }

        for (int i = 0; i < SearchByDistanceOptions.size(); i++) {
            SearchByDistanceOptions.get(i).click();
            ReusableMethods.waitFor(3);
            getWelcomePage().SearchButton.click();

            List<String> DistanceList = new ArrayList<>();
            for (int x = 0; x < ResultsDistance.size(); x++) {
                try {
                    DistanceList.add(ResultsDistance.get(x).getText());
                } catch (Exception e) {
                    // Hata durumunda DistanceList'e 0 ekle
                    DistanceList.add("0");
                }
            }
            // Her bir sonuç metni için
            for (String result : DistanceList) {
                // Sadece rakamları içeren bir liste oluştur
                List<String> mesafeler = ReusableMethods.extractNumbers(result);
                // Her bir rakam için
                for (String distance : mesafeler) {
                    // 100'den küçük mü diye kontrol et
                    int num = Integer.parseInt(distance);
                    Assert.assertTrue(num < integerList.get(i));
                }
            }

            }
        }
    }
    public void searchAndVerifyProductByCategories() {
        // Selecting a random product from the search list
        int randomIndex = new Random().nextInt(SearchByCategoriesOptions.size());
        String targetCategoriesName = SearchByCategoriesOptions.get(randomIndex).getText();
        String[] parts = SearchByCategoriesOptions.get(randomIndex).getText().split("\\s+");
        String ComparisonCategory = parts[0]; // ilk kelimeyi almak için
        System.out.println("Selected category: " + targetCategoriesName);
        System.out.println(ComparisonCategory);

        // Search for the product
        SearchByCategories.click();
        SearchByCategories.sendKeys(targetCategoriesName);
        SearchButton.click();
        // Assert.assertTrue(NoHubsAlert.isDisplayed());

        //  Testing if the selected product is among the result list
        if (targetCategoriesName.equals("Any")) {
            Assert.assertTrue(ResultCategoriesList.getFirst().isDisplayed());
        } else
            try {
                boolean isProductFound = ResultCategoriesList.stream()
                        .map(WebElement::getText)
                        .anyMatch(text -> text.contains(ComparisonCategory));
                Assert.assertTrue(isProductFound);
            } catch (AssertionError e) {
                JSUtils.scrollIntoViewJS(NoProductMessage);
                Assert.assertTrue(NoProductMessage.isDisplayed());
                System.out.println("No product found alert: " + NoProductMessage.getText());
            }
        SearchByCategories.click();
        SearchByCategories.sendKeys("Any");
        SearchButton.click();
    }

    public void searchAndVerifyProductByCategories2() {
        for (int i = 0; i < SearchByCategoriesOptions.size(); i++) {
            SearchByCategoriesOptions.get(i).click();
            String ComparisonCategory = SearchByCategoriesOptions.get(i).getText().split("\\s+")[0];
            SearchButton.click();
            ReusableMethods.waitFor(2);

            if (ComparisonCategory.equals("Any")) {
                try {
                    Assert.assertTrue(ResultCategoriesList.getFirst().isDisplayed());
                } catch (AssertionError e) {
                    JSUtils.scrollIntoViewJS(NoProductMessage);
                    Assert.assertTrue(NoProductMessage.isDisplayed());
                }
            } else {
                try {
                    boolean isProductFound = ResultCategoriesList.stream()
                            .map(WebElement::getText)
                            .anyMatch(text -> text.contains(ComparisonCategory));
                    Assert.assertTrue(isProductFound);
                } catch (AssertionError e) {
                    JSUtils.scrollIntoViewJS(NoProductMessage);
                    Assert.assertTrue(NoProductMessage.isDisplayed());
                }
            }
        }
        SearchByCategories.click();
        SearchByCategories.sendKeys("Any");
        SearchButton.click();
    }

    public void SearchForOnlyOrganicProducts() {
        JSUtils.clickElementByJS(SearchForOnlyOrganicProducts);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(OrganicProductMarker.isDisplayed());
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(SearchForOnlyOrganicProducts);
    }

    public void FilterSearchByRandomPriceLevel() {
        SortByExpensive.click();
        ReusableMethods.waitFor(5);
        JSUtils.clickElementByJS(FilterButton);
        // Random bir price level belirle
        Random randomPriceLimit = new Random();
        int randomPriceLimit2 = randomPriceLimit.nextInt(150);
        System.out.println("Random Price Limit = " + randomPriceLimit2);
        ReusableMethods.waitFor(5);
        //JS ile random degeri filtreye ata
        JSUtils.setRangeInputValue(PriceFilter, randomPriceLimit2);
        ReusableMethods.waitFor(5);
        SearchButton.click();
        ReusableMethods.waitFor(5);
        //Cikan sonuc ile price levelini karsilastir
        double HighestPriceValue = Double.parseDouble(ResultsByPriceMarker.getFirst().getText()
                .replace("$", ""));
        System.out.println("Highest Price Level = " + HighestPriceValue);
        Assert.assertTrue(HighestPriceValue <= randomPriceLimit2);
    }
    public void FilterByPriceLevel(List<Integer> prices) {
        SortByExpensive.click();
        ReusableMethods.waitFor(5);
        JSUtils.clickElementByJS(FilterButton);

        for (Integer price : prices) {
            JSUtils.setRangeInputValue(PriceFilter, price);
            ReusableMethods.waitFor(5);

            SearchButton.click();
            ReusableMethods.waitFor(5);

            if (price == 0) {
                JSUtils.scrollIntoViewJS(NoProductMessage);
                Assert.assertTrue(NoProductMessage.isDisplayed());
            } else {
                // Assert highest price value
                double highestPriceValue = Double.parseDouble(ResultsByPriceMarker.getFirst()
                        .getText().replace("$", ""));
                Assert.assertTrue(highestPriceValue <= price);
            }
        }
    }
    public void SearchByDeliveryType(){
        performSearchAndAssertResults(DeliveryTypeBuyerPickupOnTheVine, ResultsByDeliveryTypeBuyersPickUpOnTheVine);
        performSearchAndAssertResults(DeliveryTypeBuyerPickup, ResultsByDeliveryTypeBuyersPickUp);
        performSearchAndAssertResults(DeliveryTypeSellerDelivery, ResultsByDeliveryTypeSellerDelivers);
        performSearchAndAssertResults(DeliveryTypeSellerFlexible, ResultsByDeliveryTypeFlexibleDelivery);
    }
    public void performSearchAndAssertResults(WebElement deliveryType, WebElement resultsElement) {
        ReusableMethods.waitFor(5);
        JSUtils.clickElementByJS(FilterButton);
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(deliveryType);
        ReusableMethods.waitFor(3);
        SearchButton.click();

        try {
            ReusableMethods.waitFor(5);
            Assert.assertTrue(resultsElement.isDisplayed());
        } catch (NoSuchElementException e)
        {
            System.out.println("Listede ürün yok.");
        }

        JSUtils.clickElementByJS(FilterButton);
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(deliveryType);
        ReusableMethods.waitFor(3);
        SearchButton.click();
    }

    public void SearchByUnitTypeRandomWay() {
        ReusableMethods.waitFor(5);
        JSUtils.clickElementByJS(FilterButton);
        ReusableMethods.waitFor(3);

        // Selecting a random unit type from the list
        int randomIndex = new Random().nextInt(UnitTypeFilter.size());
        UnitTypeFilter.get(randomIndex).click();
        SearchButton.click();

        try {
            ReusableMethods.waitFor(5);
            Assert.assertTrue(ProductListLastTest.isDisplayed());
        } catch (NoSuchElementException e) {
            System.out.println("Listede ürün yok.");
        }
        ReusableMethods.waitFor(5);
        JSUtils.clickElementByJS(FilterButton);
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(UnitTypeFilter.get(randomIndex));
        ReusableMethods.waitFor(3);
        SearchButton.click();
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(FilterButton);

    }

    public void SearchByUnitType() {

        ReusableMethods.waitFor(5);
        JSUtils.clickElementByJS(FilterButton);
        ReusableMethods.waitFor(3);

        for (int i = 0; i < UnitTypeFilter.size(); i++) {
            UnitTypeFilter.get(i).click();
            SearchButton.click();

            try {
                ReusableMethods.waitFor(5);
                Assert.assertTrue(ProductListLastTest.isDisplayed());
            } catch (NoSuchElementException e) {
                System.out.println("Listede ürün yok.");
            }
            ReusableMethods.waitFor(5);
            JSUtils.clickElementByJS(FilterButton);
            ReusableMethods.waitFor(3);
            JSUtils.clickElementByJS(UnitTypeFilter.get(i));
            ReusableMethods.waitFor(3);
            SearchButton.click();
            ReusableMethods.waitFor(3);
            JSUtils.clickElementByJS(FilterButton);
        }
    }
}





