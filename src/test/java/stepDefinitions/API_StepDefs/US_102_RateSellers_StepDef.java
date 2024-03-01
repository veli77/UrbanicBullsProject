package stepDefinitions.API_StepDefs;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_102_RateSellers_StepDef {

    @When("User goes to Rate Seller page")
    public void userGoesToRateSellerPage() {
       response =  given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body("{\"sellerId\": \"1180\"}")
                .when()
                .post("https://test.urbanicfarm.com/api/account/feedback/seller/getRates");

    }

    @Then("User verifies status code and success response")
    public void userVerifiesStatusCodeAndSuccessResponse() {

        int actualStatusCode = response.getStatusCode();
        assertEquals(200, actualStatusCode);

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.get("success").toString());
        assertEquals(true, jsonPath.get("success"));
    }
}
