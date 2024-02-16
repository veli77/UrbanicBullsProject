package stepDefinitions.UI_StepDefs.AccountHubPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;

public class US_063_YourProducts_Services_stepDefs extends CommonPage {

    @When("User click to YourProducts_Services btn at the button")
    public void user_click_to_your_products_services_btn_at_the_button() throws InterruptedException {
       getAccountWeeklyOrderPage().setYourProducts_ServicesBtnClick();
    }

    @Then("User must verify that the YourProducts_Services page appears")
    public void user_must_verify_that_the_your_products_services_page_appears() throws InterruptedException {
        Thread.sleep(3000);
       getAccountHubPage().VerifyYourProducts_ServicesPageUrl();
    }

    @Then("user clicks the return button, it should return")
    public void user_clicks_the_return_button_it_should_return() throws InterruptedException {
       getAccountHubPage().goToPreviousPage();
    }

    @Then("User must verify that the Home page appears")
    public void user_must_verify_that_the_home_page_appears() {
       getAccountWeeklyOrderPage().verifyGoToPreviousPage();
    }

}
