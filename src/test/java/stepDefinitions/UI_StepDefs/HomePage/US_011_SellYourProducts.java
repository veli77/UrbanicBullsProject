package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Then;
import pages.CommonPage;

public class US_011_SellYourProducts extends CommonPage {
    @Then("User is able to see Sell Your Products expression in the page")
    public void userIsAbleToSeeSellYourProductsExpressionInThePage() {
        getHomePage().SellYourProducts.isDisplayed();
    }
}
