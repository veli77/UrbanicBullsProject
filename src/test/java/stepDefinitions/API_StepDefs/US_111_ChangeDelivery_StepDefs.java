package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.junit.Assert;
import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.token;
import static stepDefinitions.Hooks.response;

public class US_111_ChangeDelivery_StepDefs {
    @Given("User goes to {string}")
    public void userGoesTo(String url) {

        String jsonBody = """
                {"availability":"10:00-12:00","availabilityBranch":"","deliveryType":["BUYER_PICKUP","SELLER_FLEXIBLE"],"estimatedDeliveryTime":[],"flexibleDeliveryOptions":[{"deliveryBy":3066,"orderBegin":4445,"orderEnd":8826}],"freeDeliveryRange":"100","maxDeliveryRange":200,"minFreeDeliveryOrder":15,"perMileCost":"1"}
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

    @Then("User verifies that availability for seller has changed")
    public void userVerifiesThatAvailabilityForSellerHasChanged() {
        int actualstatusCode = response.getStatusCode();
        Assert.assertEquals( actualstatusCode,200);
    }
}
