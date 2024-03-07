package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static stepDefinitions.Hooks.response;


public class US_114_GetHubInformation_StepDefs {

    String tokencanli;
    String hubName;
    @Given("User connects to the {string}")
    public void user_connect_to_the(String endpoint) {
        response = given()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"seller_urban@mailsac.com\",\"password\": \"VHt*zzt*wQNu6XS\"}")
                .when()
                .post(endpoint);

        JsonPath jsonPath = response.jsonPath();
        tokencanli = jsonPath.getString("token");
    }

    @When("User gets hub information details")
    public void userGetsHubInformationDetails() {

        response =  given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(tokencanli)
                .when()
                .post("https://test.urbanicfarm.com/api/account/hub/getMyHubs");

    }
    @Then("User verifies status code and hub information details")
    public void userVerifiesStatusCodeAndHubInformationDetails() {

        int actualStatusCode = response.getStatusCode();
        assertEquals(200, actualStatusCode);

        JsonPath jsonPath = response.jsonPath();

        List<Object> myList;
        myList = jsonPath.getList("hubs");
        System.out.println(myList.size());
        System.out.println(myList.getFirst());
        assertFalse(myList.isEmpty());

        List<Object> myListId;
        myListId = jsonPath.getList("hubs.uniqueName");
        hubName = (String) myListId.get(0);
        System.out.println(hubName);
    }

    @Then("User gets first hub information and verifies it")
    public void userGetsFirstHubInformationAndVerifiesIt() {
        response =  given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(tokencanli)
                .when()
                .post("https://test.urbanicfarm.com/api/account/hub/getHubDetails/"+ hubName);


        int actualStatusCode = response.getStatusCode();
        assertEquals(200, actualStatusCode);

        JsonPath jsonPath = response.jsonPath();
        String ActualHubName = jsonPath.getString("uniqueName");
        System.out.println(ActualHubName);
        Assert.assertEquals(hubName, ActualHubName);
    }
}