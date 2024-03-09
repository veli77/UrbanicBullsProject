package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_113_CreateAhub_stepDefs {
    @Given("User connect to the {string} and create a hub")
    public void user_connect_to_the_and_create_a_hub(String url) {
        String jsonBody="""
                {
                  "hubUniqueName": "Mely"
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


