package stepDefinitions.UI_StepDefs.AccountHubPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_056_googleMapsFunctions_stepDefs extends CommonPage {
    @When("User click to Address button, user can see related page")
    public void userClickToAddressButtonUserCanSeeRelatedPage() {
        ReusableMethods.waitForPageToLoad(5);
        ReusableMethods.hover(getAccountHomePage().accountPageLeftsidesTabs.get(1));
        getAccountHubPage().goToAddressPage();
        System.out.println(driver.getCurrentUrl());
     //  Assert.assertTrue(getAccountAddressPage().mapScreeninAddressPage.isDisplayed());
    }

    @And("Zoom buttons should be clickable.")
    public void zoomButtonsShouldBeClickable() {
        for (WebElement element: getAccountAddressPage().mapsZoomButtons) {
            ReusableMethods.hover(element);
            element.click(); }
    }

    @Then("User click to View Larger Map link, user can reach related page.")
    public void userClickToViewLargerMapLinkUserCanReachRelatedPage() {
        ReusableMethods.waitForClickablility(getAccountAddressPage().googleMapsLink,3);
        //ReusableMethods.hover(getAccountAddressPage().googleMapsLink);
        getAccountAddressPage().googleMapsLink.click();
        ReusableMethods.waitForPageToLoad(5);
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("maps"));
        getAccountHubPage().goToPreviousPage();
    }

    @Then("User click to satellite screen box, map should change.")
    public void userClickToSatelliteScreenBoxMapShouldChange() {
        getAccountAddressPage().googleMapsSatelliteButton.click();

    }

    @Then("User click to park or forest area name, user can see a label related area.")
    public void userClickToParkOrForestAreaNameUserCanSeeALabelRelatedArea() {
        ReusableMethods.hover(getAccountAddressPage().cursorOverTheMapNatureZones);
        Assert.assertTrue(getAccountAddressPage().cursorOverTheMapNatureZones.getAttribute("cursor").contains("pointer"));


    }
}
