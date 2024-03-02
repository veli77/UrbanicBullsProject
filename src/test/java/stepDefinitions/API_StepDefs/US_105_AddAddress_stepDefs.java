package stepDefinitions.API_StepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.junit.Assert;
import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_105_AddAddress_stepDefs {

    @Given("User connect to the {string} and add a address")
    public void user_connect_to_the_and_add_a_address(String url) {
        String jsonBody="""
            {
            "address": "California, MD, Amerika Birleşik Devletleri",
                    "city": "California",
                    "isDefault": true,
                    "isSellerAddress": true,
                    "postal": "95170",
                    "state": "St. Mary's County",
                    "title": "Emily's Shop"
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

    @Then("User verifies success message")
    public void user_verifies_success_message() {
        int actualstatusCode = response.getStatusCode();
        Assert.assertEquals( actualstatusCode,200);
    }


}
