package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SellShareTradePage;
import utilities.ReusableMethods;

public class US_044_SellShareTrade_04_StepDef {

    SellShareTradePage sellShareTradePage = new SellShareTradePage();
    HomePage homePage = new HomePage();

    @And("Click the Sell-Share-Trade button")
    public void clickTheSellShareTradeButton() {
        homePage.addZipCode("95170");
        sellShareTradePage.clickSellShareTradeBtn();
    }

    @Then("Verify Scheduled Delivery module can be accessible")
    public void verifyScheduledDeliveryModuleCanBeAccessible() throws InterruptedException {
        sellShareTradePage.verifyScheduledDeliveryLink();
    }

}
