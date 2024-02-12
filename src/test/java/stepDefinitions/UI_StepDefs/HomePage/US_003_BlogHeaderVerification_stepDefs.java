package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_003_BlogHeaderVerification_stepDefs extends CommonPage {
    @When("the user clicks on the Blog header")
    public void theUserClicksOnTheBlogHeader() {
        getHomePage().BlogLink.click();
        //ReusableMethods.waitFor(5);
    }

    @Then("the user should be redirected to the Blog page")
    public void theUserShouldBeRedirectedToTheBlogPage() {
        ReusableMethods.switchToWindow("Welcome to the Urbanic Farm Blog - UrbanicFarm");
        ReusableMethods.verifyTitle("Welcome to the Urbanic Farm Blog - UrbanicFarm");
        System.out.println(driver.getTitle());
    }

    @And("the user should see relevant content on the Blog page")
    public void theUserShouldSeeRelevantContentOnTheBlogPage() {
        for (WebElement blogContent : getHomePage().BlogContents) {
            ReusableMethods.verifyElementDisplayed(blogContent);
        }
    }
}
