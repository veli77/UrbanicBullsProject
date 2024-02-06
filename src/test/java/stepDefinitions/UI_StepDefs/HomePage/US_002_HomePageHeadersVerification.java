package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import utilities.ReusableMethods;

import java.util.List;

public class US_002_HomePageHeadersVerification extends CommonPage {

    @Then("the user should see the Support the local food movement and following headers from left to right:")
    public void theUserShouldSeeTheSupportTheLocalFoodMovementAndFollowingHeadersFromLeftToRight(List<String> expectedHeaders) {

       ReusableMethods.verifyElementDisplayed(getHomePage().JoinTheMovementText);

        for (int i = 0; i < expectedHeaders.size(); i++) {

            Assert.assertEquals(getHomePage().NavbarModules.get(i).getText(),expectedHeaders.get(i));

        }


    }
}
