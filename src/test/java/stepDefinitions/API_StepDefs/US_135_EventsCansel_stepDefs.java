package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_135_EventsCansel_stepDefs {

    @Given("User connect to the {string} and cancels the events")
    public void user_connect_to_the_and_cancels_the_events(String url) {
        String jsonBody="""
           {"attendanceId":223,"willBeRefunded":false}
        """;

        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body(jsonBody)
                .when()
                .post(url)
                .prettyPeek();

    }

    @Then("User verifies {string} message")
    public void userVerifiesMessage(String expectedMessage) {

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getString("success"));
        assertEquals(true, jsonPath.get("success"));
        assertEquals(expectedMessage, jsonPath.get("descr"));
    }
}

