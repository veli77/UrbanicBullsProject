package stepDefinitions.UI_StepDefs.SellShareTradePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class US_047_LogoutBtn_stepDefs extends CommonPage {

   /* @When("User clicks on Login module")
    public void userClicksOnLoginModule() {
        JSUtils.clickElementByJS(getHomePage().LoginBtnAtButton);
    }


    @And("User logs in")
    public void userLogsIn() {

        getLoginPage().login();
    } */


    @When("User clicks on Sell-Share-Trade module")
    public void user_clicks_on_sell_share_trade_module() throws InterruptedException {
        JSUtils.clickElementByJS(getSellShareTradePage().Sell_Share_TradeBtn);
        Thread.sleep(3000);

    }


    @When("User clicks on Logout module")
    public void user_clicks_on_logout_module() {
         ReusableMethods.hover(getSellShareTradePage().LogoutBtn_SellShareTradePage);
         getSellShareTradePage().LogoutBtn_SellShareTradePage.click();
    }

    @Then("Verifies that the user has returned to the home page")
    public void verifies_that_the_user_has_returned_to_the_home_page() {
        getSellShareTradePage().verifyHomePage();
    }



}
