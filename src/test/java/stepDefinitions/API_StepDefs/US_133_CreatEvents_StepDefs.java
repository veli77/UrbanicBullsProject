package stepDefinitions.API_StepDefs;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utilities.API_Utils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.API_Utils.response;

public class US_133_CreatEvents_StepDefs {
    RequestSpecification requestSpecification = API_Utils.preSetUp(USERCREDENTIAL.USER2);
    private static int event_id;
    @When("user gets the create an events at {string}")
    public void userGetsTheCreateAnEventsAt(String url) {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", "test");
        parameters.put("date", "2024-05-23T12:13");
        parameters.put("fee", 20);
        parameters.put("isRefundable", false);
        parameters.put("refundableUpToDay", 0);
        parameters.put("duration", 10);
        parameters.put("attendeeLimit", 60);
        parameters.put("addressId", 3573);
        parameters.put("tac", "terms");
        response = given()
                .spec(requestSpecification)
                .body(parameters)
                .when()
                .post(url);
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
       event_id = jsonPath.getInt("event.id");
    }
    @When("user gets the delete an events at {string}")
    public void userGetsTheDeleteAnEventsAt(String url) {

        response = given()
                .spec(requestSpecification)
                .body("{\"eventId\":"+ event_id + "}")
                .when()
                .post(url);
        response.prettyPrint();

        response.prettyPrint();

    }

    @Then("user verifies success {string}")
    public void userVerifiesSuccess(String verify) {

        JsonPath jsonPath = response.jsonPath();
        String actuallValue = String.valueOf(jsonPath.getBoolean("success"));
        Assert.assertEquals(verify,actuallValue);

    }
}
