package pages;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

import static utilities.ReusableMethods.*;


public class AccountAddressPage extends CommonPage{

    @FindBy(css = "button[name='sales']")
    public WebElement mySalesAddressBtn;
    @FindBy(css = "[class='alert alert-warning ']>span")
    public WebElement mySalesAddressAlert;
    @FindBy(css ="button[name='nonSelected']")
    public WebElement othersBtn;
    @FindBy(css = ".mr-2.btn.btn-outline-warning")
    public WebElement editBtn;
    @FindBy(xpath = "//button[@class='btn btn-outline-danger'][.='Remove']")
    public WebElement removeBtn;
    @FindBy(xpath = "//button[.='No']")
    public WebElement removeNoBtn;
    @FindBy(xpath = "//button[.='Yes']")
    public WebElement removeYesBtn;
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

    //others section a tıklar
    public void clickOthersSection() {
        waitForClickablility(othersBtn, 10);
        othersBtn.click();
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
        if (flag == false) {
            addNewAddressBtn.click();
            searchNewPlacesInput.sendKeys(dataTable.row(0).get(5));
            suggestedAddressList.get(0).click();
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





}

