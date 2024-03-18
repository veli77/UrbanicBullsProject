package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_129_GetEventsDetails_StepDefs {
    @Given("User connect to the {string} get my events")
    public void userConnectToTheGetMyEvents(String url) {
        String jsonBody = """
                {
                  "cancelToken": {
                    "promise": {}
                  }
                }
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

    @Then("User verifies my events get success message {int}")
    public void userVerifiesMyEventsGetSuccessMessage(Integer SCode) {
        Integer actualstatusCode = response.getStatusCode();
        Assert.assertEquals(actualstatusCode, SCode);
    }
}
