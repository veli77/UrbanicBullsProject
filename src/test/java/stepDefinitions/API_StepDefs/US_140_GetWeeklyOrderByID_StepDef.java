package stepDefinitions.API_StepDefs;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import utilities.API_Utils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.API_Utils.response;

public class US_140_GetWeeklyOrderByID_StepDef {

    @When("user gets the WeeklyOrderbyId at {string}")
    public void userGetsTheWeeklyOrderbyIdAt(String endpoint) {

        RequestSpecification requestSpecification = API_Utils.preSetUp(USERCREDENTIAL.USER2);

        Map<String, Integer> expectedData = new HashMap<>();
        expectedData.put("id", 366);

        response = given()
                .spec(requestSpecification)
                .body(expectedData)
                .post(endpoint)
        ;

        response.prettyPrint();
    }

    @Then("user should be able to verifies order ID")
    public void userShouldBeAbleToVerifiesOrderID() {

        JsonPath jsonPath = response.jsonPath();
        int actualData = jsonPath.getInt("0.id");
        Assert.assertEquals(366, actualData);
    }

}
