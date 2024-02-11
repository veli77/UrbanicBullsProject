package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebElement;
import pages.HomePage;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.*;



public class US_020_Explore_BlogButton extends HomePage {
    @When("User clicks on the explore blog button")
    public void user_clicks_on_the_explore_blog_button() {
        waitFor(2);
        hover(ExploreBlog);
        ExploreBlog.click();
    }

    @Then("User should be redirected to the Blog page")
    public void UserShouldBeRedirectedToTheBlogPage() {
        ReusableMethods.switchToWindow("Welcome to the Urbanic Farm Blog - UrbanicFarm");
        ReusableMethods.verifyTitle("Welcome to the Urbanic Farm Blog - UrbanicFarm");
        System.out.println(driver.getTitle());
    }

    @And("User should see relevant content on the Blog page")
    public void UserShouldSeeRelevantContentOnTheBlogPage() {
        for (WebElement blogContent : getHomePage().BlogContents) {
            ReusableMethods.verifyElementDisplayed(blogContent);
        }

    }
}