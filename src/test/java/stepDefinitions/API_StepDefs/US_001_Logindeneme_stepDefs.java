package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.response;

public class US_001_Logindeneme_stepDefs {


    @Given("user connect to the {string}")
    public void user_connect_to_the(String endpoint) {
        response = given()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"erdal@yopmail.com\",\"password\": \"nPfXAzs656Jw6*w\"}")
                .when()
                .post("https://test.urbanicfarm.com/api/public/login");

        response.prettyPrint();
        int statusCode = response.getStatusCode();
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        Assert.assertEquals(200, statusCode);


    }

    @Then("user verifies status code {int}")
    public void user_verifies_status_code(Integer expectedStatusCode) {


    }
}
