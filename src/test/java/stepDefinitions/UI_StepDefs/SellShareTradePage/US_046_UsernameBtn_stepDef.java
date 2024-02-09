package stepDefinitions.UI_StepDefs.SellShareTradePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.JSUtils;

import static stepDefinitions.Hooks.driver;

public class US_046_UsernameBtn_stepDef extends CommonPage {
    @When("User clicks on Username button")
    public void userClicksOnUsernameButton() {

        System.out.println(driver.getTitle());
        JSUtils.clickElementByJS(getSellShareTradePage().usernameBtn);
//        getSellShareTradePage().userNameBtnClick();
    }

    @And("User goes to Account page")
    public void userGoesToAccountPage() {
        System.out.println(driver.getTitle());
    }
}
