package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_110_ChangeDelivery_StepDefs {

    @Given("user connect to {string}")
    public void userConnectTo(String url) {
        response = given().
                contentType(ContentType.JSON)
//                .body("")
                .auth()
                .oauth2(token)
                .when()
                .post(url);

    }

}
