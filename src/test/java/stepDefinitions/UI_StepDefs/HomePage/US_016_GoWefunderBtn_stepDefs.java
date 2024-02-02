package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_016_GoWefunderBtn_stepDefs extends CommonPage {

    @When("User clicks on Go Wefunder module")
    public void user_clicks_on_go_wefunder_module() throws InterruptedException {
        JSUtils.clickElementByJS(getHomePage().GoWefunder);

    }


    @Then("User must verify that the Wefunder page appears")
    public void user_must_verify_that_the_wefunder_page_appears() throws InterruptedException {

        ReusableMethods.switchToWindow(1);
        Assert.assertTrue( driver.getCurrentUrl().contains("https://wefunder.com/urbanicfarm"));

    }

}
