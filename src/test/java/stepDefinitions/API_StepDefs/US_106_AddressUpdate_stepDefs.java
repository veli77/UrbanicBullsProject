package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_106_AddressUpdate_stepDefs {

    private static String addedAddress = response.body().jsonPath().getString("address.id");
    @Given("User connect to the {string} and update a address")
    public void user_connect_to_the_and_update_a_address(String url) {


        String jsonBody="{\n" +
                "    \"address\": \"California, MD, Amerika Birleşik Devletleri\",\n" +
                "    \"addressId\": "+addedAddress+",\n" +
                "    \"city\": \"California\",\n" +
                "    \"isDefault\": true,\n" +
                "    \"isSellerAddress\": false,\n" +
                "    \"postal\": \"95170\",\n" +
                "    \"state\": \"St. Mary's County\",\n" +
                "    \"title\": \"Emily's HomeOffice\"\n" +
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

    @Given("User delete the added address")
    public void userDeleteTheAddedAddress() {
        String deletingBody = "{\n" +
                "    \"addressId\": "+addedAddress +
                "\n}";

        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body(deletingBody)
                .when()
                .post("https://test.urbanicfarm.com/api/account/address/delete");
//                .then()
//                .and()
//                .statusCode(200)
//                .and()
//                .contentType("application/json")
//                .and()
//                .body("success",is(true))
//                .body("descr",is("Address deleted"))
//                .extract().response()

                response.prettyPeek();
    }
}
