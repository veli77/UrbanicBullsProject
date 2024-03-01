package stepDefinitions.UI_StepDefs.AccountDeliveryPage;


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


public class US_060_DeliveryPickUpSellerFlexibleDeliveryStepdefs extends CommonPage {

    @And("user send {string} as zipcode")
    public void userSendAsZipcode(String zipcode) {
        // way 1
//        getWeeklyOrderPage().zipCode.sendKeys(zipcode);
//        actions.sendKeys(Keys.ENTER).perform();
        // way 2
        getAccountWeeklyOrderPage().sendZipcode(zipcode);
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
        getAccountDeliveryPage().unCheckDeliverySettings();
    }

    @And("user clicks on seller flexible")
    public void userClicksOnSellerFlexible() {
        getAccountDeliveryPage().seller_flexible.click();
    }

    @Given("user verifies web elements with following ids displays correct text")
    public void userVerifiesWebElementsWithFollowingIdsDisplaysCorrectText(DataTable dataTable) {
        List<String> webElementFor = dataTable.column(0);
        List<String> labels = dataTable.column(1);

        for (int i = 0; i < labels.size(); i++) {
            getAccountDeliveryPage().assertLabelWithWebelement(
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
            getAccountDeliveryPage().assertInputWithWebelement(webElementInput.get(i));
//            System.out.println(webElementInput.get(i));
        }
    }

    @Then("user should see alert messages out of range input Free Delivery Range")
    public void userShouldSeeAlertMessagesOutOfRangeInputFreeDeliveryRange(DataTable dataTable) {
        List<String> elements = dataTable.column(0);
        List<String> inputs = dataTable.column(1);
        List<String> messages = dataTable.column(2);

        for (int i = 0; i < elements.size(); i++) {

            WebElement element = driver.findElement(By.cssSelector("#" + elements.get(i)));
            element.clear();
            element.click();
            element.sendKeys(inputs.get(i));

            String actualMessage = element.getAttribute("validationMessage");
            System.out.println(actualMessage + " : " + messages.get(i));
//Assert.assertEquals(messages.get(i),messages.get(i).contains(actualMessage));
            Assert.assertEquals(messages.get(i),actualMessage);


        }


    }


    @When("user enter address fields")
    public void userEnterAddressFields() {
        // way 1
//        getAccountDeliveryPage().freeFlexibleDeliveryRange.clear();
//        getAccountDeliveryPage().freeFlexibleDeliveryRange.sendKeys("10");
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.ARROW_UP);
//        String increasedValue = getAccountDeliveryPage().freeFlexibleDeliveryRange.getAttribute("value");
//        Assert.assertEquals("10.01",increasedValue);
        // way 2 extention
        clearAndSend(getAccountDeliveryPage().freeFlexibleDeliveryRange,"10");
        clearAndSend(getAccountDeliveryPage().minFreeFlexibleDeliveryOrder, "15");
        clearAndSend(getAccountDeliveryPage().perMileCostFlex, "1");
        clearAndSend(getAccountDeliveryPage().maxFlexibleDeliveryRange, "20");

    }

    @And("enter some order times")
    public void enterSomeOrderTimes() {
        getAccountDeliveryPage().deliveryBeginTime.sendKeys("0205pm");
        getAccountDeliveryPage().deliveryEndTime.sendKeys("0305pm");
        getAccountDeliveryPage().orderByTime.sendKeys("0405pm");
    }

    @Then("days should be appropriate")
    public void daysShouldBeAppropriate(DataTable table) {
//        // way 1
//        Select select = new Select(getAccountDeliveryPage().deliveryBeginDay);
//        select.selectByVisibleText("Monday");
//        // way 2 extention
//        getAccountDeliveryPage().deliveryEndDay.selectByVisibleText("Tuesday");

        List<Map<String, String>> maps = table.asMaps();
        for (int i = 0; i < maps.size(); i++) {
            String orderBegin = maps.get(i).get("OrderBegin");
            String orderEnd = maps.get(i).get("OrderEnd");
            String delivery = maps.get(i).get("Delivery");
            String errorMessage = maps.get(i).get("ErrorMessage");
            boolean isOK = Boolean.parseBoolean(maps.get(i).get("isOK"));

            selectByVisibleText(getAccountDeliveryPage().deliveryBeginDay, orderBegin);

            selectByVisibleText(getAccountDeliveryPage().deliveryEndDay, orderEnd);
            selectByVisibleText(getAccountDeliveryPage().orderByDay, delivery);
            getAccountDeliveryPage().update.click();
            //waitFor(2);
            ReusableMethods.waitForVisibility(getHomePage().toastMessage, 10);

            Assert.assertEquals(errorMessage,getHomePage().toastMessage.getText());

//            if (isOK) {
//
//                Assert.assertEquals(
//                        COLOR.GREEN.getRgba(),
//                        getHomePage().toastMessage.getCssValue("background-color")
//                );
//            } else {
//
//                Assert.assertEquals(
//                        COLOR.RED.getRgba(),
//                        getHomePage().toastMessage.getCssValue("background-color")
//                );
//            }

            getHomePage().toastMessage.click();


        }

    }

    @Given("user selects {string} for orderBegin")
    public void userSelectsForOrderBegin(String value) {
        // way 3 utilities
        ReusableMethods.selectByValue(
                getAccountDeliveryPage().deliveryBeginDay,
                value
        );
    }

    @And("user enters input to order begin {string}")
    public void userEntersInputToOrderBegin(String time) {
        getAccountDeliveryPage().deliveryBeginTime.sendKeys(time);
    }

    @And("user selects {string} for orderEnd")
    public void userSelectsForOrderEnd(String value) {
        // way 1 bu da olur methodu
//        Select select = new Select(webElement);
//        select.selectByValue(value);
        // way 2 extention
        selectByValue(getAccountDeliveryPage().deliveryEndDay, value);
    }

    @And("user enters input to order end {string}")
    public void userEntersInputToOrderEnd(String time) {
        getAccountDeliveryPage().deliveryEndTime.sendKeys(time);
    }

    @And("user selects {int} for deliverBy")
    public void userSelectsDeliverByForDeliverBy(int index) {
        selectByIndex(getAccountDeliveryPage().orderByDay, index);
    }


    @And("user enters input to deliver by {string}")
    public void userEntersInputToDeliverBy(String time) {
        getAccountDeliveryPage().orderByTime.sendKeys(time);
    }

    @And("user clicks on update button")
    public void userClicksOnUpdateButton() {
        getAccountDeliveryPage().update.click();
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
