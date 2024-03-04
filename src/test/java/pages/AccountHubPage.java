package pages;

import enums.URL_LINKS;
import enums.USERCREDENTIAL;
import org.apache.poi.ss.formula.atp.Switch;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.List;
import java.util.stream.Collectors;

import static stepDefinitions.Hooks.driver;

public class AccountHubPage extends CommonPage{

    @FindBy(xpath = "//a[contains(text(),'Your products/services')]")
    public WebElement yourProductService_navbar;

    @FindBy(xpath = "//div[@class='row m-0 p-2 align-items-center']/span")
    public List<WebElement> allhubs;

    @FindBy(xpath = "//a[contains(@class,'HubManagement_productTitle__2ke7R')]")
    public List<WebElement> allAddedProducts;

    @FindBy(xpath = "//datalist[@id='productName']/option")
    public List<WebElement> allProductsNames;

    @FindBy(xpath = "//span[contains(@class,'HubManagement_badge__2jPOb')]")
    public List<WebElement> allProductsStatus;

    @FindBy(css = "[class*='font-weight']")
    public List<WebElement> eklenmisUrunlerinIsimleri;

    @FindBy(xpath = "//input[@id='selectProductName']")
    public WebElement addNewProduct_Name;

    @FindBy(xpath = "//input[@id='hubManagePrice']")
    public WebElement addNewProduct_Price;

    @FindBy(xpath = "//input[@id='hubManageStock']")
    public WebElement addNewProduct_Stock;

    @FindBy(xpath = "//select[@id='selectProductUnit']")
    public WebElement addNewProduct_Unit;

    @FindBy(xpath = "//button[@id='hubManageSaveButton']")
    public WebElement addNewProduct_Submit;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    public WebElement update;

    @FindBy(xpath = "//a[@class='btn btn-danger']")
    public WebElement delete;

    @FindBy(xpath = "(//span[@class='UpdateProduct_slider__2ZAUg UpdateProduct_round__14rjT'])[1]")
    public WebElement organic;

    @FindBy(xpath = "(//span[@class='UpdateProduct_slider__2ZAUg UpdateProduct_round__14rjT'])[2]")
    public WebElement trade;

    @FindBy(xpath = "//input[@name='tradeDescription']")
    public WebElement tradeDescription;

    @FindBy(xpath = "//input[@name='price']")
    public WebElement price;

    @FindBy(xpath = "//select")
    public WebElement unitType;

    @FindBy(css = "div[class='Toastify__toast-body toastr_custom-toastr__iiU37']")
    public WebElement updatedAlert;

    @FindBy(xpath = "(//div[@class='text-center mb-2']/a)[1]")
    public WebElement yes;

    @FindBy(xpath = "(//div[@class='text-center mb-2']/a)[2]")
    public WebElement no;

    @FindBy(xpath = "//div[contains(text(),'has been successfully deleted')] ")
    public WebElement deleteAlert;
    @FindBy(xpath = "//h3")
    public WebElement lastApprovedProduct;
    @FindBy(css = ".font-weight-bold:first-child")
    public List<WebElement> productName;
    @FindBy(xpath = "//span[@class='text-muted d-block']")
    public List<WebElement> productPrice;
    @FindBy(xpath = "//span[@class='text-muted']")
    public List<WebElement> productStock;
    @FindBy(css = ".HubManagement_badge__2jPOb.text-success")
    public List<WebElement> productStatus;
    @FindBy(xpath = "//input[@name='stock']")
    public WebElement productStockInfo;
    @FindBy(xpath = "//input[@name='isTrade']")
    public WebElement isTrade;
    public void VerifyYourProducts_ServicesPageUrl() throws InterruptedException {
        Thread.sleep(3000);
        String expectedUrl = "https://test.urbanicfarm.com/account/hub";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actual="+actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    public void goToPreviousPage()  {
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        //https://test.urbanicfarm.com/account/weekly-order   dönmeli
        ReusableMethods.waitForPageToLoad(5);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().back();
    }

