package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_106_AddressUpdate_stepDefs {
    @Given("User connect to the {string} and update a address")
    public void user_connect_to_the_and_update_a_address(String url) {
        String jsonBody="""
                   {
            "address": "California, MD, Amerika Birleşik Devletleri",
                     "addressId": 13,
                    "city": "California",
                    "isDefault": true,
                    "isSellerAddress": true,
                    "postal": "95170",
                    "state": "St. Mary's County",
                    "title": "Emily's HomeOffice"
        }
        """;

        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body(jsonBody)
                .when()
                .post(url)
                .prettyPeek();

    }
}
