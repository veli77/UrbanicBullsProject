package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.token;
import static stepDefinitions.Hooks.response;

public class US_104_Adress_StepDefs {

    @Given("users connect to the {string}")
    public void users_connect_to_the(String url) {
        response = given().
                contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .when()
                .post(url);

       // response.prettyPrint();

    }
    @Then("user verifies success message")
    public void user_verifies_success_message() {
        int actualStatusCode = response.getStatusCode();
        assertEquals(200, actualStatusCode);

        JsonPath jsonPath = response.jsonPath();

        System.out.println("jsonPath.getString(\"addresses.address\") = " + jsonPath.getString("addresses[0].address"));


    }

}
