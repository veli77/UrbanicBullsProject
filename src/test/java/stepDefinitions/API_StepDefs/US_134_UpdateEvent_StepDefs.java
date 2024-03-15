package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_134_UpdateEvent_StepDefs {
    @When("User connects {string} and creates an event")
    public void userConnectsAndCreatesAnEvent(String url) {

        Map <String,String> eventInfo = new LinkedHashMap<>();
        eventInfo.put("title","Huge Event");
        eventInfo.put("date","2024-12-12T19:00");
        eventInfo.put("fee","10");
        eventInfo.put("isRefundable","false");
        eventInfo.put("refundableUpToDay","0");
        eventInfo.put("duration","120");
        eventInfo.put("attendeeLimit","250");
        eventInfo.put("schedule","Dinner Event");
        eventInfo.put("description","Dinner meeting");
        eventInfo.put("addressId","3210");
        eventInfo.put("tac","Attendance Compulsory");
        eventInfo.put("null","null");





        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body(eventInfo)
                .when()
                .post(url)
                .prettyPeek();


    }

    @And("User connects {string}")
    public void userConnects(String url) {

        String createdEventId = response.jsonPath().getString("event.id");

        Map <String,String> eventInfo = new LinkedHashMap<>();
        eventInfo.put("title","Huge Event");
        eventInfo.put("date","2024-12-12T19:00");
        eventInfo.put("fee","10");
        eventInfo.put("isRefundable","false");
        eventInfo.put("refundableUpToDay","0");
        eventInfo.put("duration","90");
        eventInfo.put("attendeeLimit","250");
        eventInfo.put("schedule","Dinner Event");
        eventInfo.put("description","Dinner meeting");
        eventInfo.put("addressId","3210");
        eventInfo.put("tac","Attendance Compulsory");
        eventInfo.put("eventId",createdEventId);





        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body(eventInfo)
                .when()
                .post(url)
                .prettyPeek();

    }

    @Then("User should be able to update event and see event updated message")
    public void userShouldBeAbleToUpdateEventAndSeeEventUpdatedMessage() {


        response.then()
                .and()
                .statusCode(200)
                .and()
                .contentType("application/json")
                .and()
                .body("success",is(true))
                .body("descr",is("Event updated"))
                .extract().response()
                .prettyPeek();



    }

    @And("User deletes updated event")
    public void userDeletesUpdatedEvent() {

        String updatedEventId = response.jsonPath().getString("event.id");

        String deletingBody = "{\n" +
                "    \"eventId\": " +updatedEventId+
                "\n}";

        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .body(deletingBody)
                .when()
                .post("https://test.urbanicfarm.com/api/account/event/delete")
                .then()
                .and()
                .statusCode(200)
                .and()
                .contentType("application/json")
                .and()
                .body("success",is(true))
                .body("descr",is("Event deleted"))
                .extract().response()
                .prettyPeek();
    }
}
