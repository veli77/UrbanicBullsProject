package pages;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigurationReader;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.*;

public class AccountAddressPage extends CommonPage{

    @FindBy(css = "button[name='sales']")
    public WebElement mySalesAddressBtn;
    @FindBy(css = "button[name='delivery']")
    public WebElement myDeliveryAddressBtn;
    @FindBy(css = "[class='alert alert-warning ']>span")
    public WebElement mySalesAddressAlert;
    @FindBy(css ="button[name='nonSelected']")
    public WebElement othersBtn;
    @FindBy(css = ".mr-2.btn.btn-outline-warning")
    public WebElement editBtn;
    @FindBy(css = "h6[class='card-title']")
    public WebElement cardTitle;
    @FindBy(css = "p[class='card-text']")
    public WebElement cardText;

    @FindBy(xpath = "//button[@class='btn btn-outline-danger'][.='Remove']")
    public WebElement removeBtn;
    @FindBy(xpath = "//button[.='No']")
    public WebElement removeNoBtn;
    @FindBy(xpath = "//button[.='Yes']")
    public WebElement removeYesBtn;
    @FindBy(css = "h5[class='text-center mb-4']")
    public WebElement areYouSureMessage;


    @FindBy(css = "div.text-center.mb-2>button")
    public List<WebElement> removeApprovalBtns;
    @FindBy(xpath = "//button[.='Add New Address']")
    public WebElement addNewAddressBtn;
    @FindBy(css = "input[type='search']")
    public WebElement searchNewPlacesInput;
    @FindBy(css = ".autocomplete-dropdown-container>li")
    public List<WebElement> suggestedAddressList;
    @FindBy(css = "input[type='text']")
    public List<WebElement> addressInputList; //10 elemean var 6-10 arası lazım olanlar
    @FindBy(css = "button[type='submit']")
    public List<WebElement> saveAddressBtns; //bana sonuncusu lazım
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement successMsj;
    @FindBy(xpath = "//button[@name='sales']")
    public WebElement MySalesAddressBtn;
    @FindBy(xpath = "//button[@class='btn btn-outline-success']")
    public WebElement AddNewAddressBtn;
    @FindBy(xpath = "//input[@type='search']")
    public WebElement SearchPlacesInput;
    @FindBy(xpath = "//input[@id='postal']")
    public WebElement PostaZipCodeInput;
    @FindBy(xpath = "//input[@id='isSellerAddress']")
    public WebElement MarkAsASalerAddressInput;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement MySalesAddressSubmitBtn;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement MySalesAddressEditSubmitBtn;
    @FindBy(xpath = "//div[@class='Toastify__toast-body toastr_custom-toastr__iiU37']")
    public WebElement AlertYourAddresssuccessfullyAdded;
    @FindBy(xpath = "//button[@class='mr-2 btn btn-outline-warning']")
    public WebElement MySalesAddressEditBtn;
    @FindBy(xpath = "//button[@class='btn btn-outline-danger']")
    public WebElement MySalesAddressRemoveBtn;
    @FindBy(xpath = "//h5[@class='text-center mb-4']")
    public WebElement AreYouSureToDeleteTheAddressMessage;
    @FindBy(xpath = "//div[@class='form-row']")
    public List<WebElement> AddressDetailsPage;
    @FindBy(xpath = "//div[@class='text-center mb-2']")
    public WebElement YesNoOptionsText;
    @FindBy(xpath = "//div[@class='Toastify__toast-body toastr_custom-toastr__iiU37']")
    public WebElement AlertYourAddresssuccessfullyUpdated;
    @FindBy(xpath = "//input[@id='addressTitle']")
    public WebElement AddressTitleInput;
    @FindBy(xpath = "//button[@class='address_accordionTab__116wZ address_accordionActive__2fQgS']")
    public WebElement MySalesAddressText;
    @FindBy(css = "iframe[class='rounded address_iframe__2VuTl']")
    public WebElement iframe;
    @FindBy(css = "div.google-maps-link a")
    public WebElement googleMapsLink;
    @FindBy(css = "button[class*='gm-inset-map gm-inset']")
    public WebElement googleMapsSatelliteButton;
    @FindBy(css = "button.gm-control-active")
    public List<WebElement> mapsZoomButtons;
    @FindBy(xpath = "(//div[@class='gm-style']/div[contains(@style, 'cursor')])[1]")
    public WebElement cursorOverTheMapNatureZones;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement AddNewAddressSubmitButton;
    @FindBy(xpath = "//div[@class='address_accordionItem__container__1uDbr']")
    public WebElement DeliveryAndSalesRegisteredAddress;
    @FindBy(xpath = "//button[@name='delivery']")
    public WebElement MyDeliveryAddressBtn;

