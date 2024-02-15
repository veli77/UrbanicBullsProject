package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.When;
import pages.CommonPage;

public class US_023_BottomAboutUsBtn_stepDefs extends CommonPage {
    @When("User click to About Us btn at the bottom")
    public void userClickToAboutUsBtnAtTheBottom() {
        getHomePage().clickBottomAboutUs();
    }

}
