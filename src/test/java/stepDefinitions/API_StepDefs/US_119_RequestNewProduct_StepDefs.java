package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_119_RequestNewProduct_StepDefs {
    @Given("User connect to the {string} and request new product")
    public void user_connect_to_the_and_request_new_product(String url) {
        String jsonBody="""
                {
                           "description": "Fruit",
                           "relatedHub": "VEGETABLES_AND_FRUITS_HUB",
                           "title": "Apel"
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
    @Then("User verifies request new product success message {int}")
    public void user_verifies_request_new_product_success_message(Integer int1) {
        Integer actualstatusCode = response.getStatusCode();
        Assert.assertEquals(actualstatusCode, int1);
    }
}
