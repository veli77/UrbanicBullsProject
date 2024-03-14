package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_107_DeleteAddress_StepDefs {
    @Given("User connects to the {string} and add a address")
    public void userConnectsToTheAndAddAAddress(String url) {

        String jsonBody="{\n" +
                "    \"isDefault\": false,\n" +
                "    \"isSellerAddress\": false,\n" +
                "    \"isEventAddress\": true,\n" +
                "    \"title\": \"sample\",\n" +
                "    \"address\": \"20001 Winter Ln, Saratoga, CA 95070, Amerika Birleşik Devletleri\",\n" +
                "    \"city\": \"Saratoga\",\n" +
                "    \"state\": \"Santa Clara County\",\n" +
                "    \"postal\": \"95070\"\n" +
                "}";

        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body(jsonBody)
                .when()
                .post(url)
                .prettyPeek();



    }


    @Then("User deletes added address and verifies success message")
    public void userDeletesAddedAddressAndVerifiesSuccessMessage() {

        String addedAddress = response.body().jsonPath().getString("address.id");


        String deletingBody = "{\n" +
                "    \"addressId\": "+addedAddress +
                "\n}";

        Response response1 = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body(deletingBody)
                .when()
                .post("https://test.urbanicfarm.com/api/account/address/delete")
                .then()
                .and()
                .statusCode(200)
                .and()
                .contentType("application/json")
                .and()
                .body("success",is(true))
                .body("descr",is("Address deleted"))
                .extract().response()
                .prettyPeek();


    }
}
