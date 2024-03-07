package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_109_Delivery_And_Pick_Up_Settings_Availability {
    @Given("User connect to the {string} and change availability for buyer picks up")
    public void user_connect_to_the_and_change_availability_for_buyer_picks_up(String url) {
        String jsonBody = """
                         {"availability":"08:00-17:00",
                         "availabilityBranch":"",
                         "deliveryType":["BUYER_PICKUP"],
                         "estimatedDeliveryTime":[],
                         "flexibleDeliveryOptions":[],
                         "freeDeliveryRange":"",
                         "maxDeliveryRange":"",
                         "minFreeDeliveryOrder":"",
                         "perMileCost":""}
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

    @Then("User verifies success message {int}")
    public void user_verifies_success_message(Integer int1) {
        Integer actualstatusCode = response.getStatusCode();
        Assert.assertEquals(actualstatusCode, int1);
    }

}