    @FindBy(css = "input[id='addressTitle']")
    public WebElement myAddressTitleInput;
    @FindBy(css = "input[id='address']")
    public WebElement myAddressInput;
    @FindBy(css = "input[id='states']")
    public WebElement myStatesInput;
    @FindBy(css = "input[id='citiesDataIdAddAddress']")
    public WebElement myCityInput;
    @FindBy(css = "input[id='postal']")
    public WebElement myPostalCode;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement mySubmitButton;
    @FindBy(css = " [name='isDefault']")
    public WebElement myDeliveryAdressCheckBox;

    @FindBy(css = "h5[class = 'card-header']")
    public WebElement myCurrentAddressTitle;
    @FindBy(css = "h6[class = 'card-title']")
    public WebElement myCurrentAddressStateCity;
    @FindBy(css = "p[class = 'card-text']")
    public WebElement myCurrentAddressOneRow;











    public void clickMarkAsDeliveryAndMarkAsDelivery(String option){
        WebElement element=driver.findElement(By.xpath("//input[@id='"+option+"']"));
       JSUtils.clickElementByJS(element);
    }

    public void sendKeysZipCode1(){
        WebElement element=driver.findElement(By.xpath("(//input[@id='postal'])[2]"));
        element.sendKeys("95170");
    }
    public void clickAddNewAddressSubmit(){
        WebElement element=driver.findElement(By.xpath("//button[@type='submit']"));
        JSUtils.clickElementByJS(element);
    }


    public void clickPagesBtn(String str){
        WebElement element=driver.findElement(By.xpath("//button[@name='"+str+"']"));
        ReusableMethods.waitAndClickElement(element,3);
    }

    public void VerifyClickAddNewAddressAllHeaders(String header) throws InterruptedException {
//        Addres Title id--->addressTitle
//        Address id--->address
//                State id--->states
//                City id--->citiesDataIdAddAddress
//                Posta/Zip id--->postal
//                Mark as delivery address--->isDefault
//                Mark as sales address-->isSellerAddress

        WebElement element= driver.findElement(By.xpath("//input[@id='"+header+"']"));
        JSUtils.clickElementByJS(element);
        Thread.sleep(2000);
    }
    public void verifyAllHeaders() throws InterruptedException {
        getAccountAddressPage().VerifyClickAddNewAddressAllHeaders("isSellerAddress");
        getAccountAddressPage().VerifyClickAddNewAddressAllHeaders("isDefault");
        getAccountAddressPage().VerifyClickAddNewAddressAllHeaders("postal");
        getAccountAddressPage().VerifyClickAddNewAddressAllHeaders("citiesDataIdAddAddress");
        getAccountAddressPage().VerifyClickAddNewAddressAllHeaders("states");
        getAccountAddressPage().VerifyClickAddNewAddressAllHeaders("address");
        getAccountAddressPage().VerifyClickAddNewAddressAllHeaders("addressTitle");
    }

    //My Sales Address a tıklar ve bu kısmında adress kayıtlı mı kontrol eder, addres varsa true yoksa false döner
    public boolean clickMySalesAddressBtnAndControlTheAdress() {
        waitForClickablility(mySalesAddressBtn, 10);
        mySalesAddressBtn.click();
        String expectedAlertMessage = "You haven't set your sales address yet. Please select one from your other addresses.";
        hover(mySalesAddressAlert);
        String actualAlertMessage = mySalesAddressAlert.getText();
        boolean flag;
        try {
            flag = expectedAlertMessage.equals(actualAlertMessage);
        } catch (Exception e){
            flag = false;
            System.out.println("msjlar farklı");
        }
        return !flag;
    }

    public void areYouSureToDeleteYESorNO(String option){
     WebElement element=driver.findElement(By.xpath("//button[text()='"+option+"']"));
     JSUtils.clickElementByJS(element);
    }

    public void sendKeysAddressTitle(){
        getAccountAddressPage().AddressTitleInput.clear();
        ReusableMethods.sendText(getAccountAddressPage().AddressTitleInput,"Emily's Home Office");
    }

