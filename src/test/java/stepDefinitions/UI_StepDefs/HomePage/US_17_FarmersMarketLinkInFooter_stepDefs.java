package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class US_17_FarmersMarketLinkInFooter_stepDefs extends CommonPage {
    @When("the user scrolls to the bottom of the page")
    public void theUserScrollsToTheBottomOfThePage() {

    }

    @And("the user clicks on the Farmers Market link in the footer")
    public void theUserClicksOnTheFarmersMarketLinkInTheFooter() {
        ReusableMethods.waitForPageToLoad(3);
        JSUtils.clickElementByJS(getHomePage().FarmersMarketLinkInFooter);

    }
}
