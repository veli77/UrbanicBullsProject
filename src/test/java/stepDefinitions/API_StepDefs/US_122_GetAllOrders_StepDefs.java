package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_122_GetAllOrders_StepDefs {

    String url = "https://test.urbanicfarm.com/api/account/order/get/myBuys";
    JsonPath jsonPath = response.jsonPath();


    @When("User gets information on all of the orders")
    public void userGetsInformationOnAllOfTheOrders() {

        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .when()
                .post(url);
    }

    @Then("User verifies the status code and response content for all of the orders")
    public void userVerifiesTheStatusCodeAndResponseContentForAllOfTheOrders() {

        int actualStatusCode = response.getStatusCode();
        assertEquals(200, actualStatusCode);

        JsonPath jsonPath = response.jsonPath();
        Assert.assertTrue(jsonPath.get().toString().contains("id"));

        Map<String, List<Object>> idMap = new HashMap<>();
        List<Object> idList = jsonPath.getList("id");
        List<Object> FirstNameList = jsonPath.getList("firstName");
        List<Object> LastNameList = jsonPath.getList("lastName");

        idMap.put("id :", idList);
        idMap.put("firstName :", FirstNameList);
        idMap.put("lastName :", LastNameList);

        // Header
        System.out.printf("%-10s | %-15s | %-15s\n", "id :", "firstName :", "lastName :");
        System.out.println("------------------------------------------");

        // Data
        int size = idMap.get("id :").size();
        for (int i = 0; i < size; i++) {
            System.out.printf("%-10s | %-15s | %-15s\n",
                    idMap.get("id :").get(i),
                    idMap.get("firstName :").get(i),
                    idMap.get("lastName :").get(i));
        }
    }
}