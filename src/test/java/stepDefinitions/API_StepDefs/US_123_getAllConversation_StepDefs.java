package stepDefinitions.API_StepDefs;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.*;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utilities.API_Utils;

import static io.restassured.RestAssured.given;
import static utilities.API_Utils.response;

public class US_123_getAllConversation_StepDefs {

    @When("user get the all conversation {string}")
    public void user_get_the_all_conversation(String endPoint) {
        RequestSpecification requestSpecification = API_Utils.preSetUp(USERCREDENTIAL.USER3);
        response = given().
                spec(requestSpecification).
                when().post(endPoint);
    }
    @Then("user verifies status code {int} response from API utilities")
    public void user_verifies_status_code_response_from_api_utilities(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);

    }
}
