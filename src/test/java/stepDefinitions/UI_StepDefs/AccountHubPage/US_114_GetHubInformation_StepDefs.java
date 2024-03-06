package stepDefinitions.UI_StepDefs.AccountHubPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_114_GetHubInformation_StepDefs {
    @When("User gets hub information details")
    public void userGetsHubInformationDetails() {

        response =  given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .when()
                .post("https://urbanicfarm.com/api/account/hub/getMyHubs");

    }
    @Then("User verifies status code and hub information details")
    public void userVerifiesStatusCodeAndHubInformationDetails() {

        int actualStatusCode = response.getStatusCode();
        assertEquals(200, actualStatusCode);

        JsonPath jsonPath = response.jsonPath();

        List<Object> myList = new ArrayList<>();
        myList = jsonPath.getList("hubs");
        System.out.println(myList.size());
        System.out.println(myList.getFirst());
        assertFalse(myList.isEmpty());
        myList.get(Integer.parseInt("id"));
        myList.get(0).toString();
    }
}
