package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.response;

public class US_103_ChangePhoneNumber {

    Map<String, String> map = new HashMap<String, String>();
    String token1;

    @Given("User connects to the site")
    public void userConnectsToTheSite() {
        response = given()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"seller_urban@mailsac.com\",\"password\": \"VHt*zzt*wQNu6XS\"}")
                .when()
                .post("https://test.urbanicfarm.com/api/public/login");

        JsonPath jsonPath = response.jsonPath();
        token1 = jsonPath.getString("token");
    }

    @When("User changes the phone number")
    public void userChangesThePhoneNumber() {

        map.put("first_name", "Ahmet");
        map.put("middle_name", "Mehmet");
        map.put("last_name", "Demir");
        map.put("new_phone", "+40 4444 444444");

        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token1)
                .body(map)
                .when()
                .post("https://test.urbanicfarm.com/api/account/change/phone");

        response.prettyPeek();
    }

    @Then("User verifies that phone number has been changed")
    public void userVerifiesThatPhoneNumberHasBeenChanged() {

        int actualStatusCode = response.getStatusCode();
        assertEquals(200, actualStatusCode);

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getString("success"));
        assertEquals(true, jsonPath.get("success"));

        Assert.assertEquals("+40 4444 444444", jsonPath.getString("phone"));
    }
}
