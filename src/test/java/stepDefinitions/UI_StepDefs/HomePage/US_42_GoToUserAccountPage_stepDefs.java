package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

import static stepDefinitions.Hooks.driver;

public class US_42_GoToUserAccountPage_stepDefs extends CommonPage{


    @Then("The user should see leftside tabs")
    public void theUserShouldSeeLeftsideTabs(DataTable dataTable) throws InterruptedException {

        List<String> tabsNames=dataTable.asList();

        ReusableMethods.waitForPageToLoad(5);
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
       // Assert.assertTrue(driver.getCurrentUrl().contains("account"));

        List<String> tabs = new ArrayList<>();
        for (int i = 0; i <getAccountHomePage().accountPageLeftsidesTabs.size(); i++) {

            tabs.add(getAccountHomePage().accountPageLeftsidesTabs.get(i).getText());
        }

        for (String tab : tabsNames) {

            Assert.assertTrue(tabs.contains(tab));
        }

    }
}
