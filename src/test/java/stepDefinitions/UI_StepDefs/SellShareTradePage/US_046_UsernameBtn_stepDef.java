package stepDefinitions.UI_StepDefs.SellShareTradePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.JSUtils;

import static stepDefinitions.Hooks.driver;

public class US_046_UsernameBtn_stepDef extends CommonPage {
    @Then("User clicks on Username button")
    public void userClicksOnUsernameButton() {
        getSellShareTradePage().userNameBtnClick();
    }

    @And("User verifies that the Account page has been opened")
    public void userGoesToAccountPage() {
        String expectedUrl="https://test.urbanicfarm.com/account/home";
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());
    }
}
