package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import pages.HomePage;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_023_BottomAboutUsBtn extends CommonPage {
    @When("User click to About Us btn at the bottom")
    public void userClickToAboutUsBtnAtTheBottom() {
        getHomePage().clickBottomAboutUs();
    }

}
