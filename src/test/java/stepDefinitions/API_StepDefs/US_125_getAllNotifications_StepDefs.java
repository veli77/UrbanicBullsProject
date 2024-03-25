package stepDefinitions.API_StepDefs;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import utilities.API_Utils;

import static io.restassured.RestAssured.given;
import static utilities.API_Utils.response;

public class US_125_getAllNotifications_StepDefs {
    @When("user get all notification {string}")
    public void user_get_all_notification(String endPoint) {
        RequestSpecification requestSpecification = API_Utils.preSetUp(USERCREDENTIAL.USER3);
        response = given().
                spec(requestSpecification).
                when().post(endPoint);
    }
}
