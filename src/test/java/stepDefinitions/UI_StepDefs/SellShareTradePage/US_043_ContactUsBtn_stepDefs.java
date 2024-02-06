package stepDefinitions.UI_StepDefs.SellShareTradePage;

import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.ReusableMethods;

public class US_043_ContactUsBtn_stepDefs extends CommonPage {

    @When("User clicks on Contact Us module")
    public void user_clicks_on_contact_us_module() {
        ReusableMethods.waitForClickablility(getSellShareTradePage().ContactUsBtn_SellShareTread,3).click();

    }

}
