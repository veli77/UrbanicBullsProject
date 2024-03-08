package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_110_ChangeDelivery_StepDefs {

    @Given("user connect to {string}")
    public void userConnectTo(String url) {

        String jsonBody = """
              
                {"availability":"",
                "availabilityBranch":"",
                "deliveryType":["SELLER_DELIVERY"],
                "estimatedDeliveryTime":["60_9"],
                "flexibleDeliveryOptions":[],
                "freeDeliveryRange":100,
                "maxDeliveryRange":200,
                "minFreeDeliveryOrder":15,
                "perMileCost":1}
                
                """;

        response = given().
                contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body(jsonBody)
                .when()
                .post(url)
                .prettyPeek();

    }

}
