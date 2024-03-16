package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.token;

public class US_200_GetProductRequests_StepDefs {

    Response response;
    Random random = new Random();
    String RandomHubsName;

    @When("User selects a certain hub")
    public void userSelectsACertainHub() {
        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .when()
                .post("https://test.urbanicfarm.com/api/account/hub/getMyHubs");

        JsonPath jsonPath = response.jsonPath();
        //Printing all hubs names
        System.out.println(jsonPath.getList("hubs.uniqueName"));
        //Creating a list of hubs names and selecting a random hubs from the list
        List<String> HubsList = jsonPath.getList("hubs.uniqueName");
        System.out.println(HubsList.size());
        int randomIndex = random.nextInt(HubsList.size());
        System.out.println(randomIndex);
        RandomHubsName = HubsList.get(randomIndex);
    }

    @When("User gets product requests for a certain hub")
    public void userGetsProductRequestsForACertainHub() {
        //Inserting the randomHubName chosen above into the body of request and sending the request
        Map<String, String> map = new HashMap<>();
        map.put("relatedHub", RandomHubsName);
        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body(map)
                .when()
                .post("https://test.urbanicfarm.com/api/account/getProductRequests");

    }

    @Then("User verifies the status code and response content")
    public void userVerifiesTheStatusCodeAndResponseContent() {

        //Printing the response
        response.prettyPrint();

        //The first way to test status code and response content
        int actualStatusCode = response.getStatusCode();
        assertEquals(200, actualStatusCode);

        Assert.assertTrue(response.body().asString().contains("productRequests"));

        //The second way to test status code and response content
        response.then()
                .assertThat()
                .statusCode(200)
                .and()
                .body(containsString("productRequests"));

    }
}