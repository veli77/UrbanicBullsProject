package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import utilities.API_Utils;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_121_GetBasketDetails_StepDefs {

    @When("User gets basket details")
    public void user_gets_basket_details() {
        response =  given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .when()
                .post("https://test.urbanicfarm.com/api/public/basket/getBasketDetails");
        response.prettyPrint();
    }
    @Then("User verifies status code and basket details")
    public void user_verifies_status_code_and_basket_details() {
        int actualStatusCode = response.getStatusCode();
        assertEquals(200, actualStatusCode);

        JsonPath jsonPath = response.jsonPath();
        int actualData = jsonPath.getInt("id");
        Assert.assertEquals(6, actualData);


    }
}
