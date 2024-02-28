package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.response;

public class US_100_Login_StepDefs {


    @Given("user connect to the {string}")
    public void user_connect_to_the(String endpoint) {
        response = given()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"erdal@yopmail.com\",\"password\": \"nPfXAzs656Jw6*w\"}")
                .when()
                .post("https://test.urbanicfarm.com/api/public/login");


    }

    @Then("user verifies status code {int}")
    public void user_verifies_status_code(int expectedStatusCode) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, statusCode);
    }
}
