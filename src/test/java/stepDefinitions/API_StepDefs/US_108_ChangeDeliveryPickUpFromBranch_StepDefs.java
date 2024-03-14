package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_108_ChangeDeliveryPickUpFromBranch_StepDefs {

    String jsonBody = "{\n" +
            "    \"availability\": \"\",\n" +
            "    \"availabilityBranch\": \"09:00-20:00\",\n" +
            "    \"deliveryType\": [\n" +
            "        \"BUYER_PICKUP_FROM_BRANCH\"\n" +
            "    ],\n" +
            "    \"estimatedDeliveryTime\": [],\n" +
            "    \"flexibleDeliveryOptions\": [],\n" +
            "    \"freeDeliveryRange\": \"\",\n" +
            "    \"maxDeliveryRange\": \"\",\n" +
            "    \"minFreeDeliveryOrder\": \"\",\n" +
            "    \"perMileCost\": \"\"\n" +
            "}";

    String url = "https://test.urbanicfarm.com/api/account/change/delivery";

    @Given("User gets and changes the delivery modalities for pick up from branch")
    public void userGetsAndChangesTheDeliveryModalitiesForPickUpFromBranch() {
        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body(jsonBody)
                .when()
                .post(url)
                .prettyPeek();

    }

    @Then("User verifies that delivery modalities have been changed")
    public void userVerifiesThatDeliveryModalitiesHaveBeenChanged() {
        int actualStatusCode = response.getStatusCode();
        assertEquals(200, actualStatusCode);

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getString("success"));
        assertEquals(true, jsonPath.get("success"));
    }
}
