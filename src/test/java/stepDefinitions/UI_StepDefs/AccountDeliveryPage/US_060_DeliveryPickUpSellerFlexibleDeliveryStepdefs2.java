package stepDefinitions.UI_StepDefs.AccountDeliveryPage;


import enums.COLOR;
import enums.USERCREDENTIAL;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import pages.CommonPage;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.*;


public class US_060_DeliveryPickUpSellerFlexibleDeliveryStepdefs2 extends CommonPage {

    @And("user send {string} as zipcode")
    public void userSendAsZipcode(String zipcode) {
        // way 1
//        getWeeklyOrderPage().zipCode.sendKeys(zipcode);
//        actions.sendKeys(Keys.ENTER).perform();
        // way 2
        getWeeklyOrderPage().sendZipcode(zipcode);
    }
    @Given("User logs in with Urbanic two credential")
    public void userLogsInWithUrbanicTwoCredential() {
        getLoginPage().login(USERCREDENTIAL.USER2);

    }

    @When("user clicks on Account button")
    public void userClicksOnAccountButton() {
        getHomePage().accountName_navbar.click();
    }

    @And("user clicks on delivery and pickup settings")
    public void userClicksOnDeliveryAndPickupSettings() {
        getHomePage().deliverySettings_sidebar.click();
    }

    @And("unselect all checkbox")
    public void unselectAllCheckbox() {
        getDeliveryAndPickupSettings().unCheckDeliverySettings();
    }

    @And("user clicks on seller flexible")
    public void userClicksOnSellerFlexible() {
        getDeliveryAndPickupSettings().seller_flexible.click();
    }

    @Given("user verifies web elements with following ids displays correct text")
    public void userVerifiesWebElementsWithFollowingIdsDisplaysCorrectText(DataTable dataTable) {
        List<String> webElementFor = dataTable.column(0);
        List<String> labels = dataTable.column(1);

        for (int i = 0; i < labels.size(); i++) {
            getDeliveryAndPickupSettings().assertLabelWithWebelement(
                    labels.get(i),
                    webElementFor.get(i)
            );

        }

    }

    @Then("user verifies web elements with following ids input")
    public void userVerifiesWebElementsWithFollowingIdsInput(DataTable dataTable) {
        List<String> webElementInput = dataTable.column(0);

        for (int i = 0; i < webElementInput.size(); i++) {

//            assert driver.findElement(By.xpath("//input[@id='"+webElementInput+"']")).isDisplayed();
//            ReusableMethods.verifyElementDisplayed(driver.findElement(By.xpath("//input[@id='"+webElementInput.get(i)+"']")));
            getDeliveryAndPickupSettings().assertInputWithWebelement(webElementInput.get(i));
//            System.out.println(webElementInput.get(i));
        }
    }

    @Then("user should see alert messages out of range input Free Delivery Range")
    public void userShouldSeeAlertMessagesOutOfRangeInputFreeDeliveryRange(DataTable dataTable) {
        List<String> inputs = dataTable.column(0);
        List<String> messages=dataTable.column(1);
        for (int i = 0; i < inputs.size() ; i++) {
            getDeliveryAndPickupSettings().freeFlexibleDeliveryRange.clear();
            getDeliveryAndPickupSettings().freeFlexibleDeliveryRange.click();
            getDeliveryAndPickupSettings().freeFlexibleDeliveryRange.sendKeys(inputs.get(i));
            String actualMessage=getDeliveryAndPickupSettings().freeFlexibleDeliveryRange.getAttribute("validationMessage");
//            System.out.println(actualMessage+" : " + messages.get(i));
            Assert.assertEquals(messages.get(i),messages.get(i).contains(actualMessage));
        }

    }


    @When("user enter address fields")
    public void userEnterAddressFields() {
        // way 1
        getDeliveryAndPickupSettings().freeFlexibleDeliveryRange.clear();
        getDeliveryAndPickupSettings().freeFlexibleDeliveryRange.sendKeys("10");
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.ARROW_UP);
//        String increasedValue = getDeliveryAndPickupSettings().freeFlexibleDeliveryRange.getAttribute("value");
//        Assert.assertEquals("10.01",increasedValue);
        // way 2 extention