    public void goToAddressPage(){


        ReusableMethods.hover(getAccountHomePage().accountPageLeftsidesTabs.get(1));
        JSUtils.clickElementByJS(getAccountHomePage().accountPageLeftsidesTabs.get(1));



    //    for (WebElement element : getAccountHomePage().accountPageLeftsidesTabs){
//
    //        if (element.getText().contains("Address")){
    //            ReusableMethods.hover(element);
    //            element.click();
    //        }
    //    }
    }

    public By getByPanelButton(String btnName){
        return By.xpath("//div/a[.='" + btnName + "']");
    }

    public void verifyLeftPanelButton(String btn){
        WebElement element=driver.findElement(getByPanelButton(btn));
        Assert.assertTrue(element.isEnabled());

    }

    public void clickAButtonInLeftPanel(String btnName){
        WebElement element= driver.findElement(getByPanelButton(btnName));
        ReusableMethods.hover(element);
       // element= driver.findElement(getByPanelButton(btnName));
       // JSUtils.scrollIntoViewJS(element);
        JSUtils.clickElementByJS(element);
    }

    public void assertProductNamePriceStockUnit() {
        Assert.assertTrue(getAccountHubPage().addNewProduct_Price.isDisplayed());
        Assert.assertTrue(getAccountHubPage().addNewProduct_Name.isDisplayed());
    }

    public String eklenebilecekUrun() {
        List<String> allProducts = allProductsNames
                .stream()
                .map(t -> t.getAttribute("value"))
                .collect(Collectors.toList());

        List<String> addedProducts = allAddedProducts
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        allProducts.removeAll(addedProducts);
        String eklenecekUrun = allProducts.getFirst();
        return eklenecekUrun;
    }

    public String getState(String productName) {
        return driver.findElement(By.xpath("//a[@title='" + productName + "']/../../span")).getText();

    }

    public void Clickname() {
        // Eklenmiş ürünlerin isimlerini ve statülerini aliyor
        List<String> eklenmisUrunIsimleri = eklenmisUrunlerinIsimleri.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> productStatusList = allProductsStatus.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

// Son onaylanmış bir ürünün ismini bulup ona tıkliyor
        int sonOnaylanmisIndex = -1;
        for (int i = 0; i < productStatusList.size(); i++) {
            if (productStatusList.get(i).equals("APPROVED")) {
                sonOnaylanmisIndex = i;
            }
        }

        if (sonOnaylanmisIndex != -1) {
            String productName = eklenmisUrunIsimleri.get(sonOnaylanmisIndex);
            WebElement productElement = eklenmisUrunlerinIsimleri.get(sonOnaylanmisIndex);
            JSUtils.clickElementByJS(productElement);
            System.out.println("Clicked on the last approved product: " + productName);
        } else {
            System.out.println("No approved product found!");
        }
    }
    public void assertProductGroup(){
        for (int i = 0; i <allhubs.size() ; i++) {
            Assert.assertTrue(allhubs.get(i).isDisplayed());
        }
    }
    public void assertProductInformation(){
        ReusableMethods.waitForVisibility(getAccountHubPage().productName.getFirst(),5);
        for (int i = 0; i <productName.size() ; i++) {
            Assert.assertTrue(productName.get(i).isDisplayed());
            Assert.assertTrue(productPrice.get(i).isDisplayed());
            Assert.assertTrue(productStock.get(i).isDisplayed());
        }
    }
    public void assertProductStatus() {
        for (int i = 0; i < productStatus.size(); i++) {
            String status = productStatus.get(i).getText();
            switch (status) {
                case "APPROVED":
                    Assert.assertEquals(status, "APPROVED");
                    break;
                case "IN_REVIEW":
                    Assert.assertEquals(status, "IN_REVIEW");
                    break;
                case "REJECTED":
                    Assert.assertEquals(status, "REJECTED");
                    break;
                default:
                    Assert.assertEquals(status, "ALL");
                    break;

            }
        }
    }
    public void productStockUpdate(){
        ReusableMethods.waitForVisibility(productStockInfo,5);
        productStockInfo.clear();
        productStockInfo.sendKeys("150");

    }
}

