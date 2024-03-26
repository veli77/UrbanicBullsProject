package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_127_GetMyEvents_StepDefs {
    @Given("User connect to the {string} and get my events")
    public void user_connect_to_the_and_get_my_events(String url) {

        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .when()
                .post(url)
                .prettyPeek();
    }

    @Then("User verifies get my events success message {int}")
    public void user_verifies_get_my_events_success_message(Integer int1) {
        Integer actualstatusCode = response.getStatusCode();
        Assert.assertEquals(actualstatusCode, int1);
    }
}
