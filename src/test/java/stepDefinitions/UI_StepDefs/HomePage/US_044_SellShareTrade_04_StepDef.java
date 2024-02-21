package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CommonPage;

public class US_044_SellShareTrade_04_StepDef extends CommonPage {

    @And("Click the Sell-Share-Trade button")
    public void clickTheSellShareTradeButton() {
        getHomePage().addZipCode("95170");
        getSellShareTradePage().clickSellShareTradeBtn();
    }

    @Then("Verify Scheduled Delivery module can be accessible")
    public void verifyScheduledDeliveryModuleCanBeAccessible() {
        getSellShareTradePage().verifyScheduledDeliveryLink();
    }

}
