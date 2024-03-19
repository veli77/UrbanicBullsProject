package stepDefinitions.API_StepDefs;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utilities.API_Utils;

import static stepDefinitions.Hooks.response;
import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.token;

public class US_130_EventRegister_StepDefs {



    @Given("user connect to  {string}")
    public void userConnectTo(String url) {

        RequestSpecification requestSpecification = API_Utils.preSetUp(USERCREDENTIAL.USER2);

        String jsonBody = """
            {
                "eventId": "990",
                "numberOfAttendees": "1",
                "isAuthenticatedUser": true
            }
            """;

        API_Utils.response = given()
                .spec(requestSpecification)
                .body(jsonBody)
                .post(url)
        ;

       API_Utils.response.prettyPrint();
    }


    @Then("Status code is 200")
    public void statusCodeIs200() {
        Assert.assertEquals("Status code is not 200", 200, API_Utils.response.getStatusCode());
    }

    @And("description is successful")
    public void descriptionIsSuccessful() {
        String jsonResponse = API_Utils.response.getBody().asString();
        JsonPath jsonPath = new JsonPath(jsonResponse);

        Assert.assertTrue("Success value is not true", jsonPath.getBoolean("success"));
        Assert.assertEquals("Description is not 'Waiting for Paymentt'", "Waiting for Paymentt", jsonPath.getString("descr"));
    }
}
