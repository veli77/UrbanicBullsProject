package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.junit.Assert;

import static stepDefinitions.Hooks.response;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.token;

public class US_130_EventRegister_StepDefs {


    @Given("user connect to  {string}")
    public void userConnectTo(String url) {
        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .when()
                .post(url)
                .prettyPeek();
    }

    @Then("user verifies event register status code {int}")
    public void userVerifiesEventRegisterStatusCode(Integer int1) {
        Integer actualstatusCode = response.getStatusCode();
        Assert.assertEquals(actualstatusCode, int1);

    }

}

