package stepDefinitions.UI_StepDefs.AccountHubPage;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.DBUtilities;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_062_ActionsInSelectedProduct_StepDef extends CommonPage {
    int eskiBoyut;

    @Given("user logs in as a Buyer")
    public void userLogsInAsABuyer() {
        getLoginPage().login(USERCREDENTIAL.USERBUYER);
    }

    @And("user goes to Your products-services")
    public void userGoesToYourProductsServices() {
        ReusableMethods.clickWithTimeOut(getAccountHubPage().yourProductService_navbar,5);
    }

    @And("user click on random Hubs")
    public void userClickOnRandomHubs() {
        getAccountHubPage().allhubs.getFirst().click();
    }

    @And("user verifies that Product Name, Price, Stock, Unit information  is displayed.")
    public void userVerifiesThatProductNamePriceStockUnitInformationIsDisplayed() {
        getAccountHubPage().assertProductNamePriceStockUnit();
    }

    enum STATE {
        APPROVED,
        IN_REVIEW,
        REJECTED
    }
    @And("user verifies that APPROVED, IN_REVIEW, REJECTED options for each product should be visible")
    public void userVerifiesThatAPPROVEDIN_REVIEWREJECTEDOptionsForEachProductShouldBeVisible() {
        getAccountHubPage().allProductsStatus
                .stream()
                .forEach(t -> {
                    Assert.assertTrue(
                            t.getText().equals(STATE.APPROVED.name()) ||
                                    t.getText().equals(STATE.IN_REVIEW.name()) ||
                                    t.getText().equals(STATE.REJECTED.name())
                    );
                });
    }

    String eklenecekUrun;
    @And("user add new product")
    public void userAddNewProduct() {
        eklenecekUrun = getAccountHubPage().eklenebilecekUrun();
        getAccountHubPage().addNewProduct_Name.sendKeys(eklenecekUrun);
        getAccountHubPage().addNewProduct_Price.sendKeys("20");
        getAccountHubPage().addNewProduct_Stock.sendKeys("20");

        Select select = new Select(getAccountHubPage().addNewProduct_Unit);
        select.selectByIndex(0);
        JSUtils.clickElementByJS(getAccountHubPage().addNewProduct_Submit);
        ReusableMethods.waitFor(2);
    }

    @Then("In-Review should be visible on the added product.")
    public void inReviewShouldBeVisibleOnTheAddedProduct() {
        String actualState = getAccountHubPage().getState(eklenecekUrun);
        String expectedState = STATE.IN_REVIEW.name();
        Assert.assertEquals(expectedState, actualState);
    }

    @When("User approve last added product from database")
    public void userApproveLastAddedProductFromDatabase() {
        DBUtilities.approvedLastProduct();
    }

    @Then("Approved should be visible on the added product.")
    public void approvedShouldBeVisibleOnTheAddedProduct() {
        driver.navigate().back();
        ReusableMethods.waitFor(2);
        driver.navigate().forward();
        String actualState = getAccountHubPage().getState(eklenecekUrun);
        String expectedState = STATE.APPROVED.name();
        Assert.assertEquals(expectedState, actualState);

    }

    @And("user clicks previously added product name")
    public void userClicksProductName() {
        getAccountHubPage().Clickname();

    }

    @And("user verifies that Update button is visible")
    public void userVerifiesThatUpdateButtonIsVisible() {
        Assert.assertTrue(getAccountHubPage().update.isDisplayed());
    }

    @And("user verifies that Delete button is visible")
    public void userVerifiesThatDeleteButtonIsVisible() {
        Assert.assertTrue(getAccountHubPage().delete.isDisplayed());
    }

    @And("user verifies that Organic button is functional")
    public void userVerifiesThatOrganicButtonIsFunctional() {
        ReusableMethods.selectCheckBox(getAccountHubPage().organic, true);
    }

    @And("user verifies that Trade button is functional")
    public void userVerifiesThatTradeButtonIsFunctional() {
        ReusableMethods.selectCheckBox(getAccountHubPage().trade, true);
    }

    @And("user verifies that Trade description is visible")
    public void tradeDescriptionInputIsVisible() {
        ReusableMethods.verifyElementDisplayed(getAccountHubPage().tradeDescription);
    }

    @And("user sends Selam to Trade input  description")
    public void userSendsSelamToTradeInputDescription() {
        getAccountHubPage().tradeDescription.clear();
        getAccountHubPage().tradeDescription.sendKeys("Selam");
        ReusableMethods.waitFor(2);
    }

    @And("user changes Price,Stocks,Unit type")
    public void userChangesPriceStocksUnitType() {
        getAccountHubPage().price.clear();
        ReusableMethods.waitFor(2);
        getAccountHubPage().price.sendKeys("12", Keys.TAB, "12");
        Select select = new Select(getAccountHubPage().unitType);
        select.selectByVisibleText("Pound");
    }

    @And("user clicks Update button")
    public void userClicksUpdateButton() {
        JSUtils.clickElementByJS(getAccountHubPage().update);
        ReusableMethods.waitFor(3);

    }

    @Then("user verifies that Updated alert is visible")
    public void userVerifiesThatUpdatedAlertIsVisible() {
        ReusableMethods.waitForVisibility(getAccountHubPage().updatedAlert, 3);
        ReusableMethods.verifyElementDisplayed(getAccountHubPage().updatedAlert);
    }

    @When("user proceeds forward, retrieves the count of products in the list, then returns back")
    public void userProceedsForwardRetrievesTheCountOfProductsInTheListThenReturnsBack() {
        driver.navigate().back();
        ReusableMethods.waitFor(2);
        eskiBoyut = getAccountHubPage().eklenmisUrunlerinIsimleri.size();
        driver.navigate().forward();
    }


    @When("user clicks Delete button")
    public void userClicksDeleteButton() {
        JSUtils.clickElementByJS(getAccountHubPage().delete);
        ReusableMethods.waitFor(2);
    }

    @And("user verifies that Yes options is visible")
    public void userVerifiesThatYesNoOptionsAreVisible() {
        ReusableMethods.verifyElementDisplayed(getAccountHubPage().yes);
    }

    @And("user verifies that No options is visible")
    public void userVerifiesThatNoOptionsIsVisible() {
        ReusableMethods.verifyElementDisplayed(getAccountHubPage().no);
    }

    @And("user selects no option and verifies that No option cancel the operation")
    public void userVerifiesThatNoOptionCancelTheOperation() {
        getAccountHubPage().no.click();
        System.out.println("After clicking No button last approved product is still here" + getAccountHubPage().lastApprovedProduct.getText());
    }

    @When("user selects the Yes option and verifies that the last added product has been removed")
    public void userSelectsYesOption() {
        JSUtils.clickElementByJS(getAccountHubPage().yes);
        ReusableMethods.waitFor(5);
        int yeniBoyut = getAccountHubPage().eklenmisUrunlerinIsimleri.size();
        Assert.assertEquals("Listede bir eleman eksik", yeniBoyut, eskiBoyut - 1);
    }

    @Then("user verifies that deleting alert is displayed")
    public void userVerifiesThatDeletingAlertIsDisplayed() {
        ReusableMethods.verifyElementDisplayed(getAccountHubPage().deleteAlert);
    }


}