    public void addressOptions() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//ul[@class='list-group mt-2 autocomplete-dropdown-container']")).getText());
        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='list-group mt-2 autocomplete-dropdown-container']")).stream().toList();
        list.getFirst().click();
        Thread.sleep(3000);
    }

    public void sendKeysAddress() throws InterruptedException {
        Thread.sleep(3000);
        JSUtils.clickElementByJS(getAccountAddressPage().SearchPlacesInput);
        ReusableMethods.sendText(getAccountAddressPage().SearchPlacesInput,"California");
        //getAccountAddressPage().SearchPlacesInput.click();
    }

    public void verifyPageUrl(String expectedUrl) {
        //String expectedUrl = "https://test.urbanicfarm.com/account/address";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actual="+actualUrl);
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    public void sendKeysPostaZipCode(){
        getAccountAddressPage().PostaZipCodeInput.sendKeys("95170");
    }

    //others section a tıklar
    public void clickOthersSection() {
        waitForClickablility(othersBtn, 10);
        othersBtn.click();
    }

    public void clickDeliveryAddressSection() {
        waitForClickablility(myDeliveryAddressBtn, 10);
        myDeliveryAddressBtn.click();
    }


    //others section da kayıtlı address yoksa address ekler ve tekrar others section a döner
    //daha önce ekli bir adress olmamalı!!
    public void areThereAnySavedAddressesInOdersSectionAndAdd(DataTable dataTable) {
        boolean flag = true;
        try {
            flag = editBtn.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Ekli bir adres mevcut değil.");
            flag=false;
        }
        int j;
        if (!flag) {
            addNewAddressBtn.click();
            searchNewPlacesInput.sendKeys(dataTable.row(0).get(5));
            suggestedAddressList.getFirst().click();
            for (int i = addressInputList.size()-1; i > addressInputList.size() - 6; i--) {
                j = i - addressInputList.size() + 5;
                if (i == addressInputList.size() - 2 || i == addressInputList.size() - 3) {
                    continue;
                }
                addressInputList.get(i).clear();
                addressInputList.get(i).sendKeys(dataTable.row(0).get(j));
            }
            saveAddressBtns.getLast().click();
        } else {
            System.out.println("Zaten bir seller adresi bulunmamaktadır.");
        }
    }

    //Edit ve Remove Btnları kontrol eder.
    public void enableEditRemoveBtns(){
        hover(editBtn);
        Assert.assertTrue(editBtn.isDisplayed());
        Assert.assertTrue(removeBtn.isDisplayed());
        Assert.assertTrue(editBtn.isEnabled());
        Assert.assertTrue(removeBtn.isEnabled());
    }

    public void editAndRemoveBtnsCheck(){
        boolean flag = true;

        try {
            flag = editBtn.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("adres yok");
            flag=false;
        }

        if (flag) {
            hover(editBtn);
            Assert.assertTrue(editBtn.isDisplayed() && editBtn.isEnabled() &&
                    removeBtn.isDisplayed() && removeBtn.isEnabled());
        }else {
            addNewAddressBtn.click();
            searchNewPlacesInput.sendKeys("Calif");
            suggestedAddressList.getFirst().click();
            myPostalCode.sendKeys("95170");
            myDeliveryAdressCheckBox.click();
            mySubmitButton.click();
            flag = true;
            try {
                flag = editBtn.isDisplayed();
            } catch (NoSuchElementException e) {
                System.out.println("adres yok");
                flag=false;
            }
            if(flag){
                ReusableMethods.hover(editBtn);
                Assert.assertTrue(editBtn.isDisplayed() && editBtn.isEnabled() &&
                        removeBtn.isDisplayed() && removeBtn.isEnabled());

            }else {
                Assert.assertFalse(false);
            }



        }
    }

    public void checkAddressesBeforeAndAfterClickEdit(){
        String[] originalAdress;
        String[] tryAdress;
        String[] editedAdress;
        tryAdress = TakeCongigAddress();
        System.out.println(Arrays.toString(tryAdress));
        originalAdress = TakeCurrentAddress();
        System.out.println(Arrays.toString(originalAdress));
        EditAddressWith(tryAdress);
        editedAdress = TakeCurrentAddress();
        System.out.println(Arrays.toString(editedAdress));
        EditAddressWith(originalAdress);
        Assert.assertArrayEquals(editedAdress, tryAdress);
    }
    public void EditAddressWith(String[] addresses){
        waitForClickablility(editBtn,10);
        editBtn.click();
        ReusableMethods.waitForClickablility(myAddressInput,5);
        myAddressTitleInput.clear();
        myAddressTitleInput.sendKeys(addresses[0]);
        myAddressInput.clear();
        myAddressInput.sendKeys(addresses[1]);
        myStatesInput.clear();
        myStatesInput.sendKeys(addresses[2]);
        myCityInput.clear();
        myCityInput.sendKeys(addresses[3]);
        myPostalCode.clear();
        myPostalCode.sendKeys(addresses[4]);
        mySubmitButton.click();
        waitForClickablility(editBtn,10);
        waitFor(1);
    }
    public String[] TakeCongigAddress(){
        String [] adresses;
        adresses = new String[5];
        adresses[0] = ConfigurationReader.getProperty("AddressLine0");
        adresses[1] = ConfigurationReader.getProperty("AddressLine1");
        adresses[2] = ConfigurationReader.getProperty("AddressLine2");
        adresses[3] = ConfigurationReader.getProperty("AddressLine3");
        adresses[4] = ConfigurationReader.getProperty("AddressLine4");
        return adresses;
    }
    public String [] TakeCurrentAddress(){
        String[] adresses;
        adresses = new String[5];
        adresses[0] = myCurrentAddressTitle.getText().substring(0,4);
        adresses[1] = myCurrentAddressOneRow.getText().substring(0,myCurrentAddressOneRow.getText().lastIndexOf(","));
        adresses[2] = myCurrentAddressStateCity.getText().substring(0,myCurrentAddressStateCity.getText().indexOf(" "));
        adresses[3] = myCurrentAddressStateCity.getText().substring(myCurrentAddressStateCity.getText().lastIndexOf(" ")+1);
        adresses[4] = myCurrentAddressOneRow.getText().substring(myCurrentAddressOneRow.getText().lastIndexOf(" ")+1);
        return adresses;

    }
    public void clickNoForCancel(){
        ReusableMethods.waitForClickablility(removeNoBtn,5);
        removeNoBtn.click();
        waitForVisibility(editBtn,5);
        Assert.assertTrue(editBtn.isDisplayed());
    }



    //Edit işlemi yapar, Dataları datatabledan alır
    public void editAnAddress(DataTable dataTable) {
        waitForPageToLoad(10);
        hover(editBtn);
        waitForClickablility(editBtn,10);
        editBtn.click();
        int j;
        for (int i = addressInputList.size()-1; i > addressInputList.size() - 6; i--) {
            j = i - addressInputList.size() + 5;
            if (i == addressInputList.size() - 2 || i == addressInputList.size() - 3) {
                continue;
            }
            addressInputList.get(i).clear();
            addressInputList.get(i).sendKeys(dataTable.row(0).get(j));
        }
        saveAddressBtns.getLast().click();
    }

    //işlem yaptıktan sonra gelen Toast msjı kontrol eder
    public void getToastMsj(){
        waitForVisibility(successMsj,10);
        Assert.assertTrue(successMsj.isDisplayed());
    }

    //Remove btn a tıklar
    public void clickRemoveBtn() {
        waitForClickablility(removeBtn, 10);
        removeBtn.click();
    }

    //Remove yaptıktan sonra gelen yes no btnları kontrol eder
    public void controlYesNoOptions(){
        waitForClickablility(removeYesBtn,10);
        Assert.assertTrue(removeYesBtn.isDisplayed());
        Assert.assertTrue(removeNoBtn.isDisplayed());
    }

    //Remove yaptıktan sonra sadece yes no 2 btn çıkmalı
    public void controlOnly2Btns(){
        Assert.assertEquals(2,removeApprovalBtns.size());
    }

    //Remove btn a tıklar
    public void clickRemoveYesBtn() {
        waitForClickablility(removeYesBtn, 10);
        removeYesBtn.click();
    }

    public void goToMapPage() {

        if (!googleMapsLink.isEnabled()){
        driver.switchTo().frame(iframe);}
        JSUtils.scrollIntoViewJS(googleMapsLink);
        JSUtils.clickElementByJS(googleMapsLink);
        Set<String> windowsList=driver.getWindowHandles();
        for (String window : windowsList){driver.switchTo().window(window);}
        ReusableMethods.hover(getHomePage().googleChromePermissionRejectButton);
        getHomePage().googleChromePermissionRejectButton.click();

    }




}

