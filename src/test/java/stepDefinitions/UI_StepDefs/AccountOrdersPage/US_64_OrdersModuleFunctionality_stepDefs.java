package stepDefinitions.UI_StepDefs.AccountOrdersPage;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.AccountOrdersPage;
import pages.CommonPage;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class US_64_OrdersModuleFunctionality_stepDefs extends CommonPage {
    @When("User logs in as Vedat")
    public void UserLogsInAsVedat() {
        getLoginPage().login(USERCREDENTIAL.USERVEDAT);
    }


    @Then("User should be able to click the {string} button on the left side bar in Account Page and verify that user is in the Orders Page")
    public void userShouldBeAbleToClickTheButtonOnTheLeftSideBarInAccountPageAndVerifyThatUserIsInTheOrdersPage(String btnName) {
        //getAccountHubPage().verifyLeftPanelButton(btnName);
        //ReusableMethods.waitForPageToLoad(5);
        //getAccountHubPage().clickAButtonInLeftPanel(btnName);
        ReusableMethods.waitForPageToLoad(5);
        //getAccountHomePage().leftSideOrdersButton.click();
        JSUtils.clickElementByJS(getAccountHomePage().leftSideOrdersButton);
        //ReusableMethods.waitFor(5);
        getAccountOrdersPage().verifyOrdersPage();

    }

    @And("User selects any order")
    public void userSelectsAnyOrder() {
        getAccountOrdersPage().selectOrder();
    }


    @Then("User should be able to see Quick Overview Contents")
    public void userShouldBeAbleToSeeQuickOverviewContents() {

        for (WebElement quickOverviewContent : getAccountOrdersPage().quickOverviewContents) {
            //verifying contents --> //
            System.out.println(quickOverviewContent.getText());
            assertTrue(quickOverviewContent.isDisplayed());
        }

        for (WebElement orderPicture : getAccountOrdersPage().quickOverviewContentsPictures) {
            assertTrue(orderPicture.isDisplayed());

        }

    }

    @And("User clicks Rate The Product linkText")
    public void userClicksRateTheProductLinkText() {
        for (WebElement rateTheProductLink : getAccountOrdersPage().rateTheProductLinks) {
            Assert.assertTrue(rateTheProductLink.isDisplayed());
        }
        getAccountOrdersPage().rateTheProductLinks.getFirst().click();
    }

    @Then("User should be able to see rating pop-up and contents")
    public void userShouldBeAbleToSeeRatingPopUpAndContents() {
        Assert.assertTrue(getAccountOrdersPage().howWouldYouRateThisProductText.isDisplayed());
        Assert.assertTrue(getAccountOrdersPage().ratingStars.isDisplayed());
        Assert.assertTrue(getAccountOrdersPage().commentArea.isDisplayed());
        Assert.assertTrue(getAccountOrdersPage().submitButton.isDisplayed());
        getAccountOrdersPage().closeTheRatingWindow.click();

    }


    @And("User should be able to click Seller Page button in Order Details page and should be reach related page.")
    public void userShouldBeAbleToClickSellerPageButtonInOrderDetailsPageAndShouldBeReachRelatedPage() {
        ReusableMethods.waitForPageToLoad(5);
        //getAccountOrdersPage().clickSellerPageButtonAndVerifySellerPage();
        getAccountOrdersPage().viewOrderDetailsLink.click();
        ReusableMethods.waitFor(5);

        Assert.assertTrue(getAccountOrdersPage().sellerNameText.isDisplayed());
        System.out.println("sellerName = " + getAccountOrdersPage().sellerNameText.getText());

        Assert.assertTrue(getAccountOrdersPage().sellerNameText.isDisplayed());
        System.out.println("sellerEmail = " + getAccountOrdersPage().sellerEmailText.getText());

        Assert.assertTrue(getAccountOrdersPage().rateTheSellerLinkText.isDisplayed());

        Assert.assertTrue(getAccountOrdersPage().callSellerLinkText.isDisplayed());

        Assert.assertTrue(getAccountOrdersPage().sellerPageLinkText.isDisplayed());

        Assert.assertTrue(getAccountOrdersPage().sellerAddressText.isDisplayed());

        getAccountOrdersPage().rateTheSellerLinkText.click();

        Assert.assertTrue(getAccountOrdersPage().rateTheSellerHowWouldYouRateThisProductText.isDisplayed());

        Assert.assertTrue(getAccountOrdersPage().ratingStars.isDisplayed());

        Assert.assertTrue(getAccountOrdersPage().commentArea.isDisplayed());

        Assert.assertTrue(getAccountOrdersPage().submitButton.isDisplayed());


    }
}
