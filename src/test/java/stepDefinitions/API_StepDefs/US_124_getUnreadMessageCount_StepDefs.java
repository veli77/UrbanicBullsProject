package stepDefinitions.API_StepDefs;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utilities.API_Utils;

import static io.restassured.RestAssured.given;
import static utilities.API_Utils.response;

public class US_124_getUnreadMessageCount_StepDefs {

    @When("user get unread message count {string}")
    public void user_get_unread_message_count(String endPoint) {
        RequestSpecification requestSpecification = API_Utils.preSetUp(USERCREDENTIAL.USER3);
        response = given().
                spec(requestSpecification).
                when().post(endPoint);
    }

    @Then("user verifies success {string}")
    public void user_verifies_success(String verify) {
        JsonPath jsonPath = response.jsonPath();
        String actuallValue = String.valueOf(jsonPath.getBoolean("success"));
        Assert.assertEquals(verify, actuallValue);

    }
}
