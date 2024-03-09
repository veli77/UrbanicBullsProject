package stepDefinitions.UI_StepDefs.AccountHubPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.ReusableMethods;

import java.awt.*;


import static stepDefinitions.Hooks.driver;

public class US_056_googleMapsFunctions_stepDefs extends CommonPage {
    @When("User click to Address button, user can see related page")
    public void userClickToAddressButtonUserCanSeeRelatedPage() {

        getAccountHubPage().goToAddressPage();
        ReusableMethods.waitForPageToLoad(5);
        Assert.assertTrue(getAccountAddressPage().iframe.isDisplayed());

    }

//    @And("Zoom buttons should be clickable.")
//    public void zoomButtonsShouldBeClickable() {
//
//       driver.switchTo().frame(getAccountAddressPage().iframe);
//
//     //  for (WebElement element: getAccountAddressPage().mapsZoomButtons){
//      //     element.click();
//    //   }
//       getHomePage().screenshotClick("C:\\Users\\ersin\\IdeaProjects\\UrbanicBullsProject\\src\\test\\java\\utilities\\sikuliX_ScreenShots\\googleMap_zoom_up_button.jpg");
//       getHomePage().screenshotClick("C:\\Users\\ersin\\IdeaProjects\\UrbanicBullsProject\\src\\test\\java\\utilities\\sikuliX_ScreenShots\\googleMap_zoom_IN_button.jpg");
//
//    }

    @Then("User click to View Larger Map link, user can reach related page.")
    public void userClickToViewLargerMapLinkUserCanReachRelatedPage() {

        getAccountAddressPage().goToMapPage();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("maps"));
        ReusableMethods.switchToWindow(0);
    }

    @Then("User click to satellite screen box, map should change.")
    public void userClickToSatelliteScreenBoxMapShouldChange() {
        driver.switchTo().frame(getAccountAddressPage().iframe);
        ReusableMethods.hover(getAccountAddressPage().googleMapsSatelliteButton);
        getAccountAddressPage().googleMapsSatelliteButton.click();

    }

    @Then("User click to park or forest area name, user can see a label related area.")
    public void userClickToParkOrForestAreaNameUserCanSeeALabelRelatedArea() {

        ReusableMethods.hover(getAccountAddressPage().cursorOverTheMapNatureZones);
        // Robot robot=new Robot();
        //  robot.mouseMove(getAccountAddressPage().cursorOverTheMapNatureZones);

        //  Assert.assertTrue(getAccountAddressPage().cursorOverTheMapNatureZones.getAttribute("cursor").contains("pointer"));


    }
}
