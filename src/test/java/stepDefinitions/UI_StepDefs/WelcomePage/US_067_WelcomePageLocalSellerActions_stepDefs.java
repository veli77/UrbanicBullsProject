package stepDefinitions.UI_StepDefs.WelcomePage;

import io.cucumber.java.en.Then;
import pages.CommonPage;


public class US_067_WelcomePageLocalSellerActions_stepDefs extends CommonPage {

    @Then("User should be able to click seller rating")
    public void user_should_be_able_to_click_seller_rating() {
        getWelcomePage().SellerRatingClickableCheck();
    }

    @Then("User is able to see selected option after select any select rating")
    public void user_is_able_to_select_any_select_rating() {
        getWelcomePage().SellerRatingSelectAnOption();
    }
    @Then("User should be able to click product rating")
    public void user_should_be_able_to_click_product_rating() {
        getWelcomePage().ProductRatingClickableCheck();
    }



    @Then("User is able to see selected option after select any product rating")
    public void user_should_be_able_to_see_selected_product_rating() {
        getWelcomePage().ProductRatingSelectAnOption();

    }
}
