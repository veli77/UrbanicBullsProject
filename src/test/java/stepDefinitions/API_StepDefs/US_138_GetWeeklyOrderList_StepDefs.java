package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_138_GetWeeklyOrderList_StepDefs {
    @When("User gets weekly order list")
    public void userGetsWeeklyOrderList() {
        response =  given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .when()
                .post("https://test.urbanicfarm.com/api/account/weeklyorder/getWeeklyOrderList");
    }

    @Then("User verifies status code and main keys for weekly order list")
    public void userVerifiesStatusCodeAndMainKeysForWeeklyOrderList() {
        int actualStatusCode = response.getStatusCode();
        assertEquals(200, actualStatusCode);

        JsonPath jsonPath = response.jsonPath();

        List<Object> myListId;
        myListId = jsonPath.getList("id");
        System.out.println(myListId);
        assertFalse(myListId.isEmpty());

        List<Object> myListTitle;
        myListTitle = jsonPath.getList("title");
        System.out.println(myListTitle);
        assertFalse(myListTitle.isEmpty());
    }
}
