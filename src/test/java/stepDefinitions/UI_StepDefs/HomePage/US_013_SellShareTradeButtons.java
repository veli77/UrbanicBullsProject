package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class US_013_SellShareTradeButtons extends CommonPage {
    @Then("User is able to click on Sell button under Sell Your Products")
    public void userIsAbleToClickOnSellButtonUnderSellYourProducts() {
        getHomePage().SellButton.isEnabled();
        JSUtils.clickElementByJS(getHomePage().SellButton);
        getHomePage().UrbanicFarmLink.click();
    }

    @And("User is able to click on Share button under Sell Your Products")
    public void userIsAbleToClickOnShareButtonUnderSellYourProducts() {
        getHomePage().Sharebutton.isEnabled();
        JSUtils.clickElementByJS(getHomePage().Sharebutton);
        getHomePage().UrbanicFarmLink.click();

    }

    @And("User is able to click on Trade button under Sell Your Products")
    public void userIsAbleToClickOnTradeButtonUnderSellYourProducts() {
        getHomePage().TradeButton.isEnabled();
        JSUtils.clickElementByJS(getHomePage().TradeButton);
        getHomePage().UrbanicFarmLink.click();
    }
}
