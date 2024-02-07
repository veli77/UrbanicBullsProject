package stepDefinitions.UI_StepDefs.SellShareTradePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.JSUtils;

public class US_049_CartBtn_stepDefs extends CommonPage {

    @When("User clicks on Cart module")
    public void user_clicks_on_cart_module() {
        JSUtils.clickElementByJS(getSellShareTradePage().Cart_SellShareTradePage);
    }

    @Then("User verifies that the Cart text has been opened")
    public void user_verifies_that_the_cart_text_has_been_opened() {
     getSellShareTradePage().verifyCartPage();

    }


}
