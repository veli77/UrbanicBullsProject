package stepDefinitions.API_StepDefs;

import com.github.javafaker.Faker;
import enums.USERCREDENTIAL;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utilities.API_Utils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.API_Utils.response;

public class US_136_DeleteEvents_StepDefs {

    Faker faker = new Faker();
    RequestSpecification requestSpecification = API_Utils.preSetUp(USERCREDENTIAL.USER3).contentType(ContentType.JSON);
    @When("user can add a event at {string}")
    public void user_can_add_a_event_at(String pathParam) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("title", faker.name().title());
        parameters.put("date", "2023-10-20T23:59");
        parameters.put("fee ", 123);
        parameters.put("duration", 60);
        parameters.put("attendeeLimit", 100);
        parameters.put("addressId", 3194);
        parameters.put("tac", "");
        parameters.put("schedule", "");
        parameters.put("description", "");
        response = given()
                .spec(requestSpecification).contentType(ContentType.JSON)
                .body(parameters)
                .when()
                .post(pathParam)
        ;
        response.prettyPrint();
    }
    @Then("the user should be able to add a event")
    public void the_user_should_be_able_to_add_a_event() {
        JsonPath jpath = response.jsonPath();

        String actualData = jpath.getString("descr");
        String expectedData = "Event created";
        Assert.assertEquals(expectedData,actualData);
    }
    @Then("the user should be able to delete the event {string}")
    public void the_user_should_be_able_to_delete_the_event(String pathParam) {
        Map<String, Object> body = new HashMap<>();
        body.put("eventId",873);

        response=  given()
                .spec(requestSpecification).contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(pathParam)//Swagger dok da her islem post olarak yazilmis, o nedenle post yazdik
        ;
        response.prettyPrint();

        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(200,actualStatusCode);

        JsonPath jpath = response.jsonPath();

        String actualData = jpath.getString("descr");
        String expectedData = "Event deleted";
        Assert.assertEquals(expectedData,actualData);
    }
}
