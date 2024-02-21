package stepDefinitions.UI_StepDefs.AccountOrdersPage;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.AccountOrdersPage;
import pages.CommonPage;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class US_64_OrdersModuleFunctionality_stepDefs extends CommonPage {
    @When("User logs in as Vedat")
    public void UserLogsInAsVedat() {
        getLoginPage().login(USERCREDENTIAL.USERVEDAT);
    }

    @Then("User should be able to click the {string} button on the left side bar in Account Page and verify that user is in the Orders Page")
    public void userShouldBeAbleToClickTheButtonOnTheLeftSideBarInAccountPageAndVerifyThatUserIsInTheOrdersPage(String btnName) {
        getAccountHubPage().verifyLeftPanelButton(btnName);
        getAccountHubPage().clickAButtonInLeftPanel(btnName);
        ReusableMethods.waitForPageToLoad(5);
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
}
