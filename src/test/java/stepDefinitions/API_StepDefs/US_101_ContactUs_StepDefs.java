package stepDefinitions.API_StepDefs;

import enums.URL_LINKS;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import utilities.ReusableMethods;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.response;

public class US_101_ContactUs_StepDefs {

    Map<String,String> map = new HashMap<String,String>();


    @Given("user goes to the contact us page")
    public void user_goes_to_the_contact_us_page() {

        map.put("name:", ReusableMethods.randomText(5));
        map.put("email:", ReusableMethods.randomEmail(5));
        map.put("subject:", ReusableMethods.randomText(5));
        map.put("message:", ReusableMethods.randomText(12));


        response= given()
                .contentType(ContentType.JSON)
                .body(map)
                .when()
                .post(URL_LINKS.CONTACTUSPAGE_URL.getLink());

        response.prettyPeek();
        response.prettyPrint();

    }
}