        clearAndSend(getDeliveryAndPickupSettings().minFreeFlexibleDeliveryOrder, "15");
        clearAndSend(getDeliveryAndPickupSettings().perMileCostFlex, "1");
        clearAndSend(getDeliveryAndPickupSettings().maxFlexibleDeliveryRange, "20");

    }

    @And("enter some order times")
    public void enterSomeOrderTimes() {
        getDeliveryAndPickupSettings().deliveryBeginTime.sendKeys("0205pm");
        getDeliveryAndPickupSettings().deliveryEndTime.sendKeys("0305pm");
        getDeliveryAndPickupSettings().orderByTime.sendKeys("0405pm");
    }

    @Then("days should be appropriate")
    public void daysShouldBeAppropriate(DataTable table) {
//        // way 1
//        Select select = new Select(getDeliveryAndPickupSettings().deliveryBeginDay);
//        select.selectByVisibleText("Monday");
//        // way 2 extention
//        getDeliveryAndPickupSettings().deliveryEndDay.selectByVisibleText("Tuesday");

        List<Map<String, String>> maps = table.asMaps();
        for (int i = 0; i < maps.size(); i++) {
            String orderBegin = maps.get(i).get("OrderBegin");
            String orderEnd = maps.get(i).get("OrderEnd");
            String delivery = maps.get(i).get("Delivery");
            String errorMessage = maps.get(i).get("ErrorMessage");
            boolean isOK = Boolean.parseBoolean(maps.get(i).get("isOK"));

            selectByVisibleText(getDeliveryAndPickupSettings().deliveryBeginDay, orderBegin);

            selectByVisibleText(getDeliveryAndPickupSettings().deliveryEndDay, orderEnd);
            selectByVisibleText(getDeliveryAndPickupSettings().orderByDay, delivery);
            getDeliveryAndPickupSettings().update.click();
            //waitFor(2);
            ReusableMethods.waitForVisibility(getHomePage().toastMessage, 10);

            Assert.assertEquals(
                    errorMessage,
                    getHomePage().toastMessage.getText()
            );

            if (isOK) {

                Assert.assertEquals(
                        COLOR.GREEN.getRgba(),
                        getHomePage().toastMessage.getCssValue("background-color")
                );
            } else {

                Assert.assertEquals(
                        COLOR.RED.getRgba(),
                        getHomePage().toastMessage.getCssValue("background-color")
                );
            }

            getHomePage().toastMessage.click();


        }

    }

    @When("user selects {string} for orderBegin")
    public void userSelectsForOrderBegin(String value) {
        // way 3 utilities
        ReusableMethods.selectByValue(
                getDeliveryAndPickupSettings().deliveryBeginDay,
                value
        );
    }

    @And("user enters input to order begin {string}")
    public void userEntersInputToOrderBegin(String time) {
        getDeliveryAndPickupSettings().deliveryBeginTime.sendKeys(time);
    }

    @And("user selects {string} for orderEnd")
    public void userSelectsForOrderEnd(String value) {
        // way 1 bu da olur methodu
//        Select select = new Select(webElement);
//        select.selectByValue(value);
        // way 2 extention
        selectByValue(getDeliveryAndPickupSettings().deliveryEndDay, value);
    }

    @And("user enters input to order end {string}")
    public void userEntersInputToOrderEnd(String time) {
        getDeliveryAndPickupSettings().deliveryEndTime.sendKeys(time);
    }

    @And("user selects {int} for deliverBy")
    public void userSelectsDeliverByForDeliverBy(int index) {
        selectByIndex(getDeliveryAndPickupSettings().orderByDay, index);
    }


    @And("user enters input to deliver by {string}")
    public void userEntersInputToDeliverBy(String time) {
        getDeliveryAndPickupSettings().orderByTime.sendKeys(time);
    }

    @And("user clicks on update button")
    public void userClicksOnUpdateButton() {
        getDeliveryAndPickupSettings().update.click();
    }

    @Then("user verifies the toast message is {string}")
    public void userVerifiesTheToastMessageIs(String expectedToastMessage) {
        //waitFor(2);
        //WebElement toastMessage= driver.findElement(By.cssSelector(".Toastify__toast-body"));
        ReusableMethods.waitForVisibility(getHomePage().toastMessage, 10);
        //System.out.println("getHomePage().toastMessage.getText() = " + getHomePage().toastMessage.getText());
        //System.out.println("getHomePage().toastMessage.getText() = " + getHomePage().toastMessage.getText());
        Assert.assertEquals(getHomePage().toastMessage.getText(), expectedToastMessage);
//        Assert.assertEquals(toastMessage.getText(),expectedToastMessage);
    }

    @And("local clear")
    public void localClear() {

        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        localStorage.clear();
        driver.navigate().refresh();

    }


}
